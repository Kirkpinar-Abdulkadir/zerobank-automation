package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(id = "signin_button")
    public WebElement signInButton;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateTo(String tab){

        try {
            BrowserUtils.waitForClickablility(By.linkText(tab), 5);
            WebElement tabElement = Driver.get().findElement(By.linkText(tab));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.linkText(tab), 5);
        }

    }
}
