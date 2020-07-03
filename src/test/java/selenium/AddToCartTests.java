package selenium;

import dataproviders.UsersProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserAccount;


public class AddToCartTests extends BaseClass {



    @Description("Verify that add to cart works fine")
    @Test(description = "Add to Cart Test")
    public void Test_Add_To_Cart_Successful(){

         int testAmount = 2;

         String testProduct = homePage().selectFirstProductAndGetName(); // homePage().selectProductByName(testProduct);

         productPage().setAmountToAdd(testAmount);
         productPage().clickAddToCart();

         Assert.assertTrue(productPage().isSuccessMessageVisibleWithText(testProduct));

         cartPage().goTo();

        Assert.assertTrue(cartPage().isProductOnCartByName(testProduct));
        Assert.assertEquals(cartPage().getAmountFromProductRow(), testAmount);
    }

}
