package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentBlock {
    WebDriver driver;

    private By phoneInput = By.id("connection-phone");
    private By sumInput = By.id("connection-sum");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");
    private By iframe = By.xpath("//iframe[@class='bepaid-iframe']");
    private By paymentSumInHeader = By.xpath("//div[@class='pay-description__cost']/span[1]");
    private By phoneNumber = By.xpath("//div[@class='pay-description__text']/span[1]");
    private By continueButtonOnPaymentBlock = By.xpath("//div[@class=\"card-page__card\"]/button");
    private By cardNumberField = By.xpath("//input[@id=\"cc-number\"]/following::label[1]");
    private By issuedTillField = By.xpath("//input[@id=\"cc-number\"]/following::label[2]");
    private By cvcField = By.xpath("//input[@id=\"cc-number\"]/following::label[3]");
    private By cardHolderName = By.xpath("//input[@id=\"cc-number\"]/following::label[4]");
    private By visaLogoPaymentBlock = By.xpath("//img[@class=\"ng-tns-c61-0 ng-star-inserted\"][1]");
    private By masterCardLogoPaymentBlock = By.xpath("//img[@class=\"ng-tns-c61-0 ng-star-inserted\"][2]");
    private By belkartLogoPaymentBlock = By.xpath("//img[@class=\"ng-tns-c61-0 ng-star-inserted\"][3]");
    private By mirLogoPaymentBlock = By.xpath("//div[@class=\"cards-brands cards-brands_random ng-tns-c61-0 ng-star-inserted\"]/img[1]");

    public PaymentBlock(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneInput).sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        driver.findElement(sumInput).sendKeys(amount);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getPaymentAmount(WebDriverWait wait) {
        WebElement paymentIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframe));
        driver.switchTo().frame(paymentIframe);
        WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentSumInHeader));
        return amount.getText();
    }

    public String getPhoneNumber() {
        return driver.findElement(phoneNumber).getText();
    }

    public String getPaymentAmountFromContinueButton() {
        return driver.findElement(continueButtonOnPaymentBlock).getText();
    }

    public String getCardNumberPlaceholder() {
        return driver.findElement(cardNumberField).getText();
    }

    public String getIssuedTillPlaceholder() {
        return driver.findElement(issuedTillField).getText();
    }

    public String getCvcPlaceholder() {
        return driver.findElement(cvcField).getText();
    }

    public String getCardHolderNamePlaceholder() {
        return driver.findElement(cardHolderName).getText();
    }

    public boolean isVisaLogoDisplayed() {
        return driver.findElement(visaLogoPaymentBlock).isDisplayed();
    }

    public boolean isMasterCardLogoDisplayed() {
        return driver.findElement(masterCardLogoPaymentBlock).isDisplayed();
    }

    public boolean isBelCartLogoDisplayed() {
        return driver.findElement(belkartLogoPaymentBlock).isDisplayed();
    }

    public boolean isMirLogoDisplayed() {
        return driver.findElement(mirLogoPaymentBlock).isDisplayed();
    }
}

