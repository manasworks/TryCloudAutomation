package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_05_Files_AddingToFavorites {

    FilePage filePage = new FilePage();

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        BrowserUtils.highlight(filePage.triDots);
        filePage.triDots.click();
    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String option) {

        String currentFileName = filePage.fileName.getText();

        if (option.contains("favorites") && !filePage.firstOption.getText().equals(option)) {
            filePage.firstOption.click();
            BrowserUtils.highlight(filePage.triDots);
            filePage.triDots.click();
            FilePage.setFileNameHolder(currentFileName);
            FilePage.chooseOption(option);
        } else {
            FilePage.setFileNameHolder(currentFileName);
            FilePage.chooseOption(option);
        }


    }

    @When("user click the {string} sub-module")
    public void user_click_the_sub_module_on_the_left_side(String module) {
        FilePage.clickSubModule(module);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        BrowserUtils.highlight(filePage.favFileName);
        Assert.assertEquals(FilePage.getFileNameHolder(), filePage.favFileName.getText());
    }
}
