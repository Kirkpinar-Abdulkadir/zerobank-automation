package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_lol.WEN;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FindTransactionsStepDefs {

    FindTransactionsPage transactionsPage = new FindTransactionsPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountSummaryPage().navigateTo("Account Activity");
        new AccountActivityPage().navigateTo("Find Transactions");
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String input) {
        BrowserUtils.waitForVisibility(transactionsPage.description,3);
        transactionsPage.description.clear();
        transactionsPage.description.sendKeys(input.toUpperCase());

    }

    @When("clicks search")
    public void clicks_search() {
        transactionsPage.submitButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String input) {
        //BrowserUtils.waitFor(1);
        List<String> result = BrowserUtils.getElementsText(transactionsPage.descriptionColumn);
        for (String s : result) {
            Assert.assertTrue(s.contains(input));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String input) {
        List<String> result = BrowserUtils.getElementsText(transactionsPage.descriptionColumn);
        for (String s : result) {
            Assert.assertFalse(s.contains(input));
        }
    }


}
