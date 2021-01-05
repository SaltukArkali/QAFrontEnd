package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KitapyurduPages {
    public KitapyurduPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//span[@class='RveJvd snByac'])[3]")
    public WebElement ichStimmeZu;
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement googleSearchBox;
    @FindBy(xpath = "(//h3[@class='LC20lb DKV0Md'])[1]")
    public WebElement firstSearchResult;
    @FindBy(id = "cart-items")
    public WebElement myBag;
    @FindBy(id = "cart-content")
    public WebElement myBackCard;
    @FindBy(xpath = "//span[@class='name']")
    public List<WebElement> bestSeller;
    @FindBy(id = "search-input")
    public WebElement searchBox;
    @FindBy(xpath = "//a[.='Suç ve Ceza 1']")
    public WebElement sucVeCeza1;
    @FindBy(xpath = "//a[.='Suç ve Ceza 2']")
    public WebElement sucVeCeza2;
    @FindBy(xpath = "//div[@class='price__item']")
    public WebElement productPrice;
    @FindBy(id = "button-cart")
    public WebElement addToBag;
    @FindBy(xpath = "//td[@class='name']")
    public List<WebElement> listOfBooksInBag;

}