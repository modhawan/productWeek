package com.directfromfield.qa.testutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {
    static ExtentReports extent;
    public static ExtentReports extentReportGenerator() {
        String path = System.getProperty("user.dir")+"\\test-output\\MyReport.html";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Mohit Dhawan");
        return extent;
    }
}
