package com.trycloud.utilities;

import com.trycloud.pages.FilePage;
import com.trycloud.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TryCloudUtils {



    public static void login(){
        LoginPage loginPage = new LoginPage();

        BrowserUtils.highlight(loginPage.usernameInput);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("user4"));

        BrowserUtils.highlight(loginPage.passwordInput);
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("pass")+ Keys.ENTER);

        BrowserUtils.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
        BrowserUtils.highlight(loginPage.mainLogo);
        Assert.assertTrue(loginPage.mainLogo.isDisplayed());
    }

    public static void navigateTo(String pageName){
        WebElement pageLink = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//a[@aria-label='"+pageName+"']"));
        BrowserUtils.highlight(pageLink);
        pageLink.click();
        BrowserUtils.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
    }

    public static void waitTillUploadBarDisappears(){
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ConfigurationReader.getNumber("timeout"));
            FilePage filePage = new FilePage();
            wait.until(ExpectedConditions.invisibilityOf(filePage.uploadBar));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
