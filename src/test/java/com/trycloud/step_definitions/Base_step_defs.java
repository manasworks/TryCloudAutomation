package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Base_step_defs {

    BasePage basePage = new BasePage();

    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        TryCloudUtils.login();
    }

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
