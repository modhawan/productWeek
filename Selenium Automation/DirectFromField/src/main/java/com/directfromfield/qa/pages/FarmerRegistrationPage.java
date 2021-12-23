package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.directfromfield.qa.util.TestUtil.*;

public class FarmerRegistrationPage extends TestBase {

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div/div/div/div/form/div[1]/mat-form-field/div/div/div/input")
    WebElement firstName;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div/div/div/div/form/div[2]/mat-form-field/div/div/div/input")
    WebElement lastName;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div/div/div/div/form/div[3]/mat-form-field/div/div/div/input")
    WebElement phone;

    @FindBy(xpath="/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div/div/div/div/button")
    WebElement firstNext;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[2]/div/div/div/form/div[1]/mat-form-field/div/div/div/input")
    WebElement addressInput1;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[2]/div/div/div/form/div[2]/mat-form-field/div/div/div/input")
    WebElement addressInput2;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[2]/div/div/div/form/div[3]/div[1]/mat-form-field/div/div/div/input")
    WebElement pincode;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[2]/div/div/div/form/div[3]/div[2]/mat-form-field/div/div/div/input")
    WebElement city;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[2]/div/div/div/form/div[4]/mat-form-field/div/div/div/input")
    WebElement state;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[2]/div/div/div/button[1]")
    WebElement secNext;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[3]/div/div/div/form/div/mat-form-field/div/div/div/input")
    WebElement adhaarNumber;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[3]/div/div/div/form/div[2]/app-img-uploader/div/form/input")
    WebElement photo;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[3]/div/div/div/button[1]")
    WebElement thirdNext;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[4]/div/div/div/form/div[1]/mat-form-field/div/div/div/input")
    WebElement email;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[4]/div/div/div/form/div[2]/mat-form-field/div/div/div/input")
    WebElement password;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[4]/div/div/div/form/div[3]/mat-form-field/div/div/div/input")
    WebElement confirmPassword;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-farmer-registration/mat-card/mat-stepper/div[4]/div/div/div/form/button")
    WebElement registerButton;

    public FarmerRegistrationPage(){
        PageFactory.initElements(driver,this);
        this.registerFarmer();
    }

    public void registerFarmer(){
        Object[][] data = getTestData("FarmerReg");
        String fname = data[0][0].toString();
        String lname = data[0][1].toString();
        String phn = data[0][2].toString();
        phn = phn.replace("_","");
        String address1 = data[0][3].toString();
        String address2 = data[0][4].toString();
        String pin = data[0][5].toString();
        pin = pin.replace("_","");
        String cityVal = data[0][6].toString();
        String stateVal = data[0][7].toString();
        String adhaarVal = data[0][8].toString();
        adhaarVal = adhaarVal.replace("_","");
        String emailVal = data[0][9].toString();
        String passVal = data[0][10].toString();
        String conPass = data[0][11].toString();
        try {
            Thread.sleep(5000);
            firstName.sendKeys(fname);
            lastName.sendKeys(lname);
            phone.sendKeys(phn);
            firstNext.click();
            Thread.sleep(2000);
            addressInput1.sendKeys(address1);
            addressInput2.sendKeys(address2);
            pincode.sendKeys(pin);
            city.sendKeys(cityVal);
            state.sendKeys(stateVal);
            secNext.click();
            Thread.sleep(2000);
            adhaarNumber.sendKeys(adhaarVal);
            photo.sendKeys("C:\\Mohit Data\\Product Week\\Selenium Automation\\DirectFromField\\src\\main\\resources\\farmer.jpg");
            thirdNext.click();
            Thread.sleep(2000);
            email.sendKeys(emailVal);
            password.sendKeys(passVal);
            confirmPassword.sendKeys(conPass);
            Thread.sleep(2000);
            registerButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
