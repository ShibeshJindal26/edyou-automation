package cucumber.options;
import utilities.Log;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features ="./src/test/java/features",glue = {"stepDefination","helper"},tags = "@sanity",
plugin = {"pretty","json:target/jsonReports/report.json"})
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
