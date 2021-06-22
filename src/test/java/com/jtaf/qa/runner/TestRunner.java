package com.jtaf.qa.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * 
 * @author Jaga
 *
 */

@CucumberOptions(features = "classpath:feature/", glue = { "com/jtaf/qa/steps",
		"com/jtaf/qa/test"}, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:rerun/regression/ferguson/desktop/failed_scenarios.txt" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
