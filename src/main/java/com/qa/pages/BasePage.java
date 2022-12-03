package com.qa.pages;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitFactory;
import com.qa.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy,String elementName)
    {
        WebElement element=ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        element.click();
        try {
            ExtentLogger.pass(elementName + " is clicked ",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void sendKeys(By by, String text,WaitStrategy waitStrategy,String elementName)
    {
        WebElement element= ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        DriverManager.getDriver().findElement(by).sendKeys(text);
        try {
            ExtentLogger.pass(text + " is entered in " +elementName,true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected String getPageTitle()
    {
        return DriverManager.getDriver().getTitle();
    }

}
