package com.cybertek.tests.a_hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class locators_1 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://www.ebay.com");
        driver.findElement(By.cssSelector("input[class*=\"te\"]")).sendKeys("watch");
        driver.findElement(By.cssSelector("input[type*=\"su\"]")).click();

        WebElement searchRes = driver.findElement(By.cssSelector("h1[class]"));
//        System.out.println(searchRes.getText());

    }

    @Test
    public void test2(){
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.cssSelector("input#searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.cssSelector("i[class*=\"sea\"]")).click();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href = '/wiki/Selenium_(software)']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/Selenium_(software)");

    }
}
