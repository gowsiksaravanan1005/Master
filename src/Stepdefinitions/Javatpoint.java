package Stepdefinitions;

import PageObject.Javatpoint_Page;
import io.cucumber.java.en.Given;

public class Javatpoint {
    Javatpoint_Page udemyPage=new Javatpoint_Page();

    @Given("Click search")
    public void clickSearch() {
        udemyPage.ClickJava();
    }
}