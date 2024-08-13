package StepRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features/ajio1.feature",
		glue = "StepDef",
		plugin={"html:extreport/cucumber.html"}
		)

public class Runner {

}
