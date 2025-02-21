package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity3 or @activity4 or @activity2 or @activity1",
    plugin = {"pretty", "html:test-reports",
    		"json:test-reports/jsonReport.json"},
    monochrome = true
)
 
public class Activity6 {

}