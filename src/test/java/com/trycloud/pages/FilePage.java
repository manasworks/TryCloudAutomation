package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilePage {

    public FilePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@for='select_all_files']")
    public WebElement firstCheckbox;

    @FindBy (xpath = "//tbody/tr")
    public List<WebElement> listCheckboxes;

    @FindBy (xpath = "//tr[1]//a[@data-action='menu']") public WebElement triDots;
    @FindBy (xpath = "//tr[1]//span[@class='innernametext']") public WebElement fileName;
    @FindBy (xpath = "//*[@class='filename']//*[@class='innernametext']") public WebElement favFileName;

   // @FindBy (xpath = "//*[.='Add to favorites']/..") public WebElement addToFavoritesBtn;
    public static void chooseOption(String option){
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[.='"+option+"']/.."));
        BrowserUtils.highlight(element);
        element.click();
    }

    //@FindBy (xpath = "//*[.='Favorites']") public WebElement favoritesLink;
    public static void clickSubModule(String module){
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[.='"+module+"']"));
        BrowserUtils.highlight(element);
        element.click();
    }
}
