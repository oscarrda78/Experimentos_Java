package com.emotel.core.integration.suite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/",
		glue = {"com.emotel.core.integration.test"},
		plugin = {
				"pretty",
				"html:target/cucumber",
				"json:target/cucumber.json",
				"junit:target/cucumber_junit_report.xml"
		}
	)
public class EMotelIntegrationSuite {

}
