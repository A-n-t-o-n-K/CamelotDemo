package com.illinoislottery.pages;

import com.illinoislottery.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage extends TestBase {

    @FindBy(id = "userName")
    @CacheLookup
    WebElement userNameTextbox;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordTextBox;

    @FindBy(id = "login-button")
    @CacheLookup
    WebElement logInBtn;


    public LogInPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyLogInPageTitle(){
        return driver.getTitle();
    }

    public HomePage HomePageLogin (String un, String pwd)
    {
        userNameTextbox.sendKeys(un);
        passwordTextBox.sendKeys(pwd);
        logInBtn.click();
        return new HomePage();
    }
}
