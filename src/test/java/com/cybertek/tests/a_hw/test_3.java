package com.cybertek.tests.a_hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test_3 {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("#_submit")).click();

        WebElement activities = driver.findElement(By.xpath("//li[@class=\"dropdown dropdown-level-1\"][4]/a/span"));

        actions = new Actions(driver);
        actions.moveToElement(activities).build();

        WebElement calEvent = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(calEvent).perform();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        calEvent.click();

    }
}
