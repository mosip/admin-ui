package io.mosip.testrig.adminui.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.mosip.testrig.adminui.utility.BaseClass;

import io.mosip.testrig.adminui.utility.AdminExtentReportManager;

public class AdminTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        AdminExtentReportManager.initReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        if (result.getParameters().length > 0) {
            testName = testName + " | Params: " + java.util.Arrays.toString(result.getParameters());
        }

        AdminExtentReportManager.createTest(testName);
        AdminExtentReportManager.logStep("🟦 Test Started : " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AdminExtentReportManager.logStep("🟩 Test Passed : " + result.getName());
        AdminExtentReportManager.incrementPassed();
        AdminExtentReportManager.getTest().pass("Test Passed Successfully!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        AdminExtentReportManager.logStep("🟥 Test Failed : " + testName);

        AdminExtentReportManager.incrementFailed();

        try {
            WebDriver driver = BaseClass.driver();
            if (driver != null) {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String base64Screenshot = java.util.Base64.getEncoder().encodeToString(screenshotBytes);

                AdminExtentReportManager.attachScreenshotFromBase64(base64Screenshot,
                        "Failure Screenshot - " + testName);
            }
        } catch (Exception e) {
            AdminExtentReportManager.logStep("⚠️ Screenshot capture failed: " + e.getMessage());
        }

        if (AdminExtentReportManager.getTest() != null) {
            AdminExtentReportManager.getTest().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        AdminExtentReportManager.logStep("⚠️ Test Skipped : " + result.getName());
        AdminExtentReportManager.incrementSkipped();
        AdminExtentReportManager.getTest().skip("Skipped due to preconditions/Dependencies");
    }

    @Override
    public void onFinish(ITestContext context) {
        AdminExtentReportManager.flushReport();
    }

    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}
