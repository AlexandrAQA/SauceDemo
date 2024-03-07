package org.aqa.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test (timeOut = 10000)
    public void userShouldLoginWithValidCredentials() {
        loginSteps.loginAsStandardUser();
        assertTrue(productsPage.getTitle().isDisplayed(), "User was not logged in");
    }

    @Test (enabled = true)
    public void passwordShouldBeRequiredForLogin() {
        loginSteps.login("standard_user", "");
        String expected = "Epic sadface: Password is required";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test (alwaysRun = true)
    public void userNameShouldBeRequiredForLogin() {
        loginSteps.login("", "12345");
        String expected = "Epic sadface: Username is required";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }
    @Test (description = "Checking that if the password is not correct then the user should not be logged in")
    public void userShouldNotBeLoggedInWithInvalidPassword() {
        loginSteps.login("standard_user", "12345");
        String expected = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test (priority = 0)
    public void userShouldNotBeLoggedInIfPasswordContainsOnlySpaces() {
        loginSteps.login("standard_user", "               ");
        String expected = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }
    @Test (alwaysRun = true)
    public void userNameAndPasswordShouldBeRequiredForLogin() {
        loginSteps.login("", "");
        String expected = "Epic sadface: Username is required";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test (expectedExceptions = NoSuchElementException.class)
    public void userShouldNotBeLoggedInWithInvalidUserName() {
        loginSteps.login("standard_user1", "secret_sauce");
        String expected = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }

    @Test (invocationCount = 2, invocationTimeOut = 10000, successPercentage = 50)
    public void lockedOutUserShouldNotBeLoggedIn() {
        Properties properties = PropertiesLoader.loadProperties("locked_out_user.properties");
        loginSteps.login(properties.getProperty("username"), properties.getProperty("password"));
        String expected = "Epic sadface: Sorry, this user has been locked out.";
        assertEquals(loginPage.getError(), expected, "The error is incorrect");
    }
}

