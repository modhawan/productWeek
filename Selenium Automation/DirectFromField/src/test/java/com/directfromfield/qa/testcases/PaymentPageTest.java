package com.directfromfield.qa.testcases;

import com.directfromfield.qa.base.TestBase;
import com.directfromfield.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentPageTest extends TestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public VendorsPage vendorsPage;
    public CartPage cartPage;
    public AddressPage addressPage;

    public PaymentPageTest(){
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
        addressPage = cartPage.selectDeliveryAddress();
    }

    @Test(priority = 1)
    public void makePaymentTest(){
        addressPage.selectUserAddress();
        addressPage.selectPaymentMode();
        double paymentAmount = addressPage.makePayment();
        Assert.assertEquals(paymentAmount,cartPage.cartPrice());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
