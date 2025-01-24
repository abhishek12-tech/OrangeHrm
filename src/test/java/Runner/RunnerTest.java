package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features="src/test/java/Features",
		extraGlue= {"StepApi"},
		dryRun=false,
		monochrome=true,
		snippets = SnippetType.UNDERSCORE,
	//	tags="@All",
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
public class RunnerTest extends AbstractTestNGCucumberTests{

}
