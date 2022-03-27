package com.trycloud.step_definitions;

import com.trycloud.pages.FilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_09_Files_Write_comment {

    FilePage filePage = new FilePage();

    @When("user write a {string} comment inside the input box")
    public void user_write_a_comment_inside_the_input_box(String message) {
        BrowserUtils.highlight(filePage.commentBtn);
        filePage.commentBtn.click();

        BrowserUtils.highlight(filePage.commentInput);
        filePage.commentInput.sendKeys(message);
    }

    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        BrowserUtils.highlight(filePage.commentSubmit);
        filePage.commentSubmit.click();
    }

    @Then("Verify the {string} comment is displayed in the comment section")
    public void verify_the_comment_is_displayed_in_the_comment_section(String message) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[.='"+message+"']"));
        BrowserUtils.highlight(element);
        Assert.assertTrue(element.isDisplayed());
    }
}
