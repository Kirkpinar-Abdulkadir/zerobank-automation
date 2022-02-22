package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class PayBillStepDefs {

    PayBillPage payBillPage = new PayBillPage();
    @When("user completes pay")
    public void user_completes_pay() {
        payBillPage.amount.sendKeys("10");
        payBillPage.date.sendKeys("2022-03-08");
        payBillPage.payButton.click();
    }

    @Then("the user get message {string}")
    public void the_user_get_message(String expectedMessage) {
        String actualMessage = payBillPage.payAlert.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user try to complete pay without amount")
    public void user_try_to_complete_pay_without_amount() {
        payBillPage.date.sendKeys("2022-03-08");
        payBillPage.payButton.click();
    }

    @Then("the user get alert {string}")
    public void the_user_get_alert(String expectedAlert) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        String actualAlert = (String)js.executeScript("return arguments[0].validationMessage;", payBillPage.amount);
        Assert.assertEquals(expectedAlert,actualAlert);
    }

    @When("user try to complete pay without date")
    public void user_try_to_complete_pay_without_date() {
        payBillPage.amount.sendKeys("10");
        payBillPage.payButton.click();
    }

    @Then("the user get alert {string} date")
    public void the_user_get_alert_date(String expectedAlert) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        String actualAlert = (String)js.executeScript("return arguments[0].validationMessage;", payBillPage.date);
        Assert.assertEquals(expectedAlert,actualAlert);
    }

}
