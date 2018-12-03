package Pages;

import Utilities.PageEvents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPageFactory extends PageEvents {


    WebDriver driver;
    public SearchPageFactory(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }
    // *********************************************************************************************************
    // *****************************Home&Login-Page-Elements-Mapping**************************************************
    // *********************************************************************************************************
    @FindBy(xpath = "//*/div/h1/a")
    WebElement homePage_Header_Text;

    @FindBy(xpath = "//*/div/div/div[2]/div[2]/div[2]/div/div/a[1]")
    WebElement homePage_SignIn_Link;

    @FindBy(id = "email")
    WebElement signInPage_EmailTextBox;

    @FindBy(id = "password")
    WebElement signInPage_PasswordTextBox;

    @FindBy(id = "loginButton")
    WebElement signInPage_LoginButton;

    @FindBy(xpath = "//*/div/div/div[2]/div[2]/div[2]/div[@class='myAccount']/a[2]")
    WebElement accountName;

    @FindBy(xpath = "//*/div/div/div[2]/div[1]/div[@class='searchArea']/form/input[1]")
    WebElement searchArea;

    @FindBy(xpath = "//*[@id='header']/div/div/div[2]/div[1]/a/span")
    WebElement searchAreaButton;

    @FindBy(xpath = "//*/div/div/div[2]/section/div[@class='header']/div[1]/h1")
    WebElement searchResultText;

    @FindBy(xpath = "//*/div/div/div[2]/div[@class='pagination']") //Scroll here go to second page
    WebElement searchPagePagination;

    @FindBy(xpath = "//*/div/div/div[2]/div[@class='pagination']/a")
    List<WebElement> searchPagePaginationList;

    @FindBy(xpath = "//*[@id='contentListing']/div/div/div[2]/section/div[2]/ul/li")
    List<WebElement> searchResultList;

    @FindBy(xpath = "//*[@id='contentListing']/div/div/div[2]/section/div[2]/ul/li[3]/div/div[1]/a/h3") //[li3] parametrik olabilir
    WebElement listedItemHeader;

    @FindBy(xpath = "//*/div/div/div[2]/section/div[2]/ul/li[3]/div/div[2]/span") //li[3] part will be parametric
    WebElement addFavButton;

    @FindBy(xpath = "//*/div/div/div[2]/div[2]/div[@class='myAccount']/a[1]")
    WebElement myAccountLink;

    @FindBy(xpath = "//*[@id='breadCrumb']/ul/li[2]")
    WebElement breadcrumpMyaccount;

    @FindBy(xpath = "//*[@id='myAccount']/div[1]/div[1]/div[2]/ul/li[6]/a") //li[6] will be parametric
    WebElement leftMenuItem;

    @FindBy(xpath = "//*[@id='myAccount']/div[3]/ul/li[@class='wishGroupListItem favorites']/div/a/h4")
    WebElement wishListHeader;

    @FindBy(xpath = "//*[@id='myAccount']/div[3]/ul/li[@class='wishGroupListItem favorites']/div/ul/li")
    WebElement openWishlistProductList;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/div[3]/div[1]/div[2]/ul/li")
    List<WebElement> wishListProductList;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/div[3]/div[1]/div[2]/ul/li[1]/div/div[1]/a/h3")//li[1] parametrik olabilir. header alıyor
    WebElement wishListRelatedItemHeader;

    @FindBy(xpath = "//*/div[@class='wishProBtns']/span")
    WebElement wishListItemDeleteButton;

    @FindBy(xpath = "/html/body/div[5]/div/div/span")
    WebElement wishListItemDeleteOkButton;

    @FindBy(xpath = "//*[@id='watchList']/div")
    WebElement wishListCurrentStatus;

    @FindBy(xpath = "//*/div/div/div[2]/div[2]/div[2]/div[2]/div/a")
    List<WebElement> accountMenuContentList;






}
