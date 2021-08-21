package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;

public class DashboardPage extends BasePage {

    private final By getDashBoardPageTitle = By.xpath("//div//h3");
    private final By getCreateCustomerBtn = By.xpath("//div//*[@href='/Customer/Create']");
    private final By getRowsInTable = By.xpath("//*[@class='table table-hover']//tr");
    private final By getLatestCreateName = By.xpath("//*[@class='table table-hover']//tr//td[1]");
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getDashBoardPageTitle(){
        return driver.findElement(getDashBoardPageTitle).getText();
    }

    public int verifyCustomerCreate(){
        return driver.findElements(getRowsInTable).size();
    }

    public CreateCustomerPage getCreateCustomerBtn(){
        driver.findElement(getCreateCustomerBtn).click();
        return new CreateCustomerPage(driver);
    }

    public String getLatestCreateName(){

       //int totalRecords = driver.findElements(getLatestCreateName).size();
       int counter = 1;
       for(WebElement e:driver.findElements(getLatestCreateName)){

           counter++;
           if(counter==verifyCustomerCreate()){
               return e.getText();
           }
       }
        return null;
    }
}
