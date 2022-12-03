package com.qa.listeners;

import com.qa.annotation.FrameworkAnnotation;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentReport;
import org.testng.*;
import java.util.Arrays;

public class ListenerClass implements ISuiteListener, ITestListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
            ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .category());

    }

    //    public void onTestSuccess(ITestResult result)
//    {
//        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed ");
//
//    }
    @Override
    public void onTestFailure(ITestResult result) {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed ", true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped ");
    }

//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        // not implemented. May implement later
//    }
//
//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//        onTestFailure(result);
//    }
//
//
//    public void onStart(ITestContext context) {
//        // not implemented
//    }
//
//    public void onFinish(ITestContext context) {
//        // not implemented
//    }
}
