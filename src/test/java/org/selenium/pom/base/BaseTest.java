package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void statDriver(){

        driver=new DriverManager().initializeDriver();

    }

    @AfterMethod
    public void quitDriver(){

        driver.quit();

    }


}