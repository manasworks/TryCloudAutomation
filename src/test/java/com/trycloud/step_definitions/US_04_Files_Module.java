package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US_04_Files_Module {

    FilePage filePage = new FilePage();

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
}
