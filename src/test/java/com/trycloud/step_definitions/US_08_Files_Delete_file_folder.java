package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_08_Files_Delete_file_folder {

    FilePage filePage = new FilePage();

    @Then("Verify the deleted file is displayed on the page")
    public void verify_the_deleted_file_is_displayed_on_the_page() {
        BrowserUtils.highlight(filePage.deletedFilter);
        filePage.deletedFilter.click();
        filePage.deletedFilter.click();
        String fileName = FilePage.getFileNameHolder();
        WebElement element = Driver.getDriver().findElement(By.xpath("(//td//*[.='"+fileName+"'])[1]"));
        BrowserUtils.highlight(element);
        Assert.assertTrue(element.isDisplayed());
        BrowserUtils.highlight(filePage.restoreBtn);
        filePage.restoreBtn.click();
    }
}
