package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OnlinePaymentBlock;
import pages.PaymentBlock;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@TestMethodOrder(OrderAnnotation.class)
public class OnlinePaymentBlockTest {
    static WebDriver driver;
    OnlinePaymentBlock onlinePaymentBlock;
    PaymentBlock paymentBlock;

    public static void closeCookie() {
        WebElement cookieCloseButton = driver.findElement(By.xpath("//button[contains(@class, \"btn btn_gray cookie__cancel\")]"));
        if (cookieCloseButton.isDisplayed()) {
            cookieCloseButton.click();
        }
    }

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        closeCookie();
        onlinePaymentBlock = new OnlinePaymentBlock(driver);
        paymentBlock = new PaymentBlock(driver);
    }

    @AfterEach
    public void end() {
        driver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("Name of the OnlinePaymentBlock is equal \"Онлайн пополнение без комиссии\"")
    public void testNameOfTheOnlinePaymentBlock() {
        String expectedNameOfBlock = "Онлайн пополнение\nбез комиссии";
        String title = onlinePaymentBlock.getOnlinePaymentBlockTitle();
        Assertions.assertEquals(expectedNameOfBlock, title);
    }

    @Test
    @Order(2)
    @DisplayName("Visa logo is present in the block")
    public void testPaymentSystemsLogo1() {
        Assertions.assertTrue(onlinePaymentBlock.isVisaLogoDisplayed());
    }

    @Test
    @Order(3)
    @DisplayName("Verified By Visa logo is present in the block")
    public void testPaymentSystemsLogo2() {
        Assertions.assertTrue(onlinePaymentBlock.isVerifiedByVisaLogoDisplayed());
    }

    @Test
    @Order(4)
    @DisplayName("MasterCard logo is present in the block")
    public void testPaymentSystemsLogo3() {
        Assertions.assertTrue(onlinePaymentBlock.isMasterCardLogoDisplayed());
    }

    @Test
    @Order(5)
    @DisplayName("MasterCard Secure Code logo is present in the block")
    public void testPaymentSystemsLogo4() {
        Assertions.assertTrue(onlinePaymentBlock.isMasterCardSecureCodeLogoDisplayed());
    }

    @Test
    @Order(6)
    @DisplayName("Белкарт logo is present in the block")
    public void testPaymentSystemsLogo5() {
        Assertions.assertTrue(onlinePaymentBlock.isBelCartLogoDisplayed());
    }

    @Test
    @Order(7)
    @DisplayName("Check that 'More about service' link is working")
    public void testMoreAboutServiceLink() {
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        onlinePaymentBlock.clickMoreAboutServiceLink();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    @Order(8)
    @DisplayName("Check that Continue button works. Sum, number and placeholder are correct. Payment logos are displayed")
    public void testContinueButton() {
        String testAmount = "12.55";
        String testNumber = "297777777";
        String expectedCardNumberPlaceHolder = "Номер карты";
        String expectedIssuedTillPlaceholder = "Срок действия";
        String expectedCvcPlaceholder = "CVC";
        String expectedCardHolderNamePlaceholder = "Имя держателя (как на карте)";
        paymentBlock.enterPhoneNumber(testNumber);
        paymentBlock.enterAmount(testAmount);
        paymentBlock.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualAmountInHeader = paymentBlock.getPaymentAmount(wait);
        String actualNumber = paymentBlock.getPhoneNumber();
        String actualAmountContinueButton = paymentBlock.getPaymentAmountFromContinueButton();
        String actualCardNumberPlaceholder = paymentBlock.getCardNumberPlaceholder();
        String actualIssuedTillPlaceholder = paymentBlock.getIssuedTillPlaceholder();
        String actualCvcPlaceholder = paymentBlock.getCvcPlaceholder();
        String actualCardHolderNamePlaceholder = paymentBlock.getCardHolderNamePlaceholder();
        Assertions.assertEquals(testAmount + " BYN", actualAmountInHeader);
        Assertions.assertEquals("Оплата: Услуги связи Номер:375" + testNumber, actualNumber);
        Assertions.assertEquals("Оплатить " + testAmount + " BYN", actualAmountContinueButton);
        Assertions.assertEquals(expectedCardNumberPlaceHolder, actualCardNumberPlaceholder);
        Assertions.assertEquals(expectedIssuedTillPlaceholder, actualIssuedTillPlaceholder);
        Assertions.assertEquals(expectedCvcPlaceholder, actualCvcPlaceholder);
        Assertions.assertEquals(expectedCardHolderNamePlaceholder, actualCardHolderNamePlaceholder);
        Assertions.assertTrue(paymentBlock.isVisaLogoDisplayed());
        Assertions.assertTrue(paymentBlock.isMasterCardLogoDisplayed());
        Assertions.assertTrue(paymentBlock.isBelCartLogoDisplayed());
        Assertions.assertTrue(paymentBlock.isMirLogoDisplayed());
    }

    @Test
    @Order(9)
    @DisplayName("Check placeholders values for Connection payment option")
    public void testConnectionPlaceholdersValues() {
        String expectedPhoneNumberPlaceholder = "Номер телефона";
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        String[] connectionPlaceholders = onlinePaymentBlock.returnConnectionPlaceholders();
        Assertions.assertEquals(expectedPhoneNumberPlaceholder, connectionPlaceholders[0]);
        Assertions.assertEquals(expectedSumPlaceholder, connectionPlaceholders[1]);
        Assertions.assertEquals(expectedEmailPlaceholder, connectionPlaceholders[2]);
    }

    @Test
    @Order(10)
    @DisplayName("Check placeholders values for Home Internet payment option")
    public void testHomeInternetPlaceholdersValues() {
        String expectedPhoneNumberPlaceholder = "Номер абонента";
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        String[] homeInternetPlaceholders = onlinePaymentBlock.returnHomeInternetPlaceholders();
        Assertions.assertEquals(expectedPhoneNumberPlaceholder, homeInternetPlaceholders[0]);
        Assertions.assertEquals(expectedSumPlaceholder, homeInternetPlaceholders[1]);
        Assertions.assertEquals(expectedEmailPlaceholder, homeInternetPlaceholders[2]);
    }

    @Test
    @Order(11)
    @DisplayName("Check placeholders values for Installment payment option")
    public void testInstallmentPlaceholdersValues() {
        String expectedAccountNumberPlaceholder = "Номер счета на 44";
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        String[] installmentPlaceholders = onlinePaymentBlock.returnInstallmentPlaceholders();
        Assertions.assertEquals(expectedAccountNumberPlaceholder, installmentPlaceholders[0]);
        Assertions.assertEquals(expectedSumPlaceholder, installmentPlaceholders[1]);
        Assertions.assertEquals(expectedEmailPlaceholder, installmentPlaceholders[2]);
    }

    @Test
    @Order(12)
    @DisplayName("Check placeholders values for Dept payment option")
    public void testDeptPlaceholdersValues() {
        String expectedAccountNumberPlaceholder = "Номер счета на 2073";
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        String[] deptPlaceholders = onlinePaymentBlock.returnDeptPlaceholders();
        Assertions.assertEquals(expectedAccountNumberPlaceholder, deptPlaceholders[0]);
        Assertions.assertEquals(expectedSumPlaceholder, deptPlaceholders[1]);
        Assertions.assertEquals(expectedEmailPlaceholder, deptPlaceholders[2]);
    }
}