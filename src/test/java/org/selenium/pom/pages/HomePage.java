package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By getPageTitle = By.cssSelector(".display-3");
    private final By formTitle = By.xpath("//*[contains(text(),'Textarea practice')]");
    private final By getName = By.id("name");
    private final By getPhone = By.id("phone");
    private final By getEmail = By.id("email");
    private final By getPassword = By.id("password");
    private final By getAddress = By.id("address");
    private final By getSubmitBtn = By.xpath("//*[contains(text(),'Submit')]");
    private final By getLoginLink = By.xpath("//*[@href='/Login']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/home/automation");
        return this;
    }

    public String getHomePageTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getPageTitle)).getText();
    }

    public String getFormTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(formTitle)).getText();
    }

    public HomePage doFormSubmit(String name,String phone,String email,String password, String address){

        wait.until(ExpectedConditions.visibilityOfElementLocated(getName)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPhone)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getEmail)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPassword)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddress)).sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(getSubmitBtn)).click();
        return this;

    }

    public LoginPage clickLoginLink(){
        wait.until(ExpectedConditions.elementToBeClickable(getLoginLink)).click();
        return new LoginPage(driver);
    }
}
