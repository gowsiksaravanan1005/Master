package Stepdefinitions;

import coreframework.Methods;
import io.cucumber.java.en.Then;

public class Flipkart {
    Methods methods= new Methods();


    @Then("Search Mobiles in search bar")
    public void searchMobilesInSearchBar() {
    methods.EnterByXpath("//input[@title='Search for products, brands and more']","Mobiles");
    methods.ClickByXpath("//button[@Type='submit']");
    }

}
