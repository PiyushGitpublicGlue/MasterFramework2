package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.UserLogin;

public class LoginPage extends BasePage {

    private final By getLoginPageTitle = By.xpath("//*[contains(text(),'LOGIN')]");
    private final By getLoginName = By.id("Username");
    private final By getLoginPassword = By.id("Password");
    private final By submitLoginBtn = By.xpath("//*[@name='login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load(){
        load("/Login");
        return this;
    }

    public String getLoginPageTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getLoginPageTitle)).getText();
    }

    public DashboardPage doLogin(UserLogin userLogin){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLoginName)).sendKeys(userLogin.getUserName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLoginPassword)).sendKeys(userLogin.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(submitLoginBtn)).click();
        return new DashboardPage(driver);
    }

}
