package com.qa.listeners;

import com.qa.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<Map<String, String>> list = ExcelUtils.getTestDetails("Sheet1");
        List<IMethodInstance> result = new ArrayList<>();
        for (int i = 0; i < methods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestCaseName"))) {
                    if (list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
                        methods.get(i).getMethod().setDescription(list.get(j).get("TestCaseDescription"));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("InvocationCount")));
                        result.add(methods.get(i));
                    }
                }
            }
        }
        return result;
    }
}
