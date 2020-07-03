package FinalTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.BaseClass;

public class ProductSearchTestCase extends BaseClass {
    @Description("Add product to cart and verify the flow")
    @Test
    public void TestRegisterNewUser(){
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!";
        String expectedErrorMessage = "Products marked with *** are not available in the desired quantity or not in stock!";
        String itemToSearch = "MacBook";

        headerPage().search(itemToSearch);
        searchResultsPage().srpGetFirstProduct();
        productPage().clickAddToCart();
        String successMessage = productPage().detailPageVerifySuccessAddToCartMessage();
        if (!successMessage.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").equals(expectedSuccessMessage.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""))){
            Assert.fail("The success message is not the expected message; expected: '"+expectedSuccessMessage+"', but found: " + successMessage);
        }
        menuSuperior().clickShoppingCart();
        if (!cartPage().cartPageIsExpectedItemInCart(itemToSearch)){
            Assert.fail("There is not being showed the item that has been added before");
        }
        cartPage().cartPageClickInCheckout();
        String errorMessage = cartPage().cartPageVerifyErrorMessage();
        if (!errorMessage.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").equals(expectedErrorMessage.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""))){
            Assert.fail("The error message at cart page is not the expected message; expected: '"+expectedErrorMessage+"', but found: " + errorMessage);
        }

    }
}
