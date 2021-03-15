package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SelEasyPage05 {

    public SelEasyPage05(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closeSign;

    @FindBy(id = "btn_basic_example")
    public WebElement startPracticing;

    @FindBy(xpath = "//span[@class='round-tabs three']")
    public WebElement intermediateLink;

    @FindBy(xpath = "(//a[.='JQuery List Box'])[3]")
    public WebElement jqueryListBox;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickListResult']")
    public WebElement controlListSelect;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']")
    public WebElement pickListSelect;

    @FindBy(xpath = "//button[@class='pAdd btn btn-primary btn-sm']")
    public WebElement addButton;

    @FindBy(id = "btn-submit")
    public WebElement submitButton;

    @FindBy(xpath = "(//a[.='Data List Filter'])[3]")
    public WebElement dataListFilter;

    @FindBy(id = "input-search")
    public WebElement searchAttendees;

    @FindBy(xpath = "//span[contains(text(),'Email:')]")
    public List<WebElement> emailList;

    @FindBy(xpath = "//*[.='Name: Brian Hoyies']")
    public WebElement nameBrian;

    @FindBy(xpath = "(//a[.='File Download'])[3]")
    public WebElement fileDownload;

    @FindBy(id = "textbox")
    public WebElement enterDataText;

    @FindBy(id = "textarea_feedback")
    public WebElement feedbackText;



}
