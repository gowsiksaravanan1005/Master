package Stepdefinitions;

import coreframework.Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static coreframework.Superclass.driver;

public class Flipkart {
    Methods methods= new Methods();
    @Given("Flipkart login")
    public void flipkartLogin() {
        methods.ClickByXpath("//button[@class='_2KpZ6l _2doB4z']");
        methods.Sleep(2000);
        //methods.CheckPageText("//img[@title='Flipkart']","Flipkart");
    }

    @Then("Search Mobiles in search bar")
    public void searchMobilesInSearchBar() {
methods.SendKeys("//input[@title='Search for products, brands and more']","Mobiles");
methods.ClickByXpath("//button[@Type='submit']");
    }

    @Then("Print Mobile details")
    public void printMobileDetails() {
        methods.Sleep(2000);
//        String output= driver.findElement(By.xpath("//span[contains(text(),'CATEGORIES')]")).getText();
//        methods.GetText("//span[contains(text(),'CATEGORIES')]");
    }
}
