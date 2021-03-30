package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SelEasyPage07 {

    public SelEasyPage07(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closeSign;

    @FindBy(id = "btn_basic_example")
    public WebElement startPracticing;

    @FindBy(id = "advanced_example")
    public WebElement advancedLink;

    @FindBy(xpath = "(//a[@class='list-group-item'])[19]")
    public WebElement tableFilter;

    @FindBy(xpath = "//table[@class='table table-filter']/tbody/tr")
    public List<WebElement> elementList;

    @FindBy(xpath = "//button[@data-target='pendiente']")
    public WebElement orangeButton;

    @FindBy(xpath = "(//a[@class='list-group-item'])[20]")
    public WebElement tableSortSearch;

    @FindBy(xpath = "//table[@id='example']/tbody/tr")
    public List<WebElement> listOfItemsPerPage;

    @FindBy(xpath = "//a[@data-dt-idx='1']")
    public WebElement page1;

    @FindBy(xpath = "//a[@data-dt-idx='2']")
    public WebElement page2;

    @FindBy(xpath = "//a[@data-dt-idx='3']")
    public WebElement page3;

    @FindBy(xpath = "//a[@data-dt-idx='4']")
    public WebElement page4;

    @FindBy(id = "example_info")
    public WebElement infoText;

    @FindBy(xpath = "//table[@id='example']/tbody/tr/td[6]")
    public List<WebElement> listOfSalary;

    @FindBy(xpath = "//select[@name='example_length']")
    public WebElement show;

    @FindBy(id = "myPager")
    public WebElement pages;



}
