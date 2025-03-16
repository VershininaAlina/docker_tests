package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.AllureUtils.takeScreenshot;

public class CartPage {

    WebDriver driver;
    By cartItem = By.cssSelector("#shopping_cart_container");
    public By tittleProduct = By.cssSelector(".inventory_item_name");
    By bottomRemoveInCart = By.cssSelector("#remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Забираем заголовок первого товара  в корзине")
    public String getFirstTitleInCart() {
        return driver.findElements(tittleProduct).get(0).getText();
    }

    @Step("Забираем заголовок второго товара  в корзин")
    public String getSecondTitleInCart() {
        return driver.findElements(tittleProduct).get(1).getText();
    }

    @Step("Проверяем первый элемент")
    public boolean checkItemFirst() {
        return driver.findElements(tittleProduct).isEmpty();
    }

    @Step("Удаляем товар из корзины")
    public void removeProductionCart() {
        driver.findElement(bottomRemoveInCart).click();
    }


}
