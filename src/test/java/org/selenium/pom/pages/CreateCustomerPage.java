package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CreateCustomerPage extends BasePage {

    private final By getCreateCustomerPageTitle = By.xpath("//div//h2");
    private final By getName = By.id("Name");
    private final By getCompany = By.id("Company");
    private final By getAddress = By.id("Address");
    private final By getCity = By.id("City");
    private final By getPhone = By.id("Phone");
    private final By getEmail = By.id("Email");
    private final By getSubmitBtn = By.cssSelector(".btn.btn-primary");

    public CreateCustomerPage(WebDriver driver) {
        super(driver);
    }

    public String getCreateCustomerPageTitle(){
        return driver.findElement(getCreateCustomerPageTitle).getText();
    }

    public DashboardPage doCreateCustomer(String name,String company,String address,String city,String phone,String email){
        driver.findElement(getCreateCustomerPageTitle).getText();
        driver.findElement(getName).sendKeys(name);
        driver.findElement(getCompany).sendKeys(company);
        driver.findElement(getAddress).sendKeys(address);
        driver.findElement(getCity).sendKeys(city);
        driver.findElement(getPhone).sendKeys(phone);
        driver.findElement(getEmail).sendKeys(email);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(getSubmitBtn));
        driver.findElement(getSubmitBtn).click();
        return new DashboardPage(driver);

    }
}
