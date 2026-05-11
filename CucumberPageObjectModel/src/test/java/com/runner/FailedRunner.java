package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features="src/test/resources/features/LoginPage.feature",
			 glue="com.definitions",
			 plugin= {
					 "pretty",
					 "html:./reports/cucumber-reports/cucumber-html/index.html",
					 "rerun : target/failed-rerun.txt"
			 },
			 monochrome=true)
public class FailedRunner extends AbstractTestNGCucumberTests{

}