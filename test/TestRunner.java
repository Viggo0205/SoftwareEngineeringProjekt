import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"use_cases/SoftwareEngineeringProjekt/ServControll"/* /AddMedarbejderTilProjekt.feature"/*,
		"use_cases/SoftwareEngineeringProjekt/ProjectManager",
		"use_cases/SoftwareEngineeringProjekt/Aktivitet",
		/*"use_cases/SoftwareEngineeringProjekt"*/},
	plugin = { "html:target/cucumber/wikipedia.html"},
	snippets = SnippetType.CAMELCASE,
	glue = { "stepDefinitions"},
	strict = true)
public class TestRunner {
	
}