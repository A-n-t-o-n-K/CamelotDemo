package com.illinoislottery.testcases;

import com.illinoislottery.base.TestBase;
import com.illinoislottery.pages.*;
import com.illinoislottery.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LDLGamePageTests extends TestBase{

    LDLGamePage ldlPage;
    CartPage cartPage;

    public LDLGamePageTests() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        MainPage mainPage;
        LogInPage loginPage;
        HomePage homePage;
        mainPage = new MainPage();
        loginPage = mainPage.loginBtnClick();
        homePage = loginPage.HomePageLogin(prop.getProperty("username"), prop.getProperty("password"));
        ldlPage = homePage.clickOnLDLBtn();
    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtil.getTestData("LDL");
        return data;
    }

    @Test
    public void verifyLDLGamePAgeTitle() {
        String title= ldlPage.verifyPageTitle();
        Assert.assertEquals(title, "Play Lucky Day Lotto | Draw Games | Illinois Lottery");
    }

    @Test (dataProvider = "getTestData")
    public void verifyPurchase (String numbers, String drawsCount, String subscriptionsCount, String drawTime) {
        String[] strArr =  TestUtil.stringToStringArr(numbers);
        for (String s : strArr) {
                ldlPage.selectNumberByName(s);
            }
        double d =Double.parseDouble(drawsCount);
        if (d!=1.0) {
            int i = (int)d;
                ldlPage.verifySelectionOfDrawsAmount(i+"");
        }
        if (!subscriptionsCount.isEmpty()) {
            ldlPage.verifySelectionOfSubscriptionAmount(subscriptionsCount);
        }
        ldlPage.verifySelectionOFDrawTime(drawTime);
        ldlPage.verifyUpdateBtnClick();
}

    @Test
    public void verifyQuickPickPurchase() {
        ldlPage.selectQuickPickBtn();
        cartPage = ldlPage.verifyAddToCartBtnClick();
        }

        @AfterMethod
        public void teaDown() {
            driver.quit();

        }
    }