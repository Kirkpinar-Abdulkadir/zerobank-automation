package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForeignCurrencyPage extends BasePage{

    @FindBy(id = "pc_currency")
    public WebElement currenciesDropdown;

    @FindBy(id = "pc_amount")
    public WebElement amountInput;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateButton;
}
