package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class LoginPage extends BasePage {

    private final By getLoginPageTitle = By.xpath("//*[contains(text(),'LOGIN')]");
    private final By getLoginName = By.id("Username");
    private final By getLoginPassword = By.id("Password");
    private final By submitLoginBtn = By.xpath("//*[@name='login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginPageTitle(){
        return driver.findElement(getLoginPageTitle).getText();
    }

    public DashboardPage doLogin(){
        driver.findElement(getLoginName).sendKeys("testitera");
        driver.findElement(getLoginPassword).sendKeys("test123");
        driver.findElement(submitLoginBtn).click();
        return new DashboardPage(driver);
    }

}
