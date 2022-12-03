package com.qa.tests;

import com.qa.driver.Driver;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentManager;
import com.qa.reports.ExtentReport;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class BaseTest {

    protected BaseTest() {

    }

//    @BeforeSuite
//    public void setUpReport() {
//        ExtentReport.initReports();
//    }
//
//    @AfterSuite
//    public void flushReport() throws IOException {
//        ExtentReport.flushReport();
//    }

    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("Browser"));
    }

    @AfterMethod
    protected void tearDown() {

        Driver.quitDriver();
    }
}
