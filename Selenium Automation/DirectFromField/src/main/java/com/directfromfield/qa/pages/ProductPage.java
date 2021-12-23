package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.directfromfield.qa.util.TestUtil.*;

public class ProductPage extends TestBase {
    public static List<WebElement> productList;

    @FindBy(xpath = "/html/body/app-root/app-home-page-wrapper/div/app-sub-categories/div/div/h1")
    WebElement pageName;

    public ProductPage(){
        PageFactory.initElements(driver,this);
        this.makeProductList();
    }

    public String getPageName(){
        return pageName.getText();
    }

    public void makeProductList(){
        productList = driver.findElements(By.xpath("/html/body/app-root/app-home-page-wrapper/div/app-sub-categories/div/div[2]/app-sub-categories-card"));
    }

    public VendorsPage selectProduct(){
        for(int element=0;element<productList.size();element++){
            if(productList.get(element).getText().equalsIgnoreCase(productName)){
                productList.get(element).click();
                break;
            }
        }
        return new VendorsPage();
    }

}
