package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);
        Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
        BrowserUtils.waitFor(2);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        String username = ConfigurationReader.get("invalid_username");
        String password = ConfigurationReader.get("invalid_password");
        loginPage.login(username,password);
    }

    @Then("the user should get a warning")
    public void the_user_should_get_a_warning() {
        Assert.assertEquals("Login and/or password are wrong.",loginPage.alertElm.getText());
    }

    @When("the user enters empty credentials")
    public void the_user_enters_empty_credentials() {
        String username = "";
        String password = "";
        loginPage.login(username,password);
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        the_user_is_on_the_login_page();
        the_user_enters_valid_credentials();
    }

    @When("the user logs in with{string} and {string}")
    public void theUserLogsInWithAnd(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitButton.click();
    }
}
