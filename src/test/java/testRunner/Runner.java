package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= ".//Features/login.feature",
		glue="stepdefination",
		dryRun=true,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports/reports_html.html"})

		


public class Runner {
	/*This class will be empty*/

}
