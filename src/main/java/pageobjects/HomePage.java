package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class HomePage extends BasePage{

    private By getFirstProductTitle = By.cssSelector(".caption a");
    private String firstH4By = "//h4/a[text()='<name>']";

    public HomePage(WebDriver _driver){
        super(_driver);
    }

    public String getFirstProductName(){
        return driver.findElement(getFirstProductTitle).getText();
    }

    public String selectFirstProductAndGetName(){
        String firstProduct = getFirstProductName();
        driver.findElement(By.xpath(firstH4By.replace("<name>", firstProduct))).click();
        return firstProduct;
    }

    public void selectProductByName(String name){
        driver.findElement(By.xpath(firstH4By.replace("<name>", name))).click();
    }

}
