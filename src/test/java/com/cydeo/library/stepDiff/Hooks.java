package com.cydeo.library.stepDiff;

import com.cydeo.library.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    // its like what we were using in TestNg before after ===> it from cucumber NOT Junit
    @Before
    public void setup(){ // befor scenario and after scenario
        System.out.println("before Scenario is running");

    }

    // @After is coming from cucumber. It is running after each scenario
    @After
    public void teardownScenario(Scenario scenario){
        System.out.println("--> It is coming from @After in Hooks ");

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();
    }

}
