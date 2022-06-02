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
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},

        tags = "@flipkartmobiles or @flipkartwishlist or @flipkartlogin or @flipkartsearch"
        //tags="@flipkartsearch or @flipkartlogin"
        //tags="@flipkartlogin"
        //tags="@petco"
)
public class Testrunner {

}