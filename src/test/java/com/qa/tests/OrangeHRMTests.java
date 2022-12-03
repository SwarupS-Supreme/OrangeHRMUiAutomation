package com.qa.tests;

import com.qa.annotation.FrameworkAnnotation;
import com.qa.driver.DriverManager;
import com.qa.enums.CategoryType;
import com.qa.listeners.RetryFailedTest;
import com.qa.pages.OrangeHrmLoginPage;
import com.qa.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHRMTests extends BaseTest {

//    @Test(dataProvider = "loginTestDataProvider")
//    public void loginLogoutTest(String username, String password) throws InterruptedException {
//        String title = new OrangeHrmLoginPage().enterUserName(username).enterPassword(password).clickOnLoginButton()
//                .clickOnWelcomeDropdown().clickOnLogout().getTitle();
//        Assertions.assertThat(title).isEqualTo("OrangeHRM");
//    }
//
//    @Test(dataProvider = "loginTestDataProvider")
//    public void newTest(String username, String password) throws InterruptedException {
//        String title = new OrangeHrmLoginPage().enterUserName(username).enterPassword(password).clickOnLoginButton()
//                .clickOnWelcomeDropdown().clickOnLogout().getTitle();
//        Assertions.assertThat(title).isEqualTo("OrangeHRM");
//    }
//
//    @DataProvider(name = "loginTestDataProvider",parallel = true)
//    public Object[][] getData() {
//        return new Object[][]{
//                {"Admin", "admin123"},
//        };
//    }

    //    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class,retryAnalyzer = RetryFailedTest.class)
    @Test
    @FrameworkAnnotation(author = {"Swarup"}, category = {CategoryType.REGRESSION})
    public void loginLogoutTest(Map<String, String> m) throws InterruptedException {
        String title = new OrangeHrmLoginPage().enterUserName(m.get("Username")).enterPassword(m.get("Password")).clickOnLoginButton()
                .clickOnWelcomeDropdown().clickOnLogout().getTitle();
        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }

    //    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTest.class)
    @Test
    public void newTest(Map<String, String> m) throws InterruptedException {
        String title = new OrangeHrmLoginPage().enterUserName(m.get("Username")).enterPassword(m.get("Password")).clickOnLoginButton()
                .clickOnWelcomeDropdown().clickOnLogout().getTitle();
        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }


}
