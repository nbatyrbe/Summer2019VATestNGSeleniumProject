package com.cybertek.tests.a_hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class hw2 {

    public static void main(String[] args) {
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "Selenium" );


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");

//        for(String s: searchStrs){
//            WebElement inputStr = driver.findElement(By.cssSelector("input[class*='L']"));
//            inputStr.sendKeys(s);
//        }

        WebElement inputStr = driver.findElement(By.cssSelector("input[class*='L']"));
        inputStr.sendKeys("Java");

        WebElement cl = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
        cl.click();

        WebElement firstFind = driver.findElement(By.xpath("//span[.=\"Java | Oracle\"]"));
        firstFind.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.java.com/en/");
        driver.quit();
    }
}
