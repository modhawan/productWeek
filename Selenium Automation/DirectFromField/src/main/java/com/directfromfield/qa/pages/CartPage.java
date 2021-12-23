package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends TestBase {
    public static List<Double> productPriceList = new ArrayList<>();
    public static List<WebElement> productInCart;

    @FindBy(xpath = "/html/body/app-root/app-cart/div/div/div/div/button")
    WebElement addressButton;

    public CartPage(){
        PageFactory.initElements(driver, this);
        this.makeProductPriceList();
    }

    public void makeProductPriceList(){
        productInCart = driver.findElements(By.xpath("/html/body/app-root/app-cart/div/div/div/div/app-product-list-card/mat-card/div/mat-card-content/div/h3/strong/span"));
        String value = "";
        for(int item=0;item<productInCart.size();item++){
            value=productInCart.get(item).getText();
            value = value.replace("₹","");
            value = value.replace("/-","");
            Double price = Double.valueOf(value);
            productPriceList.add(price);
        }
    }

    public double cartPrice(){
        double total=0;
        for(double item:productPriceList){
            total+=item;
        }
        return total;
    }

    public double cartTotal(){
        String value = driver.findElement(By.xpath("/html/body/app-root/app-cart/div/div/div/div/p[1]")).getText();
        String[] arr = value.split("₹",0);
        value = arr[arr.length-1];
        Double total = Double.valueOf(value);
        return total;
    }

    public AddressPage selectDeliveryAddress(){
        addressButton.click();
        return new AddressPage();
    }
}
