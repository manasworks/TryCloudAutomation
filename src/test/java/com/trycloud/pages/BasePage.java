package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//ul[@id='appmenu']//*[@viewBox='0 0 20 20']/following-sibling::span") public List<WebElement> mainModules;
    @FindBy (xpath = "//a[@aria-controls='header-menu-unified-search']") public WebElement searchBtn;
    @FindBy (xpath = "//input[@type='search']") public WebElement searchInput;
}
