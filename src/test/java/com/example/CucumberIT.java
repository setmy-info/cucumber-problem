package com.example;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;

@Cucumber
@IncludeEngines("cucumber")
@SelectClasspathResource("gherkin")
public class CucumberIT {
}
