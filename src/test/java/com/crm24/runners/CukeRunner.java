package com.crm24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html","json:target/cucumber.jason","rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/crm24/stepdefinitions",
        dryRun = false,
        tags = "@smoke"
)

public class CukeRunner {


}

