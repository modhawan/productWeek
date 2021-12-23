package com.directfromfield.qa.testcases;

import com.directfromfield.qa.base.TestBase;
import com.directfromfield.qa.pages.HomePage;
import com.directfromfield.qa.pages.LoginPage;
import com.directfromfield.qa.pages.ProductPage;
import com.directfromfield.qa.pages.VendorsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.directfromfield.qa.util.TestUtil.*;

public class ProductPageTest extends TestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public VendorsPage vendorsPage;

    public ProductPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        loginPage = homePage.loginUser();
        homePage.makeProductCategoryList();
        productPage = homePage.selectCategory();
    }

    @Test(priority = 1)
    public void validateProductPageTitle(){
        Assert.assertEquals(productPage.getPageName(),categoryName);
    }

    @Test(priority = 2)
    public void selectProductTest(){
        vendorsPage = productPage.selectProduct();
        Assert.assertTrue(vendorsPage!=null);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
