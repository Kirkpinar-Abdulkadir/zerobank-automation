package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {


    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeInfo) {
        AddNewPayee addNewPayee = new AddNewPayee();
        BrowserUtils.waitForVisibility(addNewPayee.payeeName,10);
        addNewPayee.payeeName.sendKeys(payeeInfo.get("Payee Name"));
        addNewPayee.payeeAddress.sendKeys(payeeInfo.get("Payee Address"));
        addNewPayee.payeeAccount.sendKeys(payeeInfo.get("Account"));
        addNewPayee.payeeDetails.sendKeys(payeeInfo.get("Payee details"));
        addNewPayee.addPayeeButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage = new AddNewPayee().message.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
