package FinalTests;

import dataproviders.ProductProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ProductData;
import selenium.BaseClass;

public class CostComparisonTestCase extends BaseClass {
    @Description("Verify the cost in json is the same that in the web page")
    @Test(description = "Product cost comparison", dataProvider = "getProductDataFromJson", dataProviderClass = ProductProvider.class)
    public void TestRegisterNewUser(ProductData productData) {
        headerPage().search(productData.getProductName());
        if (!productPage().checkCostUsingJson(productData.getCost(),productData.getProductName())){
            Assert.fail("The cost of the product: "+productData.getProductName()+", is not the expected. Expected value: "+productData.getCost());
        }

    }
}
