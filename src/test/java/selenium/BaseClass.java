package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass extends PageObjectHandler{

    @BeforeTest
    public void setupTest(){
        System.out.println("* Before Test Setup");
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setupMethod(@Optional("chrome") String browser) throws MalformedURLException {
        setInitialConfiguration(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){
        pagesCleanUp();

        System.out.println("** After Method Setup");

        TakeScreenshot(driver);
        driver.close();

        try {
            driver.quit();
        }
        catch (WebDriverException ex){
            System.out.println("Session already closed!");
        }
    }

    private void setInitialConfiguration(String browser) throws MalformedURLException {

//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setBrowserName("chrome");
//        String Node = "http://localhost:4444/wd/hub";
//        driver = new RemoteWebDriver(new URL(Node), cap);

        System.out.println("** Before Method Setup");

        if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--log-level=3");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.get("https://demo.opencart.com/index.php");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}


//npm i -g webdriver-manager