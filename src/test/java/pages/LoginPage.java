package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private static final String LOGIN_BUTTON_ID = "login-button";

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = LOGIN_BUTTON_ID)
    private WebElement loginButton;

    @FindBy(css = "[data-test=error]")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public By getLoginButtonLocator() {
        return By.id(LOGIN_BUTTON_ID);
    }

    public void open() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLoginButtonLocator()));
    }

    public void fillInUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void fillInPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void submitForm() {
        loginButton.submit();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public String getError() {
        return error.getText();
    }
}
