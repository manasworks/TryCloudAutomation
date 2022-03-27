package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class Base_step_defs {

    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        TryCloudUtils.login();
    }

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        TryCloudUtils.login();
    }

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }
}
