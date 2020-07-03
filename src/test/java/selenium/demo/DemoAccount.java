package selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoAccount{

    @BeforeTest
    public void setup(){

    }

    @Ignore
    @Test
    public void test_capabilities(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1980,800");
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");
        driver.findElement(By.id("content")).isDisplayed();

//      driver.manage().window().maximize();
    }

    @Ignore
    @Test
    public void test_waits(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");

        driver.findElement(By.id("downloadButton")).click();

        Boolean result = false;
        // manejo de excepciones
        try{
            result = wait.until(
                    ExpectedConditions.textToBe(
                            By.className("progress-label"),
                            "Complete!"));
        }
        catch (WebDriverException ex){
            System.out.println("Not working fine");
        }

        Assert.assertTrue(result,"Progress bar no era valida");
    }

    @Test
    public void drag_and_drop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        Actions actions = new Actions(driver);

        WebElement box1 = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
        WebElement drop = driver.findElement(By.id("mydropzone"));

        actions.dragAndDropBy(box1,20,-5).release().build().perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.perform();

    }

}
