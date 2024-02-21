package org.aqa.tests;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {


    @Test
    public void productsShouldBeAddedToCartTest() {
        loginPage.open();
        loginPage.loginAsValidUser();
        final String SAUCE_LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";
        final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        productsPage.addProductToCart(SAUCE_LABS_ONESIE);
        productsPage.openCart();

        cartPage.removeProductFromCart(SAUCE_LABS_ONESIE);
        final List<WebElement> allProductsItemInCartAfterRemove = cartPage.getAllProductsItemInCart();

        CollectionUtils.size(allProductsItemInCartAfterRemove);
        Assert.assertEquals(allProductsItemInCartAfterRemove.size(), 1,
                "Only one product should be in the cart after removing product");
        Assert.assertEquals(allProductsItemInCartAfterRemove.get(0).getText(), SAUCE_LABS_BOLT_T_SHIRT,
                "\"Sauce Labs Bolt T-Shirt\" product should be in the cart after removing 2nd product");

    }
}
