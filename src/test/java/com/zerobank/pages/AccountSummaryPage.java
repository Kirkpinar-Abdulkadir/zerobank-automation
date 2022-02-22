package com.zerobank.pages;

import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//*[@class='board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//table[@class='table'])[3]//th")
    public List<WebElement> creditAccountHeaders;

    @FindBy(linkText = "Savings")
    public WebElement savings;

}
