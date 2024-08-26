import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@TestMethodOrder(OrderAnnotation.class)
public class OnlinePaymentBlockTest {
    static WebDriver driver;

    public static void closeCookie() {
        WebElement cookieCloseButton = driver.findElement(By.xpath("//button[contains(@class, \"btn btn_gray cookie__cancel\")]"));
        if (cookieCloseButton.isDisplayed()) {
            cookieCloseButton.click();
        }
    }

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        closeCookie();
    }

    @AfterEach
    public void end() {
        driver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("Name of the OnlinePaymentBlock is equal \"Онлайн пополнение без комиссии\"")
    public void testNameOfTheOnlinePaymentBlock() {
        String nameOfBlock = "Онлайн пополнение\nбез комиссии";
        String title = driver.findElement(By.xpath("//div[contains(@class, \"pay__wrapper\")]/h2")).getText();
        Assertions.assertEquals(nameOfBlock, title);
    }

    @Test
    @Order(2)
    @DisplayName("Visa logo is present in the block")
    public void testPaymentSystemsLogo1() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Visa\"]"));
        Assertions.assertTrue(logo.isDisplayed());
    }

    @Test
    @Order(3)
    @DisplayName("Verified By Visa logo is present in the block")
    public void testPaymentSystemsLogo2() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Verified By Visa\"]"));
        Assertions.assertTrue(logo.isDisplayed());
    }

    @Test
    @Order(4)
    @DisplayName("MasterCard logo is present in the block")
    public void testPaymentSystemsLogo3() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"MasterCard\"]"));
        Assertions.assertTrue(logo.isDisplayed());
    }

    @Test
    @Order(5)
    @DisplayName("MasterCard Secure Code logo is present in the block")
    public void testPaymentSystemsLogo4() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"MasterCard Secure Code\"]"));
        Assertions.assertTrue(logo.isDisplayed());
    }

    @Test
    @Order(6)
    @DisplayName("Белкарт logo is present in the block")
    public void testPaymentSystemsLogo5() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Белкарт\"]"));
        Assertions.assertTrue(logo.isDisplayed());
    }

    @Test
    @Order(7)
    @DisplayName("Check that 'More about service' link is working")
    public void testMoreAboutServiceLink() {
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        driver.findElement(By.linkText("Подробнее о сервисе")).click();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    @Order(8)
    @DisplayName("Check that button \"Продолжить\" works")
    public void testContinueButton() {
        String testAmount = "12.55";
        String testNumber = "297777777";
        driver.findElement(By.id("connection-phone")).sendKeys(testNumber);
        driver.findElement(By.id("connection-sum")).sendKeys(testAmount);
        driver.findElement(By.xpath("//button[contains(text(), \"Продолжить\")]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(paymentIframe);
        WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__cost']/span[1]")));
        String actualAmount = amount.getText();
        WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span[1]")));
        String actualNumber = number.getText();
        Assertions.assertEquals(testAmount + " BYN", actualAmount);
        Assertions.assertEquals("Оплата: Услуги связи Номер:375" + testNumber, actualNumber);
        driver.switchTo().defaultContent();
    }
}
