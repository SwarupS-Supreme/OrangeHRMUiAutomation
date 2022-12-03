package com.qa.tests;

import com.qa.pages.OrangeHrmLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class OrangeHRMLoginTest extends BaseTest {

 @Test(dataProvider = "loginTestData")
 public void checkLogin(String username,String password) throws InterruptedException {
     String title= new OrangeHrmLoginPage().enterUserName(username).enterPassword(password).clickOnLoginButton()
             .clickOnWelcomeDropdown().clickOnLogout().getTitle();
     Assertions.assertThat(title).isEqualTo("OrangeHRM");
 }

 @DataProvider(name = "loginTestData",parallel = true)
 public Object[][] getData()
 {
   return new Object[][]{
           {"Admin", "admin123"},
           {"Admin", "admin23"},
//           {"Admin", "admin123"},
//           {"Admin", "admin23"},

   };
 }

}
