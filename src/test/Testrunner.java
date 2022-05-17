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
        tags = "@youtubeMusic"
        //tags="@flipkart"
)
public class Testrunner {

}
