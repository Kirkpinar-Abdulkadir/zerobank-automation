package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillPage extends BasePage{

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "alert_content")
    public WebElement payAlert;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement payButton;


}
