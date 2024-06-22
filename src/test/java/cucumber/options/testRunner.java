package cucumber.options;

import utilities.ExtentReportUtility;
import utilities.Log;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "./src/test/java/features",
    glue = {"stepDefination", "helper"},
    tags = "@test",
    plugin = {"pretty", "json:target/jsonReports/report.json","html:target/cucumber-reports/Cucumber.html",}
)
@Listeners(ExtentReportUtility.class)
public class testRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        Log.info("Test execution started.");
    }

    @AfterClass
    public void teardown() {
        Log.info("Test execution finished.");
    }
}

