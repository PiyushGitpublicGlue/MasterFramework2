package org.selenium.pom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.CreateCustomer;
import org.selenium.pom.objects.UserLogin;
import org.selenium.pom.pages.CreateCustomerPage;
import org.selenium.pom.pages.DashboardPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.LoginPage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void fillForm() {

        HomePage homePage = new HomePage(getDriver()).load();
        Assert.assertEquals(homePage.getHomePageTitle(), "Test automation practice form");
        Assert.assertEquals(homePage.getFormTitle(), "Textarea practice");
        homePage.doFormSubmit("Name1","0909090909","test@email.com","pwdtest","testaddress");

    }

    @Test
    public void loginUsingExistingUser() throws IOException {
        UserLogin userLogin = JacksonUtils.deserializeJson("myUserLogin.json",UserLogin.class);
        HomePage homePage = new HomePage(getDriver()).load();
        Assert.assertEquals(homePage.getHomePageTitle(), "Test automation practice form");
        LoginPage loginPage = homePage.clickLoginLink();
        DashboardPage dashboardPage = loginPage.doLogin(userLogin);
        Assert.assertEquals(dashboardPage.getDashBoardPageTitle(),"Welcome testitera");
    }
    @Test
    public void loginUsingExistingUserAndCreateNewData() throws IOException {
        UserLogin userLogin = JacksonUtils.deserializeJson("myUserLogin.json",UserLogin.class);
        CreateCustomer createCustomer = JacksonUtils.deserializeJson("myCreateCustomer.json",CreateCustomer.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).load().doLogin(userLogin);
        Assert.assertEquals(dashboardPage.getDashBoardPageTitle(),"Welcome testitera");
        CreateCustomerPage createCustomerPage = dashboardPage.clickCreateCustomerBtn();
        Assert.assertEquals(createCustomerPage.getCreateCustomerPageTitle(),"Create");
        createCustomerPage.doCreateCustomerPojo(createCustomer);
        Assert.assertEquals(dashboardPage.getLatestCreateName(),"NewName");

    }
    @Test
        public void loginUsingExistingUserDeleteAllRecords() throws IOException {
        UserLogin userLogin = JacksonUtils.deserializeJson("myUserLogin.json",UserLogin.class);
        DashboardPage dashboardPage = new LoginPage(getDriver()).load().doLogin(userLogin);
        Assert.assertEquals(dashboardPage.getDashBoardPageTitle(),"Welcome testitera");
        dashboardPage.clickOnDeleteAllRecords();
    }
}

