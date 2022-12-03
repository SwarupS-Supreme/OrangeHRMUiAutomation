package com.qa.pages;
import com.qa.enums.WaitStrategy;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentManager;
import org.openqa.selenium.By;

import static com.qa.reports.ExtentReport.test;

public final class OrangeHrmHomePage extends BasePage{
    private final By userDropdown= By.xpath("//p[contains(@class,'userdropdown-name')]");
    private final By logoutLink= By.linkText("Logout");

    public OrangeHrmHomePage clickOnWelcomeDropdown()
    {
        click(userDropdown, WaitStrategy.VISIBLE,"Welcome dropdown");
        return this;
    }
    public OrangeHrmLoginPage clickOnLogout() throws InterruptedException {
        click(logoutLink,WaitStrategy.CLICKABLE,"Logout Link");
        return new OrangeHrmLoginPage();
    }



}
