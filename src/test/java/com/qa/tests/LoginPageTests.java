package com.qa.tests;

import com.qa.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTests extends BaseTest {



    private LoginPageTests() {

    }

    @Test
    public void test1()
    {
       DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }
    @Test
    public void test2()
    {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Mexico", Keys.ENTER);
    }

}
