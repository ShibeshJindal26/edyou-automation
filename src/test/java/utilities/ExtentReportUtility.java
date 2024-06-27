package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.baseClass;

public class ExtentReportUtility implements ITestListener {
    private ExtentSparkReporter sparkReporter;  // UI of the report
    private ExtentReports extent;  // Populates the common information on the report
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // Create test case entries in the report and update status of the test methods
    
    private String repname;

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repname = "Test-Report-" + timestamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repname); // Specify location of the report

        sparkReporter.config().setDocumentTitle("Automation Report"); // Title of the report
        sparkReporter.config().setReportName("Functional Testing"); // Name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Shibesh Jindal");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Browser name", "Chrome, Firefox, Edge");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Using result.getTestClass().getRealClass().getSimpleName() to get the class name
        String className = result.getTestClass().getRealClass().getSimpleName();
        // Creating test with class name and method name
        test.set(extent.createTest(className + " - " + result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test case PASSED: " + result.getMethod().getMethodName()); // Update status
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test case FAILED: " + result.getMethod().getMethodName());
        test.get().log(Status.FAIL, "Cause: " + result.getThrowable());

        try {
            // Capture screenshot if possible
            baseClass bs = new baseClass();
            String imgPath = baseClass.getDriver() != null ? bs.captureScreenshot(result.getMethod().getMethodName()) : "Driver not initialized, screenshot not captured";
            if (!imgPath.equals("Driver not initialized, screenshot not captured")) {
                test.get().addScreenCaptureFromPath(imgPath); // Add screenshot path to report
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test case SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Finalize the report
    }
}
