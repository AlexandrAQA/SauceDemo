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
        assertEquals(loginPage.getErrorIfCredentialsIncorrect(),
                "Epic sadface: Password is required",
                "The error message is incorrect or changed");
    }

    @Test
    public void passwordShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "incorrect_password");
        assertEquals(loginPage.getErrorIfCredentialsIncorrect(),
                "Epic sadface: Username and password do not match any user in this service",
                "The error message is incorrect or changed");
    }

    @Test
    public void userNameShouldBeCorrect(){
        loginPage.open();
        loginPage.login("incorrect_user_name", "secret_sauce");
        assertEquals(loginPage.getErrorIfCredentialsIncorrect(),
                "Epic sadface: Username and password do not match any user in this service",
                "The error message is incorrect or changed");
    }

    @Test
    public void credentialsShouldBeFilled(){
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorIfCredentialsIncorrect(),
                "Epic sadface: Username is required",
                "The error message is incorrect or changed");
    }

    @Test
    public void credentialsShouldNotBeFilledWithSpaces(){
        loginPage.open();
        loginPage.login("          ", "              ");
        assertEquals(loginPage.getErrorIfCredentialsIncorrect(),
                "Epic sadface: Username and password do not match any user in this service",
                "The error message is incorrect or changed");
    }

    @Test
    public void ifUserShouldBeenLockedOut(){
        loginPage.open();
        loginPage.login("          ", "              ");
        assertEquals(loginPage.getErrorIfCredentialsIncorrect(),
                "Epic sadface: Sorry, this user has been locked out.",
                "The error message is incorrect or changed");
    }
}

