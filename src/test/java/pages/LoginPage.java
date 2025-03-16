package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;
import static utils.AllureUtils.takeScreenshot;

public class LoginPage {
    WebDriver driver;

    By userField = By.cssSelector("#user-name");
    By passwordField = By.cssSelector("#password");
    public By loginButton = By.cssSelector("#login-button");
    By errorMessage = By.xpath("//div/h3");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие странички авторизации ")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Вход в систему с логином {user} и паролем {password} ")
    public void login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    @Step("Получаем уведомление об ошибке")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }


}
