package com.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Test
@CucumberOptions(tags="",
		features="src/test/resources/features",
		 glue={"com.definitions"},
		 plugin= {
				 "pretty",
				 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
				 
		 })
public class CucumberRunnerClass extends AbstractTestNGCucumberTests{

}