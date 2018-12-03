package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageEvents {
    public WebDriver driver;

    public PageEvents(WebDriver driver){

        this.driver = driver;
    }

    //Click Event
    public void clickElement(WebElement element , int ExplicitTime)throws Exception{
        waitForPageLoaded();
        Boolean elementStatus = null;
        try {
            scrollToElement(element);
            wait_element_visible(element, ExplicitTime);
            Boolean elementClickable = isElementClickable(element, ExplicitTime);
            elementStatus = elementClickable;
        } catch (Exception ex) {
            System.out.println(ex);
            elementStatus = false;
        }

        if (elementStatus == true) {
            scrollToElement(element);
            element.click();
            Assert.assertTrue(true);
        } else {
            throw new Exception();
        }
        waitForPageLoaded();
    }

    //Click Js Event
    public void jsClickElement(WebElement element , int ExplicitTime){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    //Set Element
    public void setElement(WebElement element , int ExplicitTime, String setValue)throws Exception{

        waitForPageLoaded();
        wait_element_visible(element, ExplicitTime);
        if (isElementClickable(element, ExplicitTime) == true) {
            scrollToElement(element);
            element.click();
            if (element.getText()=="") {
                element.sendKeys(setValue);
            } else {
                element.clear();
                element.sendKeys(setValue);
            }

        } else {
            throw new Exception();
        }
        waitForPageLoaded();
    }

    //Element Displayed
    public Boolean IsElementDisplayed(WebElement element , int ExplicitTime)throws Exception{
        waitForPageLoaded();
        Thread.sleep(ExplicitTime * 1000);
        try {
            Boolean linkDisplayed = element.isDisplayed();
            return linkDisplayed;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    // Get Element Attribute
    public String getElementAttribute(WebElement element, int explicitTime, String attributeTag) throws Exception {
        waitForPageLoaded();
        wait_element_visible(element, explicitTime);
        if (isElementPresent(element, explicitTime) == true) {
            String gotAttributeValue = element.getAttribute(attributeTag);
            return gotAttributeValue;
        } else {
            throw new Exception();
        }
    }

    // Wait Element Visible
    public void wait_element_visible(WebElement waitedElement, int explicitTime) {
        WebDriverWait wait = new WebDriverWait(driver, explicitTime);
        wait.until(ExpectedConditions.visibilityOf(waitedElement));
    }

    // Is Element Present
    public boolean isElementPresent(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Hover Click
    public void hoverClickAction(WebElement elementHover, WebElement elementClick, int explicitTime) throws Exception {
        // Hover Element
        Actions action = new Actions(driver);
        action.moveToElement(elementHover).perform();
        wait_element_visible(elementClick, explicitTime);
        //		// Click After Hover
        action.moveToElement(elementClick).perform();
        elementClick.click();
        //clickElement(elementClick, explicitTime, elementException, passLogMessage, failLogMessage,Screenshot);
    }

    // Wait Page Load
    public void waitForPageLoaded() throws InterruptedException {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    // Scroll To Element with Java Script
    public void scrollToElement(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element);
        //actions.perform();
        //Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,-200);");
    }

    // Is Element Clickable
    public boolean isElementClickable(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Get Element Text
    public String getElementText(WebElement element) throws Exception {
        waitForPageLoaded();
        String gotTextValue = element.getText();
        return gotTextValue;
    }






}
