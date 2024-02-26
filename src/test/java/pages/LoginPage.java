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

    @FindBy(id = "user-name")
    @CacheLookup
    private WebElement USER_NAME;
    @FindBy(id = "password")
    @CacheLookup
    private WebElement PASSWORD;
    @FindBy(id = "login-button")
    @CacheLookup
    private WebElement LOGIN_BUTTON;
    @FindBy(css = "h3[data-test =error]")
    @CacheLookup
    private WebElement ERROR_IF_CREDENTIALS_INCORRECT;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);
    }

    public void login(String userName, String password) {
        USER_NAME.sendKeys(userName);
        PASSWORD.sendKeys(password);
        LOGIN_BUTTON.submit();
    }

    public void loginAsValidUser() {
        login("standard_user", "secret_sauce");
    }

    public String getErrorIfCredentialsIncorrect() {
        return ERROR_IF_CREDENTIALS_INCORRECT.getText();
    }
}
