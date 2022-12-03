package com.qa.pages;
import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHrmLoginPage extends BasePage {

    private final By usernameTextbox = By.xpath("//input[@name='username']");
    private final By passwordTextBox = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");


    public OrangeHrmLoginPage enterUserName(String username) {
        sendKeys(usernameTextbox, username, WaitStrategy.VISIBLE, "Username Textbox");
        return this;
    }

    public OrangeHrmLoginPage enterPassword(String password) {
        sendKeys(passwordTextBox, password, WaitStrategy.VISIBLE, "Password textbox");
        return this;
    }

    public OrangeHrmHomePage clickOnLoginButton() {
        click(loginButton, WaitStrategy.CLICKABLE, "Login Button");
        return new OrangeHrmHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }

}
