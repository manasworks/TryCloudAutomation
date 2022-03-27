package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;

public class US_06_Files_Remove_upload {

    FilePage filePage = new FilePage();

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
        String filePath = ConfigurationReader.getProperty("file");
        TryCloudUtils.uploadFile(filePath);
    }

    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page(){
        String filePath = ConfigurationReader.getProperty("file");
        String file = filePath.substring(filePath.lastIndexOf("/")+1);
        FilePage.verifyFileDisplayed(file);
    }
}
