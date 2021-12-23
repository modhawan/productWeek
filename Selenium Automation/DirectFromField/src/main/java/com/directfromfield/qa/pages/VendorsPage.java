package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.directfromfield.qa.util.TestUtil.*;

public class VendorsPage extends TestBase {
    public List<WebElement> vendorProductList;

    @FindBy(xpath = "/html/body/div/div/div/mat-dialog-container/app-pincode-dialog/div/mat-form-field/div/div/div/input")
    WebElement pinCode;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/app-pincode-dialog/div[2]/button[2]")
    WebElement okButton;

    @FindBy(xpath = "/html/body/app-root/app-navbar/mat-toolbar/mat-toolbar-row/div/mat-icon")
    WebElement cartIcon;

    public VendorsPage(){
        PageFactory.initElements(driver,this);
        this.enterPinCode();
    }

    public void enterPinCode(){
        pinCode.sendKeys(pin);
        okButton.click();
    }

    public int productsAddToCart(){
        int productCount=0;
        try {
            vendorProductList = driver.findElements(By.xpath("/html/body/app-root/app-home-page-wrapper/div/app-product-list/div/div[2]/div/app-product-list-card/mat-card/mat-card-content/mat-card-title"));
            List<WebElement> addToCartList = driver.findElements(By.xpath("/html/body/app-root/app-home-page-wrapper/div/app-product-list/div/div[2]/div/app-product-list-card/mat-card/mat-card-actions/button"));
            for (int item = 0; item < vendorProductList.size(); item++) {
                Thread.sleep(3000);
                addToCartList.get(item).click();
                productCount++;
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return productCount;
    }

    public CartPage getCart(){
        cartIcon.click();
        return new CartPage();
    }
}
