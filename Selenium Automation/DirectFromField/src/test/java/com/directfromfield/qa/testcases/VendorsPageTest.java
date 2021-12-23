package com.directfromfield.qa.testcases;

import com.directfromfield.qa.base.TestBase;
import com.directfromfield.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VendorsPageTest extends TestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public VendorsPage vendorsPage;
    public CartPage cartPage;

    public VendorsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        loginPage = homePage.loginUser();
        homePage.makeProductCategoryList();
        productPage = homePage.selectCategory();
        vendorsPage = productPage.selectProduct();
    }

    @Test(priority = 1)
    public void productAddToCartTest(){
        int productCount=vendorsPage.productsAddToCart();
        cartPage = vendorsPage.getCart();
        Assert.assertEquals(productCount,vendorsPage.vendorProductList.size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
