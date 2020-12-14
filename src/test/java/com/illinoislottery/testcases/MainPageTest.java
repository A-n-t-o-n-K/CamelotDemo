package com.illinoislottery.testcases;


import com.illinoislottery.base.TestBase;
import com.illinoislottery.pages.LogInPage;
import com.illinoislottery.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase{

    MainPage main;
    public MainPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        main = new MainPage();
    }

    @Test
    public void mainPageTitleTest(){
        String title= main.validateMainPageTitle();
        Assert.assertEquals(title, "Illinois Lottery Official Site: Buy Tickets Online and Get Winning Numbers");
    }

    @Test
    public void mainPageLogoTest(){
        Boolean b= main.validateLottoLogo();
        Assert.assertTrue(b);
    }

    @Test
    public void verifyLoginLink(){
       LogInPage page = main.loginBtnClick();
    }

    @AfterMethod
    public void tarDown(){
        driver.quit();
    }

}
