package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features/deviceaddition.feature", glue="api")
public class TestRunner extends AbstractTestNGCucumberTests{

}

