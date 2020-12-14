package com.illinoislottery.pages;

import com.illinoislottery.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {

    public  CartPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyPAgeTitle() {
        return driver.getTitle();
    }
}
