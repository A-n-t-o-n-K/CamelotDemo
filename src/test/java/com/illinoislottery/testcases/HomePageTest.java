package com.illinoislottery.testcases;

import com.illinoislottery.base.TestBase;
import com.illinoislottery.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class HomePageTest extends TestBase{


    public HomePageTest() {
        super();
    }

    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        initialization();
        MainPage mainPage;
        LogInPage loginPage;
        mainPage = new MainPage();
        loginPage = mainPage.loginBtnClick();
        homePage = loginPage.HomePageLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void verifyHomePageTitleTest()
    {
        String title = homePage.verifyHomepageTitle();
        Assert.assertEquals(title, "My Profile", "Home page title not matched");
    }

    @Test
    public void verifyCorrectUserIsPresented(){
        Assert.assertTrue(homePage.verifyUserNameIsPresented());
    }

    @Test
    public void veryfyPromotionsLinkClick(){
        PromotionsPage promotionsPage = homePage.clickOnMyPromotionsLink();
       Assert.assertEquals(promotionsPage.verifyPageTitleLabel(), "My Promotions");
    }

    @Test
    public void verifyGamesBtnClick(){
        Boolean b = homePage.clickOnGamesButton();
        Assert.assertTrue(b);
    }

    @Test
    public void verifyLDLbtnClick() {
        LDLGamePage ldlPage=homePage.clickOnLDLBtn();
        Assert.assertEquals(ldlPage.verifyPageTitle(), "Play Lucky Day Lotto | Draw Games | Illinois Lottery");
    }

    @AfterMethod
    public void teaDown(){
        driver.quit();
    }
}
