package com.crm24.stepdefinitions;

import com.crm24.pages.CrmLoginPage;
import com.crm24.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    CrmLoginPage crmLoginPage = new CrmLoginPage();
    @Before
    public void setUp(Scenario scenario){
         System.out.println("scenario = " + scenario.getName());

    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();
    }

}
