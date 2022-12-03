package com.qa.driver;

import com.qa.constants.FrameWorkConstants;
import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {

    private Driver()
    {

    }

    public static void initDriver(String browserName) {
        if (Objects.isNull(DriverManager.getDriver())) {
            if(browserName.equalsIgnoreCase("Chrome")) {
//           WebDriver driver= WebDriverManager.chromedriver().create();
                System.setProperty("webdriver.chrome.driver", FrameWorkConstants.getChromedriverpath());
                WebDriver driver = new ChromeDriver();
                DriverManager.setDriver(driver);
            }
            if(browserName.equalsIgnoreCase("Firefox")) {
//           WebDriver driver= WebDriverManager.chromedriver().create();
                System.setProperty("webdriver.gecko.driver", FrameWorkConstants.getGeckodriverpath());
                WebDriver driver = new FirefoxDriver();
                DriverManager.setDriver(driver);
            }
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
