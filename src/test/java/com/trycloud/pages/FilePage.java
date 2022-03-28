package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilePage {

    public FilePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@for='select_all_files']") public WebElement firstCheckbox;
    @FindBy (xpath = "//tbody/tr") public List<WebElement> listCheckboxes;
    @FindBy (xpath = "//tr[1]//a[@data-action='menu']") public WebElement triDots;
    @FindBy (xpath = "//tr[1]//span[@class='innernametext']") public WebElement fileName;
    @FindBy (xpath = "//*[@class='filename']//*[@class='innernametext']") public WebElement favFileName;
    @FindBy (xpath = "//*[@class='button new']") public WebElement addNewFileBtn;
    @FindBy (xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//li[3]//span[2]") public WebElement firstOption;
    @FindBy (xpath = "//*[@for='file_upload_start']") public WebElement uploadFileBtn;
    @FindBy (xpath = "//input[@id='file_upload_start']") public WebElement upload;
    @FindBy (xpath = "//*[@value='New folder']") public WebElement newFolderInput;
    @FindBy (xpath = "//*[@class='icon-confirm']") public WebElement submitFolderNameBtn;
    @FindBy (xpath = "//th[@id='headerDate']//span[.='Deleted']/..") public WebElement deletedFilter;
    @FindBy (xpath = "(//a[@class='action action-restore permanent'])[1]") public WebElement restoreBtn;
    @FindBy (id = "commentsTabView") public WebElement commentBtn;
    @FindBy (xpath = "//div[@class='message' and @data-placeholder='New comment …']") public WebElement commentInput;
    @FindBy (xpath = "//input[@class='submit icon-confirm has-tooltip']") public WebElement commentSubmit;
    @FindBy (xpath = "//div[@id='app-settings-content']//input[@type='checkbox']//following-sibling::label") public List<WebElement> settingsCheckboxesBtn;
    @FindBy (xpath = "//div[@id='app-settings-content']//input[@type='checkbox']") public List<WebElement> settingsCheckboxes;
    @FindBy (xpath = "//p[contains(text(),'used')]") public WebElement storageStatus;
    @FindBy (xpath = "//div[@id='uploadprogressbar']") public WebElement uploadBar;
    @FindBy (xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']/span") public WebElement notEnoughSpaceBtn;

    // Holder for actual file name
    private static String fileNameH;
    public static String getFileNameHolder() {
        return fileNameH;
    }
    public static void setFileNameHolder(String fileNameHolder) {
        fileNameH = fileNameHolder;
    }

    public static void chooseOption(String option){
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@class='fileActionsMenu popovermenu bubble open menu']//*[contains(text(),'"+option+"')]/.."));
        BrowserUtils.highlight(element);
        element.click();
    }

    public static void clickSubModule(String module){
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//*[normalize-space(.)='"+module+"']"));
        BrowserUtils.highlight(element);
        element.click();
    }

    public static void verifyFileDisplayed(String fileName){
        WebElement uploadedFile = Driver.getDriver().findElement(By.xpath("//*[.='"+fileName+"']"));
        BrowserUtils.highlight(uploadedFile);
        Assert.assertTrue(uploadedFile.isDisplayed());

        // Remove uploaded file
        WebElement actionsForUploaded = Driver.getDriver().findElement(By.xpath("//span[.='"+fileName+"']/..//a[2]"));
        BrowserUtils.highlight(actionsForUploaded);
        actionsForUploaded.click();
        FilePage.chooseOption("Delete file");
    }

}
