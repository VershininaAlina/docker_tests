package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BurgerMenuPage;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class LoginTest extends BaseTest {

    String ErrorMessage;

    //Авторизация с корректными данными
    @Test ( testName = "Авторизация с корректными данными  ",  description = "Авторизация с корректными данными ",
            groups = {"Smoke", "UI"})
    @Description("Авторизация с корректными данными  ")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Login")
    @Story("Авторизация")
    @TmsLink("www.Jira.com/web-134")
    public void positiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openBurgerMenu();
        Assert.assertTrue(
                burgerMenuPage.checkElementLogout(),
                "Нет элемента логаут");
    }

    //Авторизация логина с пустыми значениями
    @Test (testName = "Авторизация логина с пустыми значениями",  description = "Авторизация логина с пустыми значениями",
             groups =  {"UI"})
    @Description("Авторизация логина с пустыми значениями")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Login")
    @Story("Авторизация")
    @TmsLink("www.Jira.com/web-134")
    public void emptyData() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение отсутствует");
    }

    //Авторизация логина с некорректным паролем
    @Test (testName = "Авторизация логина с некорректным  паролем",  description = "Авторизация логина с некорректным  паролем",
             groups =  {"UI"} )
    @Description("Авторизация логина с некорректным  паролем")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Login")
    @Story("Авторизация")
    @TmsLink("www.Jira.com/web-134")
    public void invalidPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение отсутствует");
    }

    //Авторизация логина с некорректным username
    @Test (testName = "Авторизация логина с некорректным  username",  description = "Авторизация логина с некорректным  username",
             groups =  {"UI"})
    @Description("Авторизация логина с некорректным  username")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Login")
    @Story("Авторизация")
    @TmsLink("www.Jira.com/web-134")
    public void invalidUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение отсутствует");
    }

    //Авторизация с несуществующими данными
    @Test (testName = "Авторизация  с несуществующими данными",  description = "Авторизация  с несуществующими данными",
             groups =  {"UI"} )
    @Description("Авторизация  с несуществующими данными")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo - 1.0")
    @Feature("Login")
    @Story("Авторизация")
    @TmsLink("www.Jira.com/web-134")
    public void notExistUser() {
        loginPage.open();
        loginPage.login("test123", "test123");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение отсутствует");
    }
}

