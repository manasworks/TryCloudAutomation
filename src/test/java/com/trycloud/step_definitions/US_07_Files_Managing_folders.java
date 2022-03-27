package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_07_Files_Managing_folders {

    FilePage filePage = new FilePage();

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

    @When("user click the {string} top-module")
    public void user_click_the_top_module(String module) {
        WebElement topModule = Driver.getDriver().findElement(By.xpath("//div[@class='newFileMenu popovermenu bubble menu open menu-left']//*[normalize-space(.)='"+module+"']"));
        BrowserUtils.highlight(topModule);
        topModule.click();
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
