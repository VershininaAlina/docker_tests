package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BurgerMenuPage;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.AllureUtils;

import static utils.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    BurgerMenuPage burgerMenuPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            driver = new FirefoxDriver(options);
        }
        loginPage = new LoginPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()){
            AllureUtils.takeScreenshot(driver);
        }
        driver.quit();
    }
}
