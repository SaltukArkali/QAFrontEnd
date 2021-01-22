package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class KitapyurduPagesSBA {
    public KitapyurduPagesSBA(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//span[@class='RveJvd snByac'])[3]")
    public WebElement ichStimmeZu;

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@href='https://www.kitapyurdu.com/']")
    public WebElement kitapYurduLink;

    @FindBy(xpath = "//span[@id='cart-items']")
    public WebElement sepetLink;

    @FindBy(xpath = "//*[@class='empty']")
    public WebElement sepetAciklama;

    @FindBy(xpath = "//span[@class='mn-strong common-sprite']")
    public WebElement enCokSatanLink;

    @FindBy(xpath = "//a[@href='kategori/kitap/1.html']")
    public WebElement kitapEnCokSatan;

    @FindBy(xpath = "//li[@class='mg-b-10']")
    public List<WebElement> cokSatanList;

    @FindBy(xpath = "//*[.='Daha Sonra']")
    public WebElement alertIgnore;

    @FindBy(id = "search-input")
    public WebElement searchBoxAbove;

    @FindBy(xpath = "//span[.='Suç ve Ceza 1']")
    public WebElement sucVeCeza1;

    @FindBy(xpath = "(//span[@class='value'])[12]")
    public WebElement sucVeCeza1Fiyat;

    @FindBy(xpath = "//span[.='Suç ve Ceza 2']")
    public WebElement sucVeCeza2;

    @FindBy(xpath = "(//span[@class='value'])[14]")
    public WebElement sucVeCeza2Fiyat;

    @FindBy(xpath = "(//*[@class='fa fa-shopping-cart'])[12]")
    public WebElement sepeteEkle12;

    @FindBy(xpath = "(//*[@class='fa fa-shopping-cart'])[14]")
    public WebElement sepeteEkle14;

    @FindBy(id = "cart-items")
    public WebElement sepet;

    @FindBy(id = "cart-content")
    public WebElement sepetIcerik;


 //   mg-b-10






}
