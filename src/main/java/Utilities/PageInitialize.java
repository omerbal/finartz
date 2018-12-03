package Utilities;

import Pages.Account_Prododuct;
import Pages.Home_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class PageInitialize {

    public WebDriver driver;
    public Home_Login home_login;
    public Account_Prododuct account_prododuct;

    @BeforeClass
    public void setup()throws Exception{

        System.setProperty(Constant.Set_Google_Driver_Property, Constant.Set_Google_Driver_Path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Constant.URL);
        home_login = new Pages.Home_Login(driver);
        account_prododuct = new Pages.Account_Prododuct(driver);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();

    }


}
