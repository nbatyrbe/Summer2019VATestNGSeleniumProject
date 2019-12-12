package com.cybertek.tests.d18_data_driven_testing;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTTest extends TestBase {

    @DataProvider()
    public Object[][] userlist() {
        // read from excel in 2d array format
        ExcelUtil qa3Short = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA3-short");
        String[][] dataArray = qa3Short.getDataArray();

        // return the 2d array
        return dataArray;
    }

    @Test(dataProvider = "userlist")
    public void test(String execute, String username, String password, String firstname, String lastname) {
        extentLogger = report.createTest("Testing" + firstname + " " + lastname);

        // login using excel data
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);
        // get the actual
        String actualName = new DashboardPage().userName.getText();

        // expected comes from the excel data
        String expected = firstname + " " + lastname;

        Assert.assertEquals(actualName, expected);

        // we are ignoring the variable execute

    }
}
