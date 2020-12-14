package com.illinoislottery.pages;

import com.illinoislottery.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LDLGamePage extends TestBase {

    @FindBy(id = "buy-ticket-button")
    @CacheLookup
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[@data-test-id='quickPickTop']")
    @CacheLookup
    WebElement quickPickBtn;

    @FindBy (id = "ONE_OFF_PURCHASE-extra-values-selector")
    @CacheLookup
    WebElement drawsDropDownList;

    @FindBy (id = "SUBSCRIPTION")
    @CacheLookup
    WebElement subscriptionradioBtn;

    @FindBy(id = "SUBSCRIPTION-extra-values-selector")
    WebElement subscriptionDropDownList;

    @FindBy (xpath = "//label[@id='radio-label-BOTH']")
    @CacheLookup
    WebElement bothDrawsBtn;

    @FindBy (xpath = "//label[@id='radio-label-DAY']")
    @CacheLookup
    WebElement middayDrawsBtn;

    @FindBy (xpath = "//label[@id='radio-label-EVE']")
    @CacheLookup
    WebElement eveningBtn;

    @FindBy (id = "buy-ticket-button")
    @CacheLookup
    WebElement updateBtn;

    public  LDLGamePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyPageTitle(){
        return driver.getTitle();
    }

    public void selectNumberByName (String i) {
        WebElement numb = driver.findElement(By.xpath("//div[@data-test-id='ball-primary-"+i+"']"));
        numb.click();
    }

    public Boolean verifyAddToCartBtnIsActive() {
        return addToCartBtn.isEnabled();
    }

    public CartPage verifyAddToCartBtnClick() {
        addToCartBtn.click();
        return new CartPage();
    }

    public void selectQuickPickBtn() {
        quickPickBtn.click();
    }

    public void verifySelectionOfDrawsAmount (String str)
    {
        Select select = new Select(drawsDropDownList);
        select.selectByValue(str);
    }

    public void verifySelectionOfSubscriptionAmount (String str)
    {
        subscriptionradioBtn.click();
        Select select = new Select(subscriptionDropDownList);
        select.selectByVisibleText(str);
    }

    public void verifySelectionOFDrawTime (String str) {
        Actions action = new Actions(driver);

        if (str.equals("Midday")) {
            action.moveToElement(middayDrawsBtn).click().perform();
        }
        else if (str.equals("Evening")) {
            action.moveToElement(eveningBtn).click().perform();
        }
        else if (str.equals("Both")) {
            action.moveToElement(bothDrawsBtn).click().perform();
        }
    }

    public void verifyUpdateBtnClick(){
        updateBtn.click();
    }
}