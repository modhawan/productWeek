package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.directfromfield.qa.util.TestUtil.*;

public class AddressPage extends TestBase {
    CartPage cartPage;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/div/mat-radio-group/app-checkout-address-card[1]/mat-card/div/div/mat-radio-button")
    WebElement userAddress;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/button[2]")
    WebElement payOnlineButton;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/button[1]")
    WebElement payOnDelivery;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/app-new-address-form/div/mat-card/form/div[1]/mat-form-field/div/div/div/input")
    WebElement addressLineInput1;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/app-new-address-form/div/mat-card/form/div[2]/mat-form-field/div/div/div/input")
    WebElement addressLineInput2;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/app-new-address-form/div/mat-card/form/div/div[1]/mat-form-field/div/div/div/input")
    WebElement cityInput;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/app-new-address-form/div/mat-card/form/div/div[2]/mat-form-field/div/div/div/input")
    WebElement stateInput;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/app-new-address-form/div/mat-card/form/div/div[3]/mat-form-field/div/div/div/input")
    WebElement pinCodeInput;

    @FindBy(xpath = "/html/body/app-root/app-checkout/div/div/div/app-new-address-form/div/mat-card/form/button")
    WebElement addAddressButton;

    public AddressPage(){
        PageFactory.initElements(driver,this);
        cartPage = new CartPage();
    }

    public void enterUserAddress(){
        Object[][] data = getTestData("UserAddress");
        String firstLine = data[0][0].toString();
        String secondLine = data[0][1].toString();
        String cityVal = data[0][2].toString();
        String stateVal = data[0][3].toString();
        String pinVal = data[0][4].toString();
        pinVal = pinVal.replace("_","");
        try {
            Thread.sleep(5000);
            addressLineInput1.sendKeys(firstLine);
            addressLineInput2.sendKeys(secondLine);
            cityInput.sendKeys(cityVal);
            stateInput.sendKeys(stateVal);
            pinCodeInput.sendKeys(pinVal);
            addAddressButton.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectUserAddress(){
        userAddress.click();
    }

    public void selectPaymentMode(){
        if(paymentMode.equalsIgnoreCase("PayOnline")){
            payOnlineButton.click();
        }
        else{
            payOnDelivery.click();
        }
    }

    public double makePayment() {
        double paymentAmount = 0;
        try {
            Thread.sleep(5000);
            driver.switchTo().frame(0);
            String amount = driver.findElement(By.xpath("/html/body/div/div/div/div[12]/div/div/div/span[2]")).getText();
            amount = amount.replace("₹ ", "");
            paymentAmount = Double.valueOf(amount);
            WebElement phone = driver.findElement(By.xpath("/html/body/div/div/div/div[12]/div/form/div/div/div/div/div/div/div/div/div[2]/input"));
            WebElement email = driver.findElement(By.xpath("/html/body/div/div/div/div[12]/div/form/div/div/div/div/div/div/div[2]/div/div/input"));
            phone.sendKeys(paymentPhone);
            email.sendKeys(paymentEmail);
            driver.findElement(By.xpath("/html/body/div/div/div/div[12]/div/form/div[2]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[12]/div[2]/form/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/button[3]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div/div[12]/div/form/div/div[7]/div/div/div/div/button")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div[15]/div/div/div/div/div/div[4]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/div/div[12]/div/form/div[2]")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentAmount;
    }

}
