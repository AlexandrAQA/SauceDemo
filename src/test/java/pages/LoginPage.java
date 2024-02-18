package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By USER_NAME = By.id("user-name");
    private final By PASSWORD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_IF_CREDENTIALS_INCORRECT = By.xpath(".//h3[@data-test ='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String userName, String password) {
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).submit();
    }

    public void loginAsValidUser() {
        login("standard_user", "secret_sauce");
    }

    public String getErrorIfCredentialsIncorrect() {
        return driver.findElement(ERROR_IF_CREDENTIALS_INCORRECT).getText();
    }

}
