package Stepdefinitions;

import com.aventstack.extentreports.gherkin.model.Feature;
import coreframework.BrowserFactory;
import coreframework.Methods;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.s;
import org.junit.Test;

public class Flipkart {
    Methods methods= new Methods();
    BrowserFactory browserFactory= new BrowserFactory();
    @Given("Flipkart login")
    public void flipkartLogin() {
        methods.LogFile("Login");
        methods.ClickByXpath("//button[@class='_2KpZ6l _2doB4z']");
        System.out.println("Launched successfully-login");
    }

    @Given("Flipkart login for Search")
    public void flipkartLoginForSearch() {
        methods.LogFile("Search");
        methods.ClickByXpath("//button[@class='_2KpZ6l _2doB4z']");
        System.out.println("Launched successfully for search");
        methods.Sleep(2000);
    }

    @Given("Flipkart login for mobile")
    public void flipkartLoginForMobile() {
        methods.LogFile("Mobiles");
        methods.ClickByXpath("//button[@class='_2KpZ6l _2doB4z']");
        System.out.println("Launched successfully for mobiles");
        methods.Sleep(2000);
    }

    @Given("Flipkart login for wishlist")
    public void flipkartLoginForWishlist() {
        methods.LogFile("Wishlist");
        methods.ClickByXpath("//button[@class='_2KpZ6l _2doB4z']");
        System.out.println("Launched successfully for wishlist");
        methods.Sleep(2000);
    }


}
