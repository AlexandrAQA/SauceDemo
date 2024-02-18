package org.aqa.tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAddedToCartTest() {
        loginPage.open();
        loginPage.loginAsValidUser();
        productsPage.open();
        //productsPage.addProductToCart();

    }

}
