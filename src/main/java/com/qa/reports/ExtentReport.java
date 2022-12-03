package com.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.constants.FrameWorkConstants;
import com.qa.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private static ExtentReports extent;
    public static ExtentTest test;

    private ExtentReport() {
    }

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("UI Automation");
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }

    public static void addAuthor(String[] authors) {
        for (String author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentManager.getExtentTest().assignCategory(String.valueOf(category));
        }
    }
}
