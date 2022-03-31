package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.pages.UploadFilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class US_10_Files_Update_Settings {

    FilePage filePage = new FilePage();
    UploadFilesPage uploadFilesPage = new UploadFilesPage();

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        int i=0;
        for (WebElement each : filePage.settingsCheckboxesBtn) {
            BrowserUtils.highlight(each);
            boolean beforeClick = filePage.settingsCheckboxes.get(i).isSelected();
            each.click();
            boolean afterClick = filePage.settingsCheckboxes.get(i).isSelected();
            Assert.assertNotEquals(beforeClick, afterClick);
            i++;
        }
    }

    String beforeStorage, afterStorage;
    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        beforeStorage = filePage.storageStatus.getText();
    }

    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        afterStorage = filePage.storageStatus.getText();
        Assert.assertNotEquals(beforeStorage, afterStorage);

        // Remove uploaded
        BrowserUtils.highlight(uploadFilesPage.file3row);
        uploadFilesPage.file3row.click();
        BrowserUtils.highlight(filePage.optionDelete);
        filePage.optionDelete.click();
    }

    @When("user uploads file3 with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {
        String filePath = "D:/Uploads/Lorem.txt";
        BrowserUtils.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));

        // Check if file already uploaded.
        try{
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(uploadFilesPage.file3Name.isDisplayed());
        } catch (Exception e){
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            BrowserUtils.highlight(uploadFilesPage.file3row);
            uploadFilesPage.file3row.click();
            BrowserUtils.highlight(filePage.optionDelete);
            filePage.optionDelete.click();
        }

        filePage.upload.sendKeys(filePath);
        TryCloudUtils.waitTillUploadBarDisappears();

    }
}
