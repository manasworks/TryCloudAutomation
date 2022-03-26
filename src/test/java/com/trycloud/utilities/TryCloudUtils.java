package com.trycloud.utilities;

import com.trycloud.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class TryCloudUtils {

    static LoginPage loginPage;

    public static void login(){
        loginPage = new LoginPage();

        BrowserUtils.highlight(loginPage.usernameInput);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("user2"));

        BrowserUtils.highlight(loginPage.passwordInput);
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("pass")+ Keys.ENTER);

        BrowserUtils.highlight(loginPage.mainLogo);
        Assert.assertTrue(loginPage.mainLogo.isDisplayed());
    }


}
