package org.selenium.pom.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase {

    @Test
    public void fillForm() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.findElement(By.cssSelector(".display-3")).getText(), "Test automation practice form");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Textarea practice')]")).getText(), "Textarea practice");
        driver.findElement(By.id("name")).sendKeys("test1");
        driver.findElement(By.id("phone")).sendKeys("0909090909");
        driver.findElement(By.id("email")).sendKeys("testemail@test.com");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("address")).sendKeys("Address1");
        driver.findElement(By.xpath("//*[contains(text(),'Submit')]")).click();
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void loginUsingExistingUser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.findElement(By.cssSelector(".display-3")).getText(), "Test automation practice form");
        driver.findElement(By.xpath("//*[@href='/Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'LOGIN')]")).getText(), "LOGIN");
        driver.findElement(By.id("Username")).sendKeys("testitera");
        driver.findElement(By.id("Password")).sendKeys("test123");
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div//h3")).getText(),"Welcome testitera");
        driver.quit();
    }
    @Test
    public void loginUsingExistingUserAndCreateNewData() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.findElement(By.cssSelector(".display-3")).getText(), "Test automation practice form");
        driver.findElement(By.xpath("//*[@href='/Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'LOGIN')]")).getText(), "LOGIN");
        driver.findElement(By.id("Username")).sendKeys("testitera");
        driver.findElement(By.id("Password")).sendKeys("test123");
        driver.findElement(By.xpath("//*[@name='login']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div//h3")).getText(),"Welcome testitera");
        driver.findElement(By.xpath("//div//*[@href='/Customer/Create']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div//h2")).getText(),"Create");
        driver.findElement(By.id("Name")).sendKeys("test1");
        driver.findElement(By.id("Company")).sendKeys("testComp1");
        driver.findElement(By.id("Address")).sendKeys("testAddress1");
        driver.findElement(By.id("City")).sendKeys("testCity1");
        driver.findElement(By.id("Phone")).sendKeys("0909090909");
        driver.findElement(By.id("Email")).sendKeys("testemail@test.com");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.cssSelector(".btn.btn-primary")));
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'testemail@test.com')]")).getText(),"testemail@test.com");
        Thread.sleep(3000);
        driver.quit();
    }
}

