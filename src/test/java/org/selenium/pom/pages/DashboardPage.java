package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.util.Collections;
import java.util.List;

public class DashboardPage extends BasePage {

    private final By getDashBoardPageTitle = By.xpath("//div//h3");
    private final By getCreateCustomerBtn = By.xpath("//div//*[@href='/Customer/Create']");
    private final By getRowsInTable = By.xpath("//*[@class='table table-hover']//tr");
    private final By getLatestCreateName = By.xpath("//*[@class='table table-hover']//tr//td[1]");
    private final By deleteItems = By.xpath("//*[@class='table table-hover']//tr//td[7]//a[3]");
    private final By getDeletePageTitle = By.xpath("//div//h2");
    private final By clickOnConfirmDelete = By.cssSelector(".btn.btn-outline-danger");
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getDashBoardPageTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getDashBoardPageTitle)).getText();
    }

    public int verifyCustomerCreate(){

        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getRowsInTable)).size();
    }

    public CreateCustomerPage clickCreateCustomerBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(getCreateCustomerBtn)).click();
        return new CreateCustomerPage(driver);
    }

    private By getLatestCreateNameElement(int size){
        return By.xpath("//*[@class='table table-hover']//tr["+size+"]//td[1]");
    }

    public String getLatestCreateName(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getLatestCreateNameElement(verifyCustomerCreate()))).getText();
    }

    private List<WebElement> getDeleteRowsList(){
        if(driver.findElements(deleteItems).size()==0){
            return Collections.emptyList();
        }
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(deleteItems));
    }

    private String getDeletePageTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getDeletePageTitle)).getText();
    }

    public void clickOnDeleteAllRecords(){
        int totalResultsToBeDeleted= getDeleteRowsList().size();
        int counter = 0;
        if(totalResultsToBeDeleted==0){
            System.out.println("NOTHING TO BE DELETED");
        }
        else {
            while (getDeleteRowsList().size() != 0) {

                wait.until(ExpectedConditions.visibilityOfElementLocated(deleteItems)).click();
                getDeletePageTitle();
                wait.until(ExpectedConditions.elementToBeClickable(clickOnConfirmDelete)).click();
                counter++;
                if (counter == totalResultsToBeDeleted) break;

            }
        }


    }
}
