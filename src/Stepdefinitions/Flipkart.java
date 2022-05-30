package Stepdefinitions;

import coreframework.Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static coreframework.Superclass.driver;

public class Flipkart {
    Methods methods= new Methods();


    @Then("Search Mobiles in search bar")
    public void searchMobilesInSearchBar() {
    methods.SendKeys("//input[@title='Search for products, brands and more']","Mobiles");
    methods.ClickByXpath("//button[@Type='submit']");
    }

}
