package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public String getHomePageTitle(){
        return driver.findElement(getPageTitle).getText();
    }

    public String getFormTitle(){
        return driver.findElement(formTitle).getText();
    }

    public HomePage doFormSubmit(String name,String phone,String email,String password, String address){

        driver.findElement(getName).sendKeys(name);
        driver.findElement(getPhone).sendKeys(phone);
        driver.findElement(getEmail).sendKeys(email);
        driver.findElement(getPassword).sendKeys(password);
        driver.findElement(getAddress).sendKeys(address);
        driver.findElement(getSubmitBtn).click();
        return this;

    }

    public LoginPage getLoginLink(){
        driver.findElement(getLoginLink).click();
        return new LoginPage(driver);
    }
}
