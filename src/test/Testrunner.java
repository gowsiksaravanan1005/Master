package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Featurefiles",
        glue = {"coreframework","Stepdefinitions"},
        plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:Reports/cucumber-report/cucumber.html",
                "json:Reports/cucumber-report/cucumber.json"},

        //tags = "@flipkartmobiles or @flipkartwishlist or @flipkartlogin or @flipkartsearch"
        //tags="@flipkartsearch or @flipkartlogin"
        tags="@icici-1"
)
public class Testrunner {

}