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

        BrowserUtils.highlight(loginPage.mainLogo);
        Assert.assertTrue(loginPage.mainLogo.isDisplayed());
    }

    public static void navigateTo(String pageName){
        WebElement pageLink = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//a[@aria-label='"+pageName+"']"));
        BrowserUtils.highlight(pageLink);
        pageLink.click();
    }

    public static void waitTillUploadBarDisappears(){
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 600);
            FilePage filePage = new FilePage();
            wait.until(ExpectedConditions.invisibilityOf(filePage.uploadBar));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void uploadFile(String path){
        FilePage filePage = new FilePage();
        BrowserUtils.sleep(1);
        filePage.upload.sendKeys(path);
        TryCloudUtils.waitTillUploadBarDisappears();
    }

    public static void removeUploaded(String fileName){
        WebElement uploadedElm = Driver.getDriver().findElement(By.xpath("//*[contains(text(), '"+fileName+"')]/../..//a[2]"));
        uploadedElm.click();

        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//*[contains(text(), 'Delete file')]"));
        deleteBtn.click();
    }

}
