package com.hexagonal.hexagonalTest.options;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/hexagonal/hexagonalTest/features",
		glue = {"stepDefinitions"}
)
public class TestRunner {
}
