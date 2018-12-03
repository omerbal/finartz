package Pages;

import Utilities.Constant;
import Utilities.PageEvents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home_Login extends PageEvents {

    WebDriver driver;
    public Home_Login(WebDriver driver){

        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    //Get Home Page Header Text
    public String getHomePageHeaderText()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        String header = getElementAttribute(pageFactory.homePage_Header_Text,Constant.explicitTime,"title");
        return header;
    }
    //Click SignIn Button
    public void clickSignInButton()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        clickElement(pageFactory.homePage_SignIn_Link,Constant.explicitTime);
    }
    //Get Login Button Text
    public String getSıgnInPageLoginButtonText()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        String buttonText = getElementText(pageFactory.signInPage_LoginButton);
        return buttonText;
    }
    //Set email
    public void setEmailToLogin(String email)throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        setElement(pageFactory.signInPage_EmailTextBox,Constant.explicitTime,email);
    }
    //Set password
    public void setPasswordToLogin(String password)throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        setElement(pageFactory.signInPage_PasswordTextBox,Constant.explicitTime,password);
    }
    //Click Login Button
    public void clickLoginButton()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        clickElement(pageFactory.signInPage_LoginButton,Constant.explicitTime);
    }
    //Get Account Name After Login
    public String getAccountName()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        String accountName = getElementText(pageFactory.accountName);
        return accountName;
    }
    //Search Any Product
    public void searchAnyProduct(String searchText)throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        setElement(pageFactory.searchArea,Constant.explicitTime,searchText);
        clickElement(pageFactory.searchAreaButton,Constant.explicitTime);
    }
    //Get Searched Product Text
    public String getSearchedProductText()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        String searchedProductText = getElementText(pageFactory.searchResultText);
        return searchedProductText;
    }


}
