package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US_02_Login_negative{

    LoginPage loginPage = new LoginPage();

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String expected) {
        BrowserUtils.highlight(loginPage.warningMessage);
        Assert.assertEquals(expected , loginPage.warningMessage.getText());
    }
}
