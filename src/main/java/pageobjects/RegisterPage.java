package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{

    //Register account Inputs
    final private By registerPageFirstNameField = By.id("input-firstname");
    final private By registerPageLastNameField = By.id("input-lastname");
    final private By registerPageEmailField = By.id("input-email");
    final private By registerPageTelephoneField = By.id("input-telephone");
    final private By registerPagePasswordField = By.id("input-password");
    final private By registerPageConfirmPasswordField = By.id("input-confirm");

    //Register account other items
    final private By registerPageAgreeTermsAndConditions = By.xpath("//input[@name='agree']");
    final private By registerContinueButton = By.cssSelector(".btn.btn-primary");

    //Register confirmation page
    final private By registerConfirmationPageContinueButton = By.cssSelector("#common-success .btn.btn-primary");


    //Other instances
    WebDriverWait wait = new WebDriverWait(driver,15);


    public RegisterPage (WebDriver _driver){
        super(_driver);
    }

    public void registerNewUser(String firstName, String lastName, String email, String telephone, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerContinueButton));
        driver.findElement(registerPageFirstNameField).sendKeys(firstName);
        driver.findElement(registerPageLastNameField).sendKeys(lastName);
        driver.findElement(registerPageEmailField).sendKeys(email);
        driver.findElement(registerPageTelephoneField).sendKeys(telephone);
        driver.findElement(registerPagePasswordField).sendKeys(password);
        driver.findElement(registerPageConfirmPasswordField).sendKeys(password);
        registerAgreeTermsAndConditions();
        registerClickContinueButton();
    }

    public void registerAgreeTermsAndConditions(){
        driver.findElement(registerPageAgreeTermsAndConditions).click();
    }

    public void registerClickContinueButton(){
        driver.findElement(registerContinueButton).click();
    }

    public void registerCheckConfirmationPageAndContinue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerConfirmationPageContinueButton));
        driver.findElement(registerConfirmationPageContinueButton).click();
    }
}
