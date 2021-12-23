package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.directfromfield.qa.util.TestUtil.getTestData;

public class UserRegistrationPage extends TestBase {

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-customer-registration/mat-card/mat-card-content/form/div[1]/div[1]/mat-form-field/div/div/div/input")
    WebElement firstName;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-customer-registration/mat-card/mat-card-content/form/div[1]/div[2]/mat-form-field/div/div/div/input")
    WebElement lastName;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-customer-registration/mat-card/mat-card-content/form/div[2]/div[1]/mat-form-field/div/div/div/input")
    WebElement phone;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-customer-registration/mat-card/mat-card-content/form/div[2]/div[2]/mat-form-field/div/div/div/input")
    WebElement email;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-customer-registration/mat-card/mat-card-content/form/div[3]/div[1]/mat-form-field/div/div/div/input")
    WebElement password;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-customer-registration/mat-card/mat-card-content/form/div[3]/div[2]/mat-form-field/div/div/div/input")
    WebElement confirmPassword;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-customer-registration/mat-card/mat-card-content/form/button")
    WebElement registerButton;

    public UserRegistrationPage(){
        PageFactory.initElements(driver,this);
        this.registerUser();
    }

    public void registerUser(){
        Object[][] data = getTestData("UserRegister");
        String fname = data[0][0].toString();
        String lname = data[0][1].toString();
        String phn = data[0][2].toString();
        phn = phn.replace("_","");
        String mail = data[0][3].toString();
        String pass = data[0][4].toString();
        String conpass = data[0][5].toString();
        try {
            Thread.sleep(5000);
            firstName.sendKeys(fname);
            lastName.sendKeys(lname);
            phone.sendKeys(phn);
            email.sendKeys(mail);
            password.sendKeys(pass);
            confirmPassword.sendKeys(conpass);
            Thread.sleep(3000);
            registerButton.click();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
