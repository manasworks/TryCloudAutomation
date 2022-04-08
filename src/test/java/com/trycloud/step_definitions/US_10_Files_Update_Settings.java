package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.pages.UploadFilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.File;
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

        uploadFilesPage.file3row.click();
        filePage.optionDelete.click();
        TryCloudUtils.waitTillUploadBarDisappears();
    }

    @When("user uploads file3 with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {
        File file;
        if (System.getProperty("os.name").contains("Windows")){
            String path="./src/test/resources/files/testing.png";
            file=new File(path);
        }else {
            String pathOfProject=System.getProperty("user.dir");
            String pathOfFile="/src/test/resources/files/testing.png";
            String path=pathOfProject+pathOfFile;
            file=new File(path);
        }
        filePage.upload.sendKeys(file.getAbsolutePath());

        // Check if upload failed due to Not Enough Space and retry
        try{
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(filePage.notEnoughSpaceBtn.isDisplayed());
            BrowserUtils.highlight(filePage.notEnoughSpaceBtn);
            filePage.notEnoughSpaceBtn.click();
            BrowserUtils.sleep(1);
            filePage.upload.sendKeys(file.getAbsolutePath());
            TryCloudUtils.waitTillUploadBarDisappears();
        } catch (Exception e){
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TryCloudUtils.waitTillUploadBarDisappears();
        }
    }
}
