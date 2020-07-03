package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    private final By productQuantityLocator = By.id("input-quantity");
    private final By addToCartButtonLocator = By.id("button-cart");
    private final By detailPageSuccessAddToCartMessage = By.cssSelector(".alert.alert-success.alert-dismissible");
    private By priceOfSelectedItem = null;
    public ProductPage(WebDriver _driver){
        super(_driver);
    }

   public void setAmountToAdd(int amount){
       driver.findElement(productQuantityLocator).clear();
       driver.findElement(productQuantityLocator).sendKeys(String.valueOf(amount));
   }

   public void clickAddToCart(){
        driver.findElement(addToCartButtonLocator).click();
   }

   public String detailPageVerifySuccessAddToCartMessage(){
       return driver.findElement(detailPageSuccessAddToCartMessage).getText();
    }


    public Boolean checkCostUsingJson(String cost, String productName) {
        boolean isPriceTheExpected = true;
        priceOfSelectedItem =  By.xpath("//div[@class='product-thumb']//div[@class='caption']//a[text()='"+productName+"']/../..//p[@class='price']");
        if(driver.findElement(priceOfSelectedItem).getText().equals(cost)){
            isPriceTheExpected = false;
        }
        return isPriceTheExpected;
    }
}
