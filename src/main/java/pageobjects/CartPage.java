package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.print.DocFlavor;
import java.security.Policy;

public class CartPage {

    private String productRowLocator = "//div[@id='content']//tr[contains(.,'<product>')]";
    private WebElement productRow;

    private By cartProductName = By.xpath("//div[@id='content']//td[@class='text-left']//a");
    private By cartCheckoutButton = By.linkText("Checkout");
    private By cartErrorMessage = By.cssSelector(".alert.alert-danger.alert-dismissible");


    private By inputOnRowLocator = By.cssSelector("input");

    WebDriver driver;

    public CartPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void goTo(){
        MenuSuperior menu = new MenuSuperior(driver);
        menu.clickShoppingCart();
    }

    public boolean isProductOnCartByName(String name){
        productRow = driver.findElement(
                By.xpath(
                        productRowLocator.replace(
                                "<product>",
                                name)));
        return productRow.isDisplayed();
    }

    public int getAmountFromProductRow(){
        String sAmount = productRow.findElement(inputOnRowLocator).getAttribute("value");

        try {
            return Integer.parseInt(sAmount);
        }
        catch (NumberFormatException ex){
            System.out.println("Error al parsear el valor del campo");
            return 0;
        }
    }

    public boolean cartPageIsExpectedItemInCart(String expectedItem){
        boolean isItemOnCart = true;
        if (!driver.findElement(cartProductName).getText().equals(expectedItem)){
            isItemOnCart = false;
        }
        return isItemOnCart;
    }

    public void cartPageClickInCheckout(){
        driver.findElement(cartCheckoutButton).click();
    }

    public String cartPageVerifyErrorMessage(){
        String successMessage = driver.findElement(cartErrorMessage).getText();
        return successMessage;
    }
}
