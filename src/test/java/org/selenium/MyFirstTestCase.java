package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CreateCustomerPage;
import org.selenium.pom.pages.DashboardPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void fillForm() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getHomePageTitle(), "Test automation practice form");
        Assert.assertEquals(homePage.getFormTitle(), "Textarea practice");
        homePage.doFormSubmit("Name1","0909090909","test@email.com","pwdtest","testaddress");
        Thread.sleep(3000);

    }

    @Test
    public void loginUsingExistingUser() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getHomePageTitle(), "Test automation practice form");
        LoginPage loginPage = homePage.getLoginLink();
        DashboardPage dashboardPage = loginPage.doLogin();
        Thread.sleep(3000);
        Assert.assertEquals(dashboardPage.getDashBoardPageTitle(),"Welcome testitera");
    }
    @Test
    public void loginUsingExistingUserAndCreateNewData() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getHomePageTitle(), "Test automation practice form");
        LoginPage loginPage = homePage.getLoginLink();
        DashboardPage dashboardPage = loginPage.doLogin();
        Thread.sleep(3000);
        Assert.assertEquals(dashboardPage.getDashBoardPageTitle(),"Welcome testitera");
        int result = dashboardPage.verifyCustomerCreate();
        System.out.println("ROWS BEFORE CUSTOMER CREATION : "+dashboardPage.verifyCustomerCreate());
        CreateCustomerPage createCustomerPage = dashboardPage.getCreateCustomerBtn();
        Assert.assertEquals(createCustomerPage.getCreateCustomerPageTitle(),"Create");
        createCustomerPage.doCreateCustomer("NewName","NewCompany","NewAddress","NewCity","0909090909","test@test.com");
        Thread.sleep(3000);
        System.out.println("ROWS AFTER CUSTOMER CREATION : "+dashboardPage.verifyCustomerCreate());
        Assert.assertTrue(result+1==dashboardPage.verifyCustomerCreate());
        Assert.assertEquals(dashboardPage.getLatestCreateName(),"NewName");

    }
}

