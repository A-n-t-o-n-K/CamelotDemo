package com.illinoislottery.pages;

import com.illinoislottery.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromotionsPage extends TestBase {

    @FindBy(className = "page-title")
    @CacheLookup
    WebElement pageTitleLabel;

    public  PromotionsPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyPageTitleLabel(){
        return pageTitleLabel.getText();
    }
}
