package com.directfromfield.qa.testcases;

import com.directfromfield.qa.base.TestBase;
import com.directfromfield.qa.pages.*;

import static com.directfromfield.qa.util.TestUtil.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void homePageTitleTest(){
        Assert.assertEquals(homePage.validateHomePage(),homePageTitle);
    }

    @Test(priority = 2)
    public void registerFarmerTest(){
        Assert.assertTrue(homePage.registerFarmer()!=null);
    }

    @Test(priority = 3)
    public void registerUserTest(){
        Assert.assertTrue(homePage.registerUser()!=null);
    }

    @Test(priority = 4)
    public void loginUserTest(){
        Assert.assertTrue(homePage.loginUser()!=null);
    }

    @Test(priority = 5)
    public void selectCategoryTest(){
        loginPage = homePage.loginUser();
        homePage.makeProductCategoryList();
        productPage = homePage.selectCategory();
        Assert.assertEquals(productPage.getPageName(),categoryName);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
