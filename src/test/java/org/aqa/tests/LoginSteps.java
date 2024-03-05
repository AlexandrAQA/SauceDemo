package org.aqa.tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.PropertiesLoader;

import java.util.Properties;


public class LoginSteps {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String STANDARD_USER_PROPERTIES = "standard_user.properties";

    WebDriver webDriver;
    LoginPage loginPage;

    public LoginSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        loginPage = new LoginPage(webDriver);
    }

    public void login(String user, String password) {
        loginPage.open();
        loginPage.fillInUserName(user);
        loginPage.fillInPassword(password);
        loginPage.submitForm();
    }

    public void loginAsStandardUser() {
        Properties properties = PropertiesLoader.loadProperties(STANDARD_USER_PROPERTIES);
        login(properties.getProperty(USERNAME), properties.getProperty(PASSWORD));
    }

    public void loginAsDefaultUser() {
        Properties properties = PropertiesLoader.loadProperties();
        login(properties.getProperty(USERNAME), properties.getProperty(PASSWORD));
    }
}
