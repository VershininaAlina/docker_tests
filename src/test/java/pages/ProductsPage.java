package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utils.AllureUtils.takeScreenshot;

public class ProductsPage {
    static WebDriver driver;

    public static By TittlePage = By.cssSelector(".title");


    String buttonAddAndRemove = "//div[text() = '%s']//ancestor::div[@class = 'inventory_item']//button";
    public By tittleFirst = By.xpath("(//div[@class = 'inventory_item_name '])[1]");
    public By tittleSecond = By.xpath("(//div[@class = 'inventory_item_name '])[2]");

    By cartItem = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Добавляем товар в корзину")
    public void addProduct(String product) {
        driver.findElement(By.xpath(String.format(String.valueOf(buttonAddAndRemove), product))).click();

    }

    @Step("Удаляем товар из корзины ")
    public void removeProductInCatalog(String product) {
        driver.findElement(By.xpath(String.format(buttonAddAndRemove, product))).click();

    }

    @Step("Открываем корзину")
    public void openCart() {
        driver.findElement(cartItem).click();

    }

    @Step("Проверка заголовка")
    public String getTittleProductInCatalog(By tittle) {
        driver.get("https://www.saucedemo.com/inventory.html");
        return driver.findElement(tittle).getText();

    }
    @Step("Проверка заголовка")
    public static String getTittleInPage(By tittle) {
        return driver.findElement(tittle).getText();

    }

}
