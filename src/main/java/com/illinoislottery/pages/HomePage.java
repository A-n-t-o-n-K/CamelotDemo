package com.illinoislottery.pages;


import com.illinoislottery.base.TestBase;

import com.illinoislottery.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//h1[contains(text(), 'Hi Anton!')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[@data-test-id='account-menu-my-games-link']")
    WebElement myGamesLink;

    @FindBy(xpath = "//a[@data-test-id='account-menu-my-promotions-link']")
    WebElement myPromotionsLink;

    @FindBy(xpath = "//li[@data-test-id='account-management-card-edit-account-details']")
    WebElement editAccountDetailsLink;

    @FindBy (xpath = " //div[@class='mega-menu-games mega-menu__expanded-menu']//div[@class='mega-menu__game-card " +
            "mega-menu__game-card--luckydaylotto']/a")
    WebElement ldlPlayButton;

    @FindBy (xpath = "//li[@data-menu-type='games']")
    WebElement gamesButton;

    @FindBy (xpath = "//div[@class='mega-menu-games mega-menu__expanded-menu']")
    WebElement gamesMenu;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomepageTitle() {
        return driver.getTitle();
    }

    public PromotionsPage clickOnMyPromotionsLink() {
        myPromotionsLink.click();
        return new PromotionsPage();
    }

    public EditAccountDetailsPage clickOnEditMyAccountLink() {
        editAccountDetailsLink.click();
        return new EditAccountDetailsPage();
    }

    public Boolean verifyUserNameIsPresented(){
        return userNameLabel.isDisplayed();
    }

    public Boolean clickOnGamesButton() {
        gamesButton.click();
        return gamesMenu.isDisplayed();
    }

    public LDLGamePage clickOnLDLBtn() {
        gamesButton.click();
        ldlPlayButton.click();
        TestUtil utill = new TestUtil();
        utill.waitForOneSec();
        return new LDLGamePage();
    }
}
