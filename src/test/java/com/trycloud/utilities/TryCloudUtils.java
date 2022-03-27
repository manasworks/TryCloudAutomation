package com.trycloud.utilities;

import com.trycloud.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TryCloudUtils {



    public static void login(){
        LoginPage loginPage = new LoginPage();

        BrowserUtils.highlight(loginPage.usernameInput);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("user1"));

        BrowserUtils.highlight(loginPage.passwordInput);
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("pass")+ Keys.ENTER);

        BrowserUtils.highlight(loginPage.mainLogo);
        Assert.assertTrue(loginPage.mainLogo.isDisplayed());
    }

    public static void navigateTo(String pageName){
        WebElement pageLink = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//a[@aria-label='"+pageName+"']"));
        BrowserUtils.highlight(pageLink);
        pageLink.click();
    }


}
