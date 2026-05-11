package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features="src/test/resources/features/LoginPage.feature",
			 glue="com.definitions",
					 plugin= {
							 "usage",
							  "rerun:target/failedrerun.txt"},
			 monochrome=true)
public class UsageReports extends AbstractTestNGCucumberTests{

}