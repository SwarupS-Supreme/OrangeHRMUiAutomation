package com.qa.factories;
import com.qa.constants.FrameWorkConstants;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory()
    {

    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by)
    {
        WebElement element = null;
        if(waitStrategy==WaitStrategy.CLICKABLE)
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameWorkConstants.getWaitTime()));
            element=wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitStrategy==WaitStrategy.PRESENCE)
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameWorkConstants.getWaitTime()));
            element=wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.VISIBLE)
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameWorkConstants.getWaitTime()));
            element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.NONE)
        {
            element= DriverManager.getDriver().findElement(by);
        }
        return element;
    }
}
