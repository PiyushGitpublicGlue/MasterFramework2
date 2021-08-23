package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    public WebDriver initializeDriver(){
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
