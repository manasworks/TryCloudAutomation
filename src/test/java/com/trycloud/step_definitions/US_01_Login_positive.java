package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_01_Login_positive {

    LoginPage loginPage = new LoginPage();

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        BrowserUtils.highlight(loginPage.usernameInput);
        loginPage.usernameInput.sendKeys(username);
        BrowserUtils.highlight(loginPage.passwordInput);
        loginPage.passwordInput.sendKeys(password);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        BrowserUtils.highlight(loginPage.loginBtn);
        loginPage.loginBtn.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        BrowserUtils.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
        BrowserUtils.highlight(loginPage.mainLogo);
        Assert.assertTrue(loginPage.mainLogo.isDisplayed());
    }
}
