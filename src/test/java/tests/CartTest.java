package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    //Проверка добавления одного товара в корзину
    @Test (testName = "Проверка добавления одного товара в корзину", description = "Проверка добавления одного товара в корзину",
            groups = {"Smoke", "UI"})
    @Description("Проверка добавления одного товара в корзину")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Cart")
    @Story("Добавления  товара в корзину")
    @TmsLink("www.Jira.com/web-154")
    public void addOneProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        assertEquals(cartPage.getFirstTitleInCart(),
                productsPage.getTittleProductInCatalog(productsPage.tittleFirst),
                "Заголовок 1 не соответствует ");
    }

    //Проверка добавление несколько товаров в корзину
    @Test (testName = "Проверка добавление несколько товаров   в корзину",  description = "Проверка добавление несколько товаров   в корзину",
            groups =  {"UI"})
    @Description("Проверка добавление несколько товаров   в корзину")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Cart")
    @Story("Добавления  товара в корзину")
    @TmsLink("www.Jira.com/web-154")
    public void addSomeProduct() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
        softAssert.assertEquals(cartPage.getFirstTitleInCart(),
                productsPage.getTittleProductInCatalog(productsPage.tittleFirst),
                "Заголовок 1 не соответствует ");
        softAssert.assertEquals(cartPage.getSecondTitleInCart(),
                productsPage.getTittleProductInCatalog(productsPage.tittleSecond),
                "Заголовок 2 не соответствует ");
        softAssert.assertAll();
    }

    //Проверка удаления товара из корзины
    @Test (testName = "Проверка удаления товара из корзины" , description = "Проверка удаления товара из корзины",
            groups = {"Smoke", "UI"})
    @Description("Проверка удаления товара из корзины")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Cart")
    @Story("Удаление  товара из корзины")
    @TmsLink("www.Jira.com/web-154")
    public void removeProductInCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.removeProductionCart();
        assertTrue(cartPage.checkItemFirst());
    }

    //Проверка удаления товара из Категории
    @Test (testName = "Проверка удаления товара из Категории", description = "Проверка удаления товара из Категории",
            groups =  {"UI"})
    @Description("Проверка удаления товара из Категории")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Cart")
    @Story("Удаление  товара из Категории")
    @TmsLink("www.Jira.com/web-154")
    public void removeProductInProducts() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.removeProductInCatalog("Sauce Labs Backpack");
        productsPage.openCart();
        softAssert.assertEquals(cartPage.checkItemFirst(), true);
        softAssert.assertAll();
    }
}



