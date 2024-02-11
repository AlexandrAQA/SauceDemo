package org.aqa.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldLoginWithValidCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.getTitle()
                               .isDisplayed(), "User was not logged in");
    }

    @Test
    public void passwordShouldNotBeEmptyForLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorIfPswIsEmpty(),
                "Epic sadface: Password is required",
                "The error message is incorrect or changed");
    }

    @Test
    public void passwordShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "incorrect_password");
        assertEquals(loginPage.getErrorIfPswIncorrect(),
                "Epic sadface: Username and password do not match any user in this service",
                "The error message is incorrect or changed");
    }
}

