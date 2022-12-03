package com.qa.tests;

import com.qa.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTests extends BaseTest{

    private HomePageTests() {
    }

    @Test
    public void test2()
    {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Barcelona", Keys.ENTER);
    }

    @Test
    public void test3()
    {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Helsinki", Keys.ENTER);
    }
}