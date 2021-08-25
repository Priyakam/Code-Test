package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//feature --give locations for execution using cucumber options
//on running this feature file will be triggered

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/features/Test.feature", glue="TestDefinition", stepNotifications=true)

public class TestRunner1 {

}
