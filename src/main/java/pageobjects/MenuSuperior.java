package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuSuperior {

    private By shoppingCartLocator = By.xpath("//span[text()='Shopping Cart']");

    WebDriver driver;

    public MenuSuperior(WebDriver _driver){
        this.driver = _driver;
    }

    public void clickShoppingCart(){
        driver.findElement(shoppingCartLocator).click();
    }
}
