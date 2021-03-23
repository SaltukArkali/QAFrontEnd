package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SelEasyPage06 {

    public SelEasyPage06(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closeSign;

    @FindBy(id = "btn_basic_example")
    public WebElement startPracticing;

    @FindBy(id = "advanced_example")
    public WebElement advancedLink;

    @FindBy(xpath = "(//a[@class='list-group-item'])[17]")
    public WebElement tablePagination;

    @FindBy(xpath = "//a[@class='page_link']")
    public List<WebElement> listPage;

    @FindBy(xpath = "//a[@href='#']")
    public WebElement pageLinkActive;

    @FindBy(xpath = "//a[.='2']")
    public WebElement page2;

    @FindBy(xpath = "//a[@class='next_link']")
    public WebElement nextLink;

    @FindBy(xpath = "//a[@class='prev_link']")
    public WebElement prevLink;

    @FindBy(id = "myPager")
    public WebElement pages;

    @FindBy(xpath = "//*[.='Table cell']")
    public List<WebElement> tableCellList;

    @FindBy(xpath = "(//a[@class='list-group-item'])[18]")
    public WebElement tableDataSearch;

    @FindBy(xpath = "//*[@id=\"task-table\"]/thead/tr/th")
    public List<WebElement> headerList;

    @FindBy(id = "task-table-filter")
    public WebElement textBox;

    @FindBy(xpath = "//*[@id=\"task-table\"]/tbody/tr[2]/td[3]")
    public WebElement selectedPerson;

    @FindBy(xpath = "//input[@disabled]")
    public List<WebElement> boxList;

    @FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-filter']")
    public WebElement filterButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameBox;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/table/tbody")
    public List<WebElement> listedUsers;


}
