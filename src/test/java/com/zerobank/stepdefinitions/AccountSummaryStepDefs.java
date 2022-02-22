package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefs {

    @Then("as page title {string} should be displayed")
    public void as_page_title_should_be_displayed(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @Then("the user should see the following account types")
    public void the_user_should_see_the_following_account_types(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedAccountTypes,actualAccountTypes);
    }

    @Then("the user should see the following Credit Accounts headers")
    public void the_user_should_see_the_following_headers(List<String> expectedHeaders) {
        List<String> actualHeaders = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountHeaders);
        Assert.assertEquals(expectedHeaders,actualHeaders);
    }

    @Given("the user accesses the {string} {string} tab")
    public void the_user_accesses_the_tab(String module, String tab) {
        new AccountSummaryPage().navigateTo(module);
        new AccountSummaryPage().navigateTo(tab);
    }

}
