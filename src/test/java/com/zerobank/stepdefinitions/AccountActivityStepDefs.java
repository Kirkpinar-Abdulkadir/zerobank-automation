package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDefs {

    @When("user navigates to {string}")
    public void user_navigates_to(String tab) {
        new AccountActivityPage().navigateTo(tab);
    }

    @Then("account dropdown default should be {string}")
    public void account_dropdown_default_should_be(String expectedSelectedOption) {
        Select dropdown = new Select(new AccountActivityPage().dropdownElm);
        String actualSelectedOption = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);
    }

    @Then("dropdown should have following options")
    public void dropdown_should_have_following_options(List<String> expectedDropdownList) {
        Select dropdown = new Select(new AccountActivityPage().dropdownElm);
        List<WebElement> dropdownElm = dropdown.getOptions();
        List<String> actualDropdownList = BrowserUtils.getElementsText(dropdownElm);
        Assert.assertEquals(expectedDropdownList,actualDropdownList);
    }

    @Then("transaction table should have column names")
    public void transaction_table_should_have_column_names(List<String> expectedHeaders) {
        BrowserUtils.waitFor(1);
        List<String> actualHeaders = BrowserUtils.getElementsText(new AccountActivityPage().transactionTableHeaders);
        Assert.assertEquals(expectedHeaders,actualHeaders);
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        new AccountActivityPage().navigateTo(link);
    }
}
