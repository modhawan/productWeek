package com.directfromfield.qa.testutil;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class Log4jDemo {
    static Logger logger = LogManager.getLogger(Log4jDemo.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test start "+ result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test Pass "+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        logger.fatal("Test Fail "+result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped "+result.getName());
    }

    public void onFinish(ITestContext context) {
        logger.trace("Test finish");
    }
}