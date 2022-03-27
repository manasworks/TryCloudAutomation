package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US_03_Main_modules {

    BasePage basePage = new BasePage();

    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expected) {
        List<String> actual = new ArrayList<>();
        for (WebElement each : basePage.mainModules) {
            BrowserUtils.hover(each);
            BrowserUtils.highlight(each);
            actual.add(each.getText());
        }
        Assert.assertEquals(expected, actual);
    }
}
