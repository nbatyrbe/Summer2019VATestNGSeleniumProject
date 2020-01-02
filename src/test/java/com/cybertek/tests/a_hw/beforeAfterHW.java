package com.cybertek.tests.a_hw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class beforeAfterHW {
    WebDriver driver;

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
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href = \"/registration_form\"] ")).click();
        driver.findElement(By.cssSelector("input[name*=\"bir\"]")).sendKeys("wrong_dob");

       String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();

        Assert.assertEquals(actual,"The date of birth is not valid");
    }

    @Test
    public  void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href = \"/registration_form\"] ")).click();

        String cpp = driver.findElement(By.xpath("//*[.=\"C++\"]")).getText();
        String java = driver.findElement(By.xpath("//*[.=\"Java\"]")).getText();
        String js = driver.findElement(By.xpath("//*[.=\"JavaScript\"]")).getText();

        Assert.assertEquals(cpp, "C++");
        Assert.assertEquals(java, "Java");
        Assert.assertEquals(js, "JavaScript");
    }

    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href = \"/registration_form\"] ")).click();

        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Valid");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("Valid");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("Valida");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys("valid@email.com");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("validvalid");
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("571-000-0000");
        driver.findElement(By.cssSelector("input[name=gender][value=male]")).click();
        driver.findElement(By.cssSelector("input[name=birthday]")).sendKeys("11/11/2011");

        Select departments = new Select(driver.findElement(By.cssSelector("select[name=department]")));
        departments.selectByIndex(1);

        Select jobTitle = new Select(driver.findElement(By.cssSelector("select[name=job_title]")));
        jobTitle.selectByIndex(3);

        driver.findElement(By.xpath("//*[.=\"Java\"]")).click();

        driver.findElement(By.xpath("//*[.=\"Sign up\"]")).click();

        String actual = driver.findElement(By.xpath("//*[.=\"You've successfully completed registration!\"]")).getText();

        Assert.assertEquals(actual, "You've successfully completed registration!");


    }

    @Test
    public void test4(){
        driver.get("https://www.tempmailaddress.com/");
        String tempEmail = driver.findElement(By.xpath("//span[@id='email']")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[contains(text(),\"Sign\")]")).click();

        driver.findElement(By.cssSelector("input[name=full_name]")).sendKeys("Valid");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(tempEmail);

        driver.findElement(By.xpath("//*[.=\"Sign Up\"]")).click();
        String actual = driver.findElement(By.xpath("//*[contains(text(), \"Than\")]")).getText();

        Assert.assertEquals(actual, "Thank you for signing up. Click the button below to return to the home page.");

        driver.navigate().to("https://www.tempmailaddress.com/");


        driver.navigate().refresh();
        WebElement email = driver.findElement(By.xpath("//td[contains(text(),\"Thanks for subscribing to\")]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(email));
        email.click();

        String actual2 = driver.findElement(By.cssSelector("span#predmet")).getText();
        Assert.assertEquals(actual2, "Thanks for subscribing to practice.cybertekschool.com!");

        String actual3 = driver.findElement(By.cssSelector("#odesilatel")).getText();
        Assert.assertEquals(actual3, "do-not-reply@practice.cybertekschool.com");

    }

    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.=\"File Upload\"]")).click();
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/nbatyrbekov/Desktop/test.txt");
        driver.findElement(By.cssSelector("#file-submit")).click();
    }


}
