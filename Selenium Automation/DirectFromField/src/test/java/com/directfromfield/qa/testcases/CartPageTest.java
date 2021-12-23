package com.directfromfield.qa.testcases;

import com.directfromfield.qa.base.TestBase;
import com.directfromfield.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends TestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public VendorsPage vendorsPage;
    public CartPage cartPage;

    public CartPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        loginPage = homePage.loginUser();
        homePage.makeProductCategoryList();
        productPage = homePage.selectCategory();
        vendorsPage = productPage.selectProduct();
        int productCount=vendorsPage.productsAddToCart();
        cartPage = vendorsPage.getCart();
    }

    @Test(priority = 1)
    public void verifyCartPriceAndTotalAmount(){
        double cartPrice = cartPage.cartPrice();
        double cartTotal = cartPage.cartTotal();
        Assert.assertEquals(cartPrice,cartTotal);
    }

    @Test(priority = 2)
    public void deliveryAddressTest(){
        Assert.assertTrue(cartPage.selectDeliveryAddress()!=null);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
