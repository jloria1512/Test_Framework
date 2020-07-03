package FinalTests;

import dataproviders.UsersProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserAccount;
import selenium.BaseClass;
import utils.DataUtils;

public class RegisterTestCase extends BaseClass {
    @Description("Verify that the web page allows to register new users")
    @Test(description = "Test Register Success", dataProvider = "getUserDataFromJson", dataProviderClass = UsersProvider.class)
    public void TestRegisterNewUser(UserAccount userAccount){
        headerPage().goToRegister();
        registerPage().registerNewUser(userAccount.getFirstName(), userAccount.getLastName(), DataUtils.getRandomEmail(),userAccount.getTelephone(),userAccount.getPassword());
        registerPage().registerCheckConfirmationPageAndContinue();
        if (!headerPage().isLogoutEnabled())
            Assert.fail("The User is not logged in after register");
    }
}
