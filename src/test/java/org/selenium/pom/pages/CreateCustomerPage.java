package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.CreateCustomer;

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
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getCreateCustomerPageTitle)).getText();
    }

    public DashboardPage doCreateCustomer(String name,String company,String address,String city,String phone,String email){

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

    public DashboardPage doCreateCustomerPojo(CreateCustomer createCustomer){

        wait.until(ExpectedConditions.visibilityOfElementLocated(getName)).sendKeys(createCustomer.getName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCompany)).sendKeys(createCustomer.getCompany());
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddress)).sendKeys(createCustomer.getAddress());
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCity)).sendKeys(createCustomer.getCity());
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPhone)).sendKeys(createCustomer.getPhone());
        wait.until(ExpectedConditions.visibilityOfElementLocated(getEmail)).sendKeys(createCustomer.getEmail());
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",wait.until(ExpectedConditions.elementToBeClickable(getSubmitBtn)));
        wait.until(ExpectedConditions.elementToBeClickable(getSubmitBtn)).click();
        return new DashboardPage(driver);

    }
}
