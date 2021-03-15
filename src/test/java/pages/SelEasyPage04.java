package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class SelEasyPage04 {

    public SelEasyPage04(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closeSign;

    @FindBy(id = "btn_basic_example")
    public WebElement startPracticing;

    @FindBy(xpath = "//span[@class='round-tabs three']")
    public WebElement intermediateLink;

    @FindBy(xpath = "//*[@id=\"intermediate\"]/div/a[2]")
    public WebElement ajaxFormSubmit;

    @FindBy(id = "title")
    public WebElement nameFormBoxText;

    @FindBy(id = "description")
    public WebElement commentBoxText;

    @FindBy(id = "btn-submit")
    public WebElement submitButton;

    @FindBy(id = "submit-control")
    public WebElement confirmBoxText;

    @FindBy(xpath = "//*[@id=\"intermediate\"]/div/a[3]")
    public WebElement jquerySelectDropdown;

    @FindBy(id = "country")
    public WebElement selectCountry;

    @FindBy(xpath="//select[@class='js-example-basic-multiple select2-hidden-accessible']")
    public WebElement selectState;

    @FindBy(xpath = "//select[@class='js-example-disabled-results select2-hidden-accessible']")
    public WebElement selectUSOutlyingTerritories;

    @FindBy(xpath = "//select[@id='files']")
    public WebElement selectAFile;

    @FindBy(xpath = "//div[@class='list-group']//a[.='Bootstrap List Box']")
    public WebElement bootstrapLink;

    @FindBy(xpath = "//li[@class='list-group-item']")
    public List<WebElement> allItems;

    public void selectItem(String item) {
        for (WebElement w : allItems) {
            if (w.getText().trim().equals(item)) {
                w.click();
                break;
            }
        }
    }

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-left']")
    public WebElement moveToLeft;


    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-right']")
    public WebElement moveToRight;

    @FindBy(xpath = "//a[@title='select all']")
    public List<WebElement> selectAllCheckBox;


}
