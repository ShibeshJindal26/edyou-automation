package cucumber.options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features ="./src/test/java/features",glue = {"stepDefination","helper"},tags = "@sanity",
plugin = {"pretty","json:target/jsonReports/report.json"})
public class testRunner extends AbstractTestNGCucumberTests {

	
}
