package com.qa.constants;
import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

public final class  FrameWorkConstants {
    private FrameWorkConstants() {
    }
    private static final String RESOURCESPATH = System.getProperty("user.dir")+
            "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/driver/chromedriver.exe";
    private static final String GECKODRIVERPATH = RESOURCESPATH + "/driver/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/FrameworkConfig";
    private static final int waitTime=20;
    private static final String EXTENTREPORTFOLDERPATH= System.getProperty("user.dir")+ "/extent-test-output/";
    private static String extentReportFilePath="";
    private static final String EXCELPATH= RESOURCESPATH + "/TestCaseNameData.xlsx";
    private static final String RUNMANAGERSHEET= "Sheet1";
    private static final String ITERATIONDATASHEET= "Data";


    public static String getRunmanagersheet()
    {
        return RUNMANAGERSHEET;
    }

    public static String getIterationdatasheet()
    {
        return ITERATIONDATASHEET;
    }

    public static String getExcelpath()
    {
        return EXCELPATH;
    }

    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty())
        {
            extentReportFilePath= createReportPath();
        }
        return extentReportFilePath;
    }
    public static String createReportPath() {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
        {
             return  EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        }
        else
        {
            return EXTENTREPORTFOLDERPATH + "/index.html";
        }
    }
    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }
    public static String getGeckodriverpath() {
        return GECKODRIVERPATH;
    }

    public static String getConfigfilepath() {
        return CONFIGFILEPATH;
    }

    public static int getWaitTime() {
        return waitTime;
    }


}
