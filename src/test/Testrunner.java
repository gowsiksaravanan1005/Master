package test;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Featurefiles",
        glue = {"coreframework","Stepdefinitions"},
        plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
               "html:target/cucumber-reports/cucumber.html",
              "json:target/cucumber-reports/cucumber.json"
       },
        tags = "@login"
)
public class Testrunner extends AbstractTestNGCucumberTests {
}