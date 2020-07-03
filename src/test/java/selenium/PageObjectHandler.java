package selenium;

import org.openqa.selenium.WebDriver;
import pageobjects.*;

public class PageObjectHandler {

    public WebDriver driver;

    private HeaderPage _headerPage;
    private LoginPage _loginPage;
    private SearchResultsPage _resultsPage;
    private HomePage _homePage;
    private ProductPage _productPage;
    private CartPage _cartPage;
    private RegisterPage _registerPage;
    private MenuSuperior _menuSuperior;

    public PageObjectHandler(){

    }

    public void  pagesCleanUp() {
        _headerPage = null;
        _loginPage = null;
        _resultsPage = null;
        _homePage = null;
        _productPage = null;
        _cartPage = null;
        _registerPage = null;
        _menuSuperior = null;
    }

    public MenuSuperior menuSuperior() {
        if (_menuSuperior == null)
            _menuSuperior = new MenuSuperior(driver);
        return _menuSuperior;
    }

    public RegisterPage registerPage() {
        if (_registerPage == null)
            _registerPage = new RegisterPage(driver);
        return _registerPage;
    }

    public HeaderPage headerPage() {
        if (_headerPage == null)
                _headerPage = new HeaderPage(driver);
        return _headerPage;
    }

    public LoginPage loginPage(){
        if (_loginPage == null)
            _loginPage = new LoginPage(driver);
        return _loginPage;
    }

    public SearchResultsPage searchResultsPage(){
        if (_resultsPage == null)
            _resultsPage = new SearchResultsPage(driver);
        return _resultsPage;
    }

    public HomePage homePage(){
        if (_homePage == null)
            _homePage = new HomePage(driver);
        return _homePage;
    }

    public ProductPage productPage(){
        if (_productPage == null)
            _productPage = new ProductPage(driver);
        return _productPage;
    }

    public CartPage cartPage(){
        if (_cartPage == null)
            _cartPage = new CartPage(driver);
        return _cartPage;
    }
}
