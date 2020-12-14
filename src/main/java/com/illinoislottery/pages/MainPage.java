package com.illinoislottery.pages;

import com.illinoislottery.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {

    // Page Factory

    @FindBy(xpath = "//span[@data-test-id='login-desktop']")
    @CacheLookup
    WebElement logInBtn;

    @FindBy(xpath = "//a[@data-test-id=' register-desktop']")
    @CacheLookup
    WebElement registerBtn;

    @FindBy(xpath = "//img[@alt='Illinois Lottery logo']")
    @CacheLookup
    WebElement logoImg;

    public MainPage () {
        PageFactory.initElements(driver, this);
    }

    public String validateMainPageTitle() {
        return driver.getTitle();
    }

    public boolean validateLottoLogo() {
        return logoImg.isDisplayed();
    }

    public LogInPage loginBtnClick() {
        logInBtn.click();
        return new LogInPage();
    }
}
