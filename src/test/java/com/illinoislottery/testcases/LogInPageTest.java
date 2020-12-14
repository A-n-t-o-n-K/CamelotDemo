package com.illinoislottery.testcases;


import com.illinoislottery.base.TestBase;
import com.illinoislottery.pages.HomePage;
import com.illinoislottery.pages.LogInPage;
import com.illinoislottery.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInPageTest extends TestBase {

    MainPage mainPage;
    LogInPage logPage;
    HomePage homePage;

    public LogInPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        mainPage = new MainPage();
        logPage = mainPage.loginBtnClick();
    }

    @Test
    public void LogInTest(){
        homePage = logPage.HomePageLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
