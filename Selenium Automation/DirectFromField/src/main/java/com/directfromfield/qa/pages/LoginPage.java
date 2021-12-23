package com.directfromfield.qa.pages;

import com.directfromfield.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.directfromfield.qa.util.TestUtil.getTestData;

public class LoginPage extends TestBase {
    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-login/mat-card/mat-card-content/form/mat-form-field[1]/div/div/div/input")
    WebElement email;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-login/mat-card/mat-card-content/form/mat-form-field[2]/div/div/div/input")
    WebElement password;

    @FindBy(xpath = "/html/body/app-root/app-auth-wrapper/div/app-login/mat-card/mat-card-content/form/button")
    WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
        this.login();
    }

    public void login(){
        Object[][] data = getTestData("UserLogin");
        String emailAddress = data[0][0].toString();
        String pass = data[0][1].toString();
        try {
            Thread.sleep(5000);
            email.sendKeys(emailAddress);
            password.sendKeys(pass);
            loginButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
