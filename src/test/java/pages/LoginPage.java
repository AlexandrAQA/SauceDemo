package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    private final By USER_NAME = By.id("user-name");
    private final By PASSWORD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_IF_PSW_INCORRECT = By.xpath(".//h3[@data-test ='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String userName, String password) {
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).submit();
    }

    public String getErrorIfPswIsEmpty() {
        return driver.findElement(ERROR_IF_PSW_INCORRECT).getText();
    }

    public String getErrorIfPswIncorrect() {
        return driver.findElement(ERROR_IF_PSW_INCORRECT).getText();
    }
}
