package com.cybertek.tests.o3_pom;

import com.cybertek.pages.ContactInformationPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInformationTests extends TestBase {
    /**
     * Go to https://qa3.vytrack.com/user/login
     * And login
     * Go to customers —> contacts
     * Click on email mbrackstone9@example.com 
     * Verify that full name is Ms Mariam Brackstone
     * Verify that phone number is 18982323434
     * Verify that email is   mbrackstone9@example.com 
     */
    @Test
    public void contactDetailsTest(){
        // add this test to the extent report
        extentLogger = report.createTest("Contacts details test");

        // And login
        extentLogger.info("Login");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);
        //* Go to customers —> contacts
        extentLogger.info("Go to customers —> contacts");
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Customers", "Contacts");

        // Click on email mbrackstone9@example.com
        extentLogger.info("Click on email mbrackstone9@example.com");
        // wait before click on email
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        // verify
        ContactInformationPage contactInformationPage = new ContactInformationPage();
        extentLogger.info("Verify that full name is Ms Mariam Brackstone");
        String actualName = contactInformationPage.contactFullName.getText();
        Assert.assertEquals("Ms Mariam Brackstone", actualName);
        extentLogger.info("Verify that phone number is 18982323434");

        String actualPhone = contactInformationPage.phone.getText();
        Assert.assertEquals(actualPhone, "+18982323434");

        extentLogger.info("Verify that email is   mbrackstone9@example.com");
        String actualEmail = contactInformationPage.email.getText();
        Assert.assertEquals(actualEmail, "mbrackstone9@example.com");

    }
}





