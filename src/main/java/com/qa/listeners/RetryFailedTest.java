package com.qa.listeners;

import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
//        if(count<retries)
//        {
//            count++;
//            return true;
//        }
//        return false;
            if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("Yes")) {
                value = count < retries;
                count++;
            }

        return value;

    }
}
