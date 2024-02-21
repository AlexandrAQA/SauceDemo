package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement USER_NAME;
    @FindBy(id = "password")
    private WebElement PASSWORD;
    @FindBy(id = "login-button")
    private WebElement LOGIN_BUTTON;
    @FindBy(css = "h3[data-test =error]")
    private WebElement ERROR_IF_CREDENTIALS_INCORRECT;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
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
