package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlinePaymentBlock {
    WebDriver driver;

    private By onlinePaymentBlockTitle = By.xpath("//div[contains(@class, 'pay__wrapper')]/h2");
    private By visaLogo = By.xpath("//img[@alt='Visa']");
    private By verifiedByVisaLogo = By.xpath("//img[@alt='Verified By Visa']");
    private By masterCardLogo = By.xpath("//img[@alt='MasterCard']");
    private By masterCardSecureCodeLogo = By.xpath("//img[@alt='MasterCard Secure Code']");
    private By belkartLogo = By.xpath("//img[@alt='Белкарт']");
    private By moreAboutServiceLink = By.linkText("Подробнее о сервисе");
    private By typesOfPaymentDropdown = By.xpath("//button[@class=\"select__header\"]");
    private By connectionPayment = By.xpath("//p[text()=\"Услуги связи\"]");
    private By homeInternetPayment = By.xpath("//p[text()=\"Домашний интернет\"]");
    private By installmentPayment = By.xpath("//p[text()=\"Рассрочка\"]");
    private By deptPayment = By.xpath("//p[text()=\"Задолженность\"]");
    private By phoneNumberConnectionPlaceholder = By.id("connection-phone");
    private By sumConnectionPlaceholder = By.id("connection-sum");
    private By emailConnectionPlaceholder = By.id("connection-email");
    private By phoneNumberInternetPlaceholder = By.id("internet-phone");
    private By sumInternetPlaceholder = By.id("internet-sum");
    private By emailInternetPlaceholder = By.id("internet-email");
    private By accountNumberInstallmentPlaceholder = By.id("score-instalment");
    private By sumInstallmentPlaceholder = By.id("instalment-sum");
    private By emailInstallmentPlaceholder = By.id("instalment-email");
    private By accountNumberDeptPlaceholder = By.id("score-arrears");
    private By sumDeptPlaceholder = By.id("arrears-sum");
    private By emailDeptPlaceholder = By.id("arrears-email");



    public OnlinePaymentBlock(WebDriver driver) {
        this.driver = driver;
    }

    public String getOnlinePaymentBlockTitle() {
        return driver.findElement(onlinePaymentBlockTitle).getText();
    }

    public boolean isVisaLogoDisplayed() {
        return driver.findElement(visaLogo).isDisplayed();
    }

    public boolean isVerifiedByVisaLogoDisplayed() {
        return driver.findElement(verifiedByVisaLogo).isDisplayed();
    }

    public boolean isMasterCardLogoDisplayed() {
        return driver.findElement(masterCardLogo).isDisplayed();
    }

    public boolean isMasterCardSecureCodeLogoDisplayed() {
        return driver.findElement(masterCardSecureCodeLogo).isDisplayed();
    }

    public boolean isBelCartLogoDisplayed() {
        return driver.findElement(belkartLogo).isDisplayed();
    }

    public void clickMoreAboutServiceLink() {
        driver.findElement(moreAboutServiceLink).click();
    }
    public String[] returnConnectionPlaceholders() {
        driver.findElement(typesOfPaymentDropdown).click();
        driver.findElement(connectionPayment).click();
        String numberPlaceholder = driver.findElement(phoneNumberConnectionPlaceholder).getAttribute("placeholder");
        String sumPlaceholder = driver.findElement(sumConnectionPlaceholder).getAttribute("placeholder");
        String emailPlaceholder = driver.findElement(emailConnectionPlaceholder).getAttribute("placeholder");
        return new String[]{numberPlaceholder, sumPlaceholder, emailPlaceholder};
    }

    public String[] returnHomeInternetPlaceholders() {
        driver.findElement(typesOfPaymentDropdown).click();
        driver.findElement(homeInternetPayment).click();
        String numberPlaceholder = driver.findElement(phoneNumberInternetPlaceholder).getAttribute("placeholder");
        String sumPlaceholder = driver.findElement(sumInternetPlaceholder).getAttribute("placeholder");
        String emailPlaceholder = driver.findElement(emailInternetPlaceholder).getAttribute("placeholder");
        return new String[]{numberPlaceholder, sumPlaceholder, emailPlaceholder};
    }

    public String[] returnInstallmentPlaceholders() {
        driver.findElement(typesOfPaymentDropdown).click();
        driver.findElement(installmentPayment).click();
        String numberPlaceholder = driver.findElement(accountNumberInstallmentPlaceholder).getAttribute("placeholder");
        String sumPlaceholder = driver.findElement(sumInstallmentPlaceholder).getAttribute("placeholder");
        String emailPlaceholder = driver.findElement(emailInstallmentPlaceholder).getAttribute("placeholder");
        return new String[]{numberPlaceholder, sumPlaceholder, emailPlaceholder};
    }

    public String[] returnDeptPlaceholders() {
        driver.findElement(typesOfPaymentDropdown).click();
        driver.findElement(deptPayment).click();
        String numberPlaceholder = driver.findElement(accountNumberDeptPlaceholder).getAttribute("placeholder");
        String sumPlaceholder = driver.findElement(sumDeptPlaceholder).getAttribute("placeholder");
        String emailPlaceholder = driver.findElement(emailDeptPlaceholder).getAttribute("placeholder");
        return new String[]{numberPlaceholder, sumPlaceholder, emailPlaceholder};
    }
}