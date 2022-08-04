package Stepdefinitions;

import PageObject.IciciPage;
import Reusables.Superclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Icici {

    IciciPage iciciPage= new IciciPage();

    @Given("Click the Accounts tab")
    public void clickTheAccountsTab() {
        iciciPage.login();
    }

    @Then("Click Deposit option")
    public void clickDepositOption() {
        iciciPage.deposit();
    }

    @Then("Check the window")
    public void checkTheWindow() {
        iciciPage.titleVerification();
    }


}
