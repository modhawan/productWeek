package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.directfromfield.qa.util.TestUtil.*;

public class HomePage extends TestBase {
    public static List<WebElement> productCategory;

    @FindBy(xpath = "//span[contains(text(),'register')]")
    WebElement registerButton;

    @FindBy(xpath = "//span[contains(text(),'login')]")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'sell with us')]")
    WebElement sellWithUsButton;

    public HomePage(){
        super();
        initialization();
        PageFactory.initElements(driver,this);
    }

    //Actions:
    public String validateHomePage(){
        return driver.getTitle();
    }

    public FarmerRegistrationPage registerFarmer(){
        sellWithUsButton.click();
        return new FarmerRegistrationPage();
    }

    public UserRegistrationPage registerUser(){
        registerButton.click();
        return new UserRegistrationPage();
    }

    public LoginPage loginUser(){
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        loginButton.click();
        return new LoginPage();
    }

    public void makeProductCategoryList(){
        try{
            Thread.sleep(5000);
            productCategory = driver.findElements(By.xpath("/html/body/app-root/app-home-page-wrapper/div/app-home-page/app-categories/div/div/div"));
        }
        catch(InterruptedException e){
           e.printStackTrace();
        }
    }

    public ProductPage selectCategory(){
        for(int element=0;element<productCategory.size();element++){
            if(productCategory.get(element).getText().equalsIgnoreCase(categoryName)){
                productCategory.get(element).click();
                break;
            }
        }
        return new ProductPage();
    }

    public static void main(String[] args) throws InterruptedException {
        HomePage obj = new HomePage();
        System.out.println(obj.validateHomePage());
        Thread.sleep(5000);
        LoginPage user = obj.loginUser();
        Thread.sleep(5000);
        obj.makeProductCategoryList();
        ProductPage product= obj.selectCategory();
        System.out.println(product.getPageName());
        VendorsPage vendorsPage = product.selectProduct();
        Thread.sleep(5000);
        //vendorsPage.enterPinCode();
        //Thread.sleep(3000);
        int prodCount = vendorsPage.productsAddToCart();
        CartPage cartPage = vendorsPage.getCart();
        driver.navigate().refresh();
        Thread.sleep(5000);
        CartPage cartPage1 = vendorsPage.getCart();
        Thread.sleep(5000);
        System.out.println(cartPage1.cartPrice());
        System.out.println(cartPage1.cartTotal());
        AddressPage addressPage = cartPage1.selectDeliveryAddress();
        //System.out.println("Hello");
        Thread.sleep(5000);
        //addressPage.enterUserAddress();
        addressPage.selectUserAddress();
        addressPage.selectPaymentMode();
        System.out.println(addressPage.makePayment());
        //UserRegistrationPage user = obj.registerUser();
        //FarmerRegistrationPage farmer = obj.registerFarmer();
    }

}
