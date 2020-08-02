package com.crm24.stepdefinitions;

import com.crm24.pages.CrmLoginPage;
import com.crm24.pages.CrmPollPage;
import com.crm24.utilities.BrowserUtils;
import com.crm24.utilities.ConfigurationReader;
import com.crm24.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Crm_Upload_StepDefination {

    CrmPollPage crmPollPage = new CrmPollPage();
    CrmLoginPage crmLoginPage = new CrmLoginPage();

    @Given("User go into given url")
    public void userGoIntoGivenUrl() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("User click on poll button")
    public void user_click_on_poll_button() throws InterruptedException {
        crmPollPage.pollTab.click();
        Thread.sleep(2000);
        
    }
    
    @When("User click on upload file icon")
    public void user_click_on_upload_file_icon() throws InterruptedException {
        crmPollPage.uploadIcon.click();
        Thread.sleep(2000);
        
    }
    
    @Then("User click on Select document from Bixtrix")
    public void user_click_on_select_document_from_bixtrix() {

        crmPollPage.SelectDocumentFromBritix.click();
    }


    @Then("Select document from bixtrix")
    public void selectDocumentFromBixtrix() throws InterruptedException {
//        String windowHandle = Driver.getDriver().getWindowHandle();
//        Driver.getDriver().switchTo().window(windowHandle);
        BrowserUtils.switchToWindow("Select one or more documents");
        Thread.sleep(3000);
      //  BrowserUtils.waitForClickability(crmPollPage.selectDocument,3);
       // Driver.getDriver().findElement(By.xpath("//a[.='Logo.gif']")).click();
        //BrowserUtils.waitForClickability(crmPollPage.selectDocument,3);
        Thread.sleep(3000);
        //BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("//a[.='Logo.gif']")));
        crmPollPage.logoLink.click();

    }

    @And("Click Select document button")
    public void clickSelectDocumentButton() throws InterruptedException {
        Thread.sleep(3000);
        crmPollPage.selectDocument.click();
    }

    @And("Verify uploaded item there")
    public void verifyUploadedItemThere() {
        Assert.assertTrue(crmPollPage.uploadedItem.isDisplayed());
        Driver.closeDriver();
    }

    @Then("User click on Upload files and images")
    public void userClickOnUploadFilesAndImages() {
        crmPollPage.UploadFilesAndImages.sendKeys("/Users/home/Desktop/IMG_1252.PNG");
    }


    @Then("User click on download from external drive")
    public void userClickOnDownloadFromExternalDrive() {
        crmPollPage.downloadFromExternal.click();
    }


    @Then("User click all options one by one to make upload")
    public void userClickAllOptionsOneByOneToMakeUpload() {
        String windowHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(windowHandle);
        List<WebElement> externalDriveList = Driver.getDriver().findElements(By.xpath("//div[@class='bx-file-dialog-tab-item']"));
        for (WebElement each:externalDriveList) {
            each.click();
            WebElement content = Driver.getDriver().findElement(By.xpath("//div[@class='bx-file-dialog-content']"));
            Assert.assertFalse(content.getText().isEmpty());
        }
    }


}
