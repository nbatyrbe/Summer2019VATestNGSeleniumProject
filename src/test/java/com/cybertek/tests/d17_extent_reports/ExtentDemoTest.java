package com.cybertek.tests.d17_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ExtentDemoTest {

    // ExtentReports report; —> this class is used for starting and building the reports.
    ExtentReports report;
    // ExtentHtmlReporter htmlReporter; —> this class is used to create the HTML report file
    ExtentHtmlReporter htmlReporter;
    // ExtentTest extentLogger;—>  this will define a test, enables adding logs, authors, test info, etc
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        // initialize the classes
        report = new ExtentReports();

        // create report path
        // System.getProperty("user.dir")  --> returns the location/path of my project
        // "/test-output/report.html" --> report will be in test output folder, name --> report.html
        String path = System.getProperty("user.dir") + "/test-output/report.html";

        // initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        // attach the html report to the report object
        report.attachReporter(htmlReporter);

        // set the title of the report
        htmlReporter.config().setReportName("Vytrack smoke tests");

        // set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("browser", "chrome");
        report.setSystemInfo("whats my name", "John B Goodenough");

    }

    @AfterMethod
    public void close(){
        // this is when the report is actually created
        report.flush();
    }

}
