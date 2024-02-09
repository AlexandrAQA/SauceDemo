package org.aqa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldLoginWithValidCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(driver.findElement(By.xpath(".//span[@class='title']"))
                                .isDisplayed(),"User was not logged in");
    }

    @Test
    public void passwordShouldNotBeEmptyForLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorIfPswIsEmpty(),
                "Epic sadface: Password is required",
                "The error message is incorrect or changed");
    }
}

