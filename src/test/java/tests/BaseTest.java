package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.BurgerMenuPage;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


@Listeners(TestListener.class)

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    BurgerMenuPage burgerMenuPage;
    ProductsPage productsPage;
    CartPage cartPage;


    @BeforeMethod
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", true);
        }});
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        loginPage = new LoginPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
