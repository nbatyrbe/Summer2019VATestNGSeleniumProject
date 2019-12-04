package com.cybertek.tests.d16_pom_2;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitlesTest extends TestBase {

    @Test
    public void verifySubTitleTest(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        // get the page sub title
        String actual = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actual, "Quick Launchpad");
            // change pages
        dashboardPage.navigateToModule("Activities" ,"Calendar Events");
        // get the subtitle of the new page
        actual = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actual, "Calendar Events");

        // MAC
        // opt + cmd + <-- (arrow left) == go back to previous location of the mouse
        // opt + cmd + --> (arrow right) == come back from the place where you went back

        // WIN
        // alt + ctrl + <-- (arrow left) == go back to previous location of the mouse
        // alt + ctrl + --> (arrow right) == come back from the place where you went back


    }
}
