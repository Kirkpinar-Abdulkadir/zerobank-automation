package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindTransactionsPage extends BasePage{

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(xpath = "//button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody//td[2]")
    public List<WebElement> descriptionColumn;


}
