package Pages;

import Utilities.Constant;
import Utilities.PageEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.CompletionService;

public class Account_Prododuct extends PageEvents {
    WebDriver driver;
    public Account_Prododuct(WebDriver driver){

        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    //Get wanted page from searched result
    public void getWantedPageFromPagination()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        List<WebElement> pageOrderList = pageFactory.searchPagePaginationList;
        WebElement wantedPageOrder = pageOrderList.get(1);
        clickElement(wantedPageOrder, Constant.explicitTime);
    }
    //Get wanted product header
    public String getWantedProductHeader()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        String listedItemHeader = getElementText(pageFactory.listedItemHeader);
        return listedItemHeader;
    }
    //Product Fav Add
    public void addFavoriteProduct()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        List<WebElement> prdocutList = pageFactory.searchResultList;
        prdocutList.get(3);
        clickElement(pageFactory.addFavButton,Constant.explicitTime);
    }
    //Click My Account
    public void clickMyAccountLink()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        clickElement(pageFactory.myAccountLink,Constant.explicitTime);
    }
    //Get Breadcrump Text To Myaccount
    public String getBreadcrumpMyAccountText()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        String accountBreadcrupmText = getElementText(pageFactory.breadcrumpMyaccount);
        return accountBreadcrupmText;
    }
    //Click WishList and Favorite Link
    public String clickWishListAndGetFavoriteHeader() throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        clickElement(pageFactory.leftMenuItem,Constant.explicitTime);
        String wishListHeader = getElementText(pageFactory.wishListHeader);
        return wishListHeader;
    }
    //Open wishlist product list
    public String clickWishListProductListAndGetProductHeader()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        clickElement(pageFactory.openWishlistProductList,Constant.explicitTime);
        String wishlistProductItemHeader = getElementText(pageFactory.wishListRelatedItemHeader);
        return wishlistProductItemHeader;
    }
    //Delete Product From Wishlist and Apply it
    public void clickDeleteProductandApply()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        clickElement(pageFactory.wishListItemDeleteButton,Constant.explicitTime);
        clickElement(pageFactory.wishListItemDeleteOkButton,Constant.explicitTime);
    }
    //Get Each Product Header In WishList
    public List<WebElement> getProductHeaderInWishList()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        List<WebElement> productList = pageFactory.wishListProductList;
        return productList;
    }
    //Click Signout Link
    public void clickSignoutLink()throws Exception{
        SearchPageFactory pageFactory = new SearchPageFactory(driver);
        List<WebElement> accountMenuList = pageFactory.accountMenuContentList;
        hoverClickAction(pageFactory.myAccountLink,accountMenuList.get(8),Constant.explicitTime);
    }

}
