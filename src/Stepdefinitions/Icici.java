package Stepdefinitions;

import coreframework.Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static coreframework.Superclass.driver;

public class Icici {
    Methods methods = new Methods();
    @Given("Search ICICI in browser")
    public void searchICICIInBrowser()
        {
            methods.Sleep(2000);
            methods.ClickByXpath("(//div[text()='Later'])[1]");
            methods.Sleep(2000);
            methods.SendKeys("//input[@id='search-chatInput']","Calculator");
            methods.Sleep(2000);
            methods.ClickByXpath("//div[contains(text(),'Fixed Deposit (FD) Calculator')]");
            methods.Sleep(3000);
    }

    @Then("Check the amount")
    public void checkTheAmount() {
       // methods.CheckPageText("//h1[contains(text(),'Fixed Deposit (FD) Calculator')]","Fixed Deposit (FD) Calculator");
        methods.SwitchToFrame("paymframe");
        methods.Sleep(2000);
        methods.ClickRadioButton("(//label[@class='radiobtn'])[2][contains(text(),'Senior Citizen')]");
        methods.SelectByVisibleText("//select[@id='ddlTypeOfFixedDeposit']","Monthly Payout");
        methods.Clear("//input[@id='loanAmount']");
        methods.SendKeys("//input[@id='loanAmount']","20000");
        methods.ClickRadioButton("(//label[@class='radiobtn'])[4][contains(text(),'Days Only')]");
    }

    @Then("Print the values")
    public void printTheValues() {
        String Interest, MaturityDate, MaturityValue, Amount;
        methods.Sleep(2000);
    Interest=methods.GetText("//input[@name='hdRateOfIntrest']");
    MaturityDate=methods.GetText("//input[@name='hdMaturityDate']");
    MaturityValue=methods.GetText("//input[@name='hdMaturityValue']");
    Amount=methods.GetText("//input[@name='hdAIAmount']");
        System.out.println("Values:"+ Interest+" "+MaturityDate+" "+MaturityValue+" "+Amount);
    }
}
