package com.duckduckgo.hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");
        driver  = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://start.duckduckgo.com/");
    }

    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
