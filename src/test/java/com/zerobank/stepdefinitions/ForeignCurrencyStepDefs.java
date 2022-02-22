package com.zerobank.stepdefinitions;

import com.zerobank.pages.ForeignCurrencyPage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ForeignCurrencyStepDefs {

    ForeignCurrencyPage foreignCurrencyPage = new ForeignCurrencyPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencies) {
        BrowserUtils.waitForVisibility(foreignCurrencyPage.currenciesDropdown,10);
        Select dropdown = new Select(foreignCurrencyPage.currenciesDropdown);
        List<WebElement> dropdownElm = dropdown.getOptions();
        dropdownElm.remove(0);
        List<String> actualCurrencies = BrowserUtils.getElementsText(dropdownElm);
        System.out.println("actualCurrencies = " + actualCurrencies);
        Assert.assertEquals(expectedCurrencies,actualCurrencies);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitForVisibility(foreignCurrencyPage.currenciesDropdown,10);
        foreignCurrencyPage.amountInput.sendKeys("200");
        foreignCurrencyPage.calculateButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitForVisibility(foreignCurrencyPage.currenciesDropdown,10);
        Select dropdown = new Select(foreignCurrencyPage.currenciesDropdown);
        dropdown.selectByIndex(6);
        foreignCurrencyPage.calculateButton.click();
    }
}
