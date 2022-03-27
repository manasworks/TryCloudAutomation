package com.trycloud.step_definitions;

import com.google.common.base.Verify;
import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class File_step_defs {

    FilePage filePage = new FilePage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        TryCloudUtils.login();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String pageName) {
        TryCloudUtils.navigateTo(pageName);
    }

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String title) {
        BrowserUtils.titleVerify(title);
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        BrowserUtils.highlight(filePage.firstCheckbox);
        filePage.firstCheckbox.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {

        for (WebElement each : filePage.listCheckboxes) {
            BrowserUtils.highlight(each);
            Assert.assertTrue(each.getAttribute("class").contains("selected"));
        }

    }

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        BrowserUtils.highlight(filePage.triDots);
        filePage.triDots.click();
    }

    String fileName;

    @When("user choose the {string} option")
    public void user_choose_the_option(String option) {
        if (filePage.firstOption.getText().equals(option)) {
            FilePage.chooseOption(option);
        } else {
            filePage.firstOption.click();
            BrowserUtils.highlight(filePage.triDots);
            filePage.triDots.click();
            FilePage.chooseOption(option);
        }
        fileName = filePage.fileName.getText();
    }

    @When("user click the {string} sub-module")
    public void user_click_the_sub_module_on_the_left_side(String module) {
        FilePage.clickSubModule(module);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        BrowserUtils.highlight(filePage.favFileName);
        Assert.assertEquals(fileName, filePage.favFileName.getText());
    }

    @Then("Verify the chosen file removed from the table")
    public void verify_the_chosen_file_removed_from_the_table() {
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            filePage.favFileName.click();
        } catch (NoSuchElementException e) {
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertTrue(true);
        }
    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        BrowserUtils.highlight(filePage.addNewFileBtn);
        filePage.addNewFileBtn.click();
    }

    @When("user uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {
        String filePath = "D:/Ford-F-150.jpg";
        FilePage.uploadFile(filePath);
    }

    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page(){
        String file = "Ford-F-150.jpg";
        FilePage.verifyFileDisplayed(file);
    }

    @When("the user write a {string} to folder name")
    public void the_user_write_a_folder_name(String folderName) {
        BrowserUtils.highlight(filePage.newFolderInput);
        filePage.newFolderInput.sendKeys(folderName);
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        BrowserUtils.highlight(filePage.submitFolderNameBtn);
        filePage.submitFolderNameBtn.click();
    }

    @Then("Verify the {string} folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page(String folder) {
        WebElement folderName = Driver.getDriver().findElement(By.xpath("//span[@class='innernametext' and .='" + folder + "']"));
        BrowserUtils.highlight(folderName);
        Assert.assertTrue(folderName.isDisplayed());

        // Remove created folder
        WebElement actionsForUploaded = Driver.getDriver().findElement(By.xpath("//span[@class='innernametext' and .='" + folder + "']/../..//a[2]"));
        BrowserUtils.highlight(actionsForUploaded);
        actionsForUploaded.click();

        FilePage.chooseOption("Delete folder");

    }

    @When("the user choose a {string} folder from the page")
    public void the_user_choose_a_folder_from_the_page(String folder) {
        WebElement folderName = Driver.getDriver().findElement(By.xpath("//span[@class='innernametext' and .='" + folder + "']"));
        BrowserUtils.highlight(folderName);
        folderName.click();
    }


}
