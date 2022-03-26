package com.trycloud.pages;

import com.trycloud.utilities.Driver;
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
}
