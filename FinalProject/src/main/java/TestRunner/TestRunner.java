package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features= "/Users/danishdogra/eclipse-workspace/UrbanLadderPOM/src/main/java/FeaturesCucumber/UrbanLadderComplete.feature",
		glue="StepDefinations",
		format = {"pretty","html:test-output"},
		dryRun = false
)


public class TestRunner {

}
