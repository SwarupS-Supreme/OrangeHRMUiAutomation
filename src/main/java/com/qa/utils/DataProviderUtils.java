package com.qa.utils;

import com.qa.constants.FrameWorkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    static List<Map<String, String>> list= new ArrayList<>();
    @DataProvider
    public static Object[] getData(Method method) {
        if(list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameWorkConstants.getIterationdatasheet());
        }
        List<Map<String, String>> smallList = new ArrayList<>();
        String testName = method.getName();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("TestName").equalsIgnoreCase(testName)) {
                if (list.get(i).get("Execute").equalsIgnoreCase("Yes")) {
                    smallList.add(list.get(i));
                }

            }
        }
        System.out.println("data to be sent is = "+smallList);
        return smallList.toArray();

    }
}
