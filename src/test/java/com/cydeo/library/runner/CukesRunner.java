package com.cydeo.library.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        }, //type of report (html), then location (target), cucumber-report -> name, extension -> html
        features = "src/test/resources/features" ,
        glue = "com/cydeo/library/stepDiff",
        dryRun = false,
        tags = "@B26G23-72"
        //  publish = true -> other option

        //  mvn test -Dcucumber.filter.tags=@smoke -> other option



)
public class CukesRunner {





}
