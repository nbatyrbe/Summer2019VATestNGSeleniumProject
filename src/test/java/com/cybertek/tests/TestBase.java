package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    protected  String url;

    @BeforeMethod
    public void setupMethod() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url =  ConfigurationReader.get("url");
        driver.get(url);

    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
