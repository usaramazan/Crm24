package com.crm24.stepdefinitions;

import com.crm24.pages.CrmLoginPage;
import com.crm24.utilities.ConfigurationReader;
import com.crm24.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CrmLogin_StepDefinition {
    CrmLoginPage crmLoginPage = new CrmLoginPage();

    @Given("User goes into given url")
    public void userGoesIntoGivenUrl() {
        Driver.getDriver().get("https://login2.nextbasecrm.com/");
    }

    @Given("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        crmLoginPage.usernameInput.sendKeys(username);
        crmLoginPage.passwordInput.sendKeys(password);
    }


    @Then("User click on login button")
    public void userClickOnLoginButton() {
        crmLoginPage.loginButton.click();

    }

    @Then("Verify page title has Portal")
    public void verifyPageTitleHasPortal() {
        String expected = "Portal";
        String actual = Driver.getDriver().getTitle();
        Assert.assertTrue(actual.contains(expected));
    }

    @Then("user click arrow")
    public void userClickArrow() throws InterruptedException {
        crmLoginPage.emailArrow.click();
        Thread.sleep(3000);

    }

    @Then("User logout")
    public void userLogout() throws InterruptedException {
        crmLoginPage.logoutButton.click();
        crmLoginPage.usernameInput.clear();
        Thread.sleep(2000);
    }
}
