package com.qa.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager() {
    }
    private static  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest()
    {
        return  extentTest.get();
    }

    static void setExtentTest(ExtentTest extent)
    {

        extentTest.set(extent);
    }
    static void unload() {
        extentTest.remove();
    }

}
