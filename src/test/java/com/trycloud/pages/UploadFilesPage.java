package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilesPage {

    public UploadFilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Files
    @FindBy(xpath = "//span[.='Ford-F-150']") public WebElement file1Name;
    @FindBy (xpath = "//span[.='Ford-F-150' and @class='innernametext']/../..//a[@class='action action-menu permanent']") public WebElement file1row;

    @FindBy (xpath = "//span[.='TryCloud']") public WebElement file2Name;
    @FindBy (xpath = "//a[@class='action action-menu permanent']") public WebElement file2row;

    @FindBy(xpath = "//span[.='Lorem']") public WebElement file3Name;
    @FindBy (xpath = "//span[.='Lorem' and @class='innernametext']/../..//a[@class='action action-menu permanent']") public WebElement file3row;
}
