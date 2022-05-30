package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Featurefiles",
        glue = {"coreframework","Stepdefinitions"},
        plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        //tags="@icici"
        tags = "@flipkart-3 or @flipkart-1 or @flipkart-4 or @flipkart-2 "
        //tags="@flipkart"
)
public class Testrunner {

}
