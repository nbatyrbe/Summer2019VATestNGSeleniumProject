package com.cybertek.tests.d1_basic_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class NavigationDemo  {
    public static void main(String[] args) throws InterruptedException {


        ArrayList<String> s = new ArrayList<>();

        List<String> l = new ArrayList<>();


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // open a website

          //  go to login page
        //enter credentila + click login buttn
        //verify that user login successfully
        driver.get("https://qa3.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user2");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();

        //another way of find login bttn and click ,
        WebElement loginBttn = driver.findElement(By.id("_submit"));
        loginBttn.click();

        //verify login by title
        String expectedTitle  = "Dashboard";
        String actualTitile = driver.getTitle();

        if(expectedTitle.equals(actualTitile)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected Result --> "  +expectedTitle);
            System.out.println("Actual result -->" + actualTitile);
        }

        //verify login by URL
        String expectedURL = "https://qa3.vytrack.com/";
        String actualURL = driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected URL --> "  +expectedURL);
            System.out.println("Actual URL -->" + actualURL);
        }







//        driver.get("https://cybertekschool.com/");
//
//        // driver.getTitle() --> returns the title of the page
//        System.out.println(driver.getTitle());
//
//
//        // this is not from selenium, it is from java
//        // it pauses the program
//        Thread.sleep(1000);
//
//
//        driver.navigate().to("https://amazon.com/");
//        System.out.println(driver.getTitle());
//
//        Thread.sleep(1000);
//        //  driver.navigate().back() --> goes back to previous page
//        driver.navigate().back();
//        System.out.println(driver.getTitle());
//
//        Thread.sleep(1000);
//        //  driver.navigate().forward() --> goes forward after going back
//        driver.navigate().forward();
//        System.out.println(driver.getTitle());
//
//        Thread.sleep(1000);
//        //  driver.navigate().refresh() --> reloads the current page
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());


    }
}
