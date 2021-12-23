package com.directfromfield.qa.testutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.directfromfield.qa.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import static com.directfromfield.qa.util.TestUtil.currentDir;

public class Listeners extends Log4jDemo implements ITestListener {

    ExtentReports extent = ExtentReporterNG.extentReportGenerator();
    ExtentTest test;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String name="";

        try {
            name = TestBase.takeScreenshot();
            extentTest.get().addScreenCaptureFromPath(currentDir+"\\screenshots\\"+name, name);
        } catch (IOException e) {
            System.err.println(e);
        }
        extentTest.get().log(Status.PASS, result.getName());
        super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String name="";
        try {
            name = TestBase.takeScreenshot();
            extentTest.get().addScreenCaptureFromPath(currentDir+"\\screenshots\\"+name, name);
        } catch (IOException e) {
            System.out.println(e);
        }
        extentTest.get().log(Status.FAIL, result.getName());
        super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, result.getName());
        super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        super.onFinish(context);
        extent.flush();
    }
}

