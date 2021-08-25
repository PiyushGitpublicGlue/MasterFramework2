package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    public void  statDriver(){

        setDriver(new DriverManager().initializeDriver());
        System.out.println("CURRENT THREAD : "+Thread.currentThread().getId()+", "+"DRIVER : "+getDriver());

    }

    @AfterMethod
    public void quitDriver(){

        System.out.println("CURRENT THREAD : "+Thread.currentThread().getId()+", "+"DRIVER : "+getDriver());
        getDriver().quit();


    }


}
