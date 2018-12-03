package Cases;

import Pages.Account_Prododuct;
import Utilities.PageInitialize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class AddFavorite extends PageInitialize {


    @Test
    @Parameters({"homePageHeader","signInButtonText","email","password","accountNameParam","searchText","myAccount","wishList",})
    public void ProdcutAddToFavorite(String homePageHeader,String signInButtonText,String email,String password,
    String accountNameParam,String searchText,String myAccount,String wishList) throws Exception {

        String header = home_login.getHomePageHeaderText();
        Assert.assertEquals(header, homePageHeader);
        home_login.clickSignInButton();
        String loginButtonTextBeforeLogin = home_login.getSıgnInPageLoginButtonText();
        Assert.assertEquals(loginButtonTextBeforeLogin, signInButtonText);
        home_login.setEmailToLogin(email);
        home_login.setPasswordToLogin(password);
        home_login.clickLoginButton();
        String accountName = home_login.getAccountName();
        Assert.assertEquals(accountName, accountNameParam);
        home_login.searchAnyProduct(searchText);
        String searchedProductText = home_login.getSearchedProductText();
        Assert.assertEquals(searchedProductText, searchText);
        account_prododuct.getWantedPageFromPagination();
        String listedItemHeader = account_prododuct.getWantedProductHeader();
        account_prododuct.addFavoriteProduct();
        account_prododuct.clickMyAccountLink();
        String accountBreadcrupmText = account_prododuct.getBreadcrumpMyAccountText();
        Assert.assertEquals(accountBreadcrupmText, myAccount);
        String wishListHeader = account_prododuct.clickWishListAndGetFavoriteHeader();
        String wishListHeader2 = wishListHeader.substring(0, 11);
        Assert.assertEquals(wishListHeader2, wishList);
        String wishListProductHeader = account_prododuct.clickWishListProductListAndGetProductHeader();
        Assert.assertEquals(listedItemHeader, wishListProductHeader);
        account_prododuct.clickDeleteProductandApply();
        List<WebElement> productList = account_prododuct.getProductHeaderInWishList();
        Integer productCount = productList.size();
        String wishlistProductItemHeader = null;
        Boolean bool = true;
        for (int i = 1; i <= productCount; i++) {
            wishlistProductItemHeader = productList.get(i).findElement(By.xpath("//*[@id='myAccount']/div[3]/div[1]/div[2]/ul/li[" + i + "]/div/div[1]/a/h3")).getText();
            if (listedItemHeader.equals(wishlistProductItemHeader)) {
                bool = false;
            }
            else{break;}
        }
        Assert.assertTrue(bool);
        account_prododuct.clickSignoutLink();
        String loginButtonTextAfterLogout = home_login.getSıgnInPageLoginButtonText();
        Assert.assertEquals(loginButtonTextAfterLogout, signInButtonText);


    }
}
