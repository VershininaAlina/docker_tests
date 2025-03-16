package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class BurgerMenuPage {
    public By TittlePage = By.cssSelector("#header_container > div.header_secondary_container > span");
    WebDriver driver;

    By BurgerMenu = By.cssSelector("#react-burger-menu-btn");
    By BurgerMenuClose = By.cssSelector("#react-burger-cross-btn");

    public By ButtonAllItemsBurgerMenu = By.cssSelector("#inventory_sidebar_link");
    public By ButtonAboutBurgerMenu = By.cssSelector("#about_sidebar_link");
    public By ButtonLogoutBurgerMenu = By.cssSelector("#logout_sidebar_link");
    public By ButtonResetBurgerMenu = By.cssSelector("#reset_sidebar_link");

    public BurgerMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие бургер меню")
    public void openBurgerMenu() {
        driver.findElement(BurgerMenu).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Закрытие бургер меню")
    public void closeBurgerMenu() {
        driver.findElement(BurgerMenuClose).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Проверяем наличие элемента логаут")
    public boolean checkElementLogout() {
        return ButtonLogoutBurgerMenu != null;
    }

    @Step("Проверяем наличие элементов бургер меню всех")
    public boolean checkElementsAll() {
        return (ButtonLogoutBurgerMenu != null) & (ButtonResetBurgerMenu != null) &&
                (ButtonAllItemsBurgerMenu != null) && (ButtonAboutBurgerMenu != null);
    }
    @Step("Переход в элемент раздел бургер меню")
    public void GoToElementBurgerMenu(By ItemBurgerMenu){
        driver.findElement(ItemBurgerMenu).click();
        AllureUtils.takeScreenshot(driver);

    }


}