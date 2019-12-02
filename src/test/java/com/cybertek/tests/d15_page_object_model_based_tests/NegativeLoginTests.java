package com.cybertek.tests.d15_page_object_model_based_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {

    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys("salesmanager101");
        loginPage.password.sendKeys("greatpassword");
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
    }

    @Test
    public void wrongUsernameTest(){

    }
}
