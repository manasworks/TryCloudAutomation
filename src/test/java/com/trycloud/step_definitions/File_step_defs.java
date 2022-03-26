package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
        FilePage.chooseOption(option);
        fileName = filePage.fileName.getText();
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String module) {
        FilePage.clickSubModule(module);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        BrowserUtils.highlight(filePage.favFileName);
        Assert.assertEquals(fileName, filePage.favFileName.getText());
    }
}
