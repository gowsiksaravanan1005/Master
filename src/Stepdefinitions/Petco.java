package Stepdefinitions;

import Reusables.Methods;
import Reusables.Superclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Reusables.Superclass.driver;

public class Petco{
    Methods methods= new Methods();
    @Given("Click menu option")
    public void clickMenuOption() {
        methods.ClickByXpath("//button[@class='HamburgerButton-sc-131t62c-0 gNevJK']");
    }

    @Then("Select Puppy option in Dog category")
    public void selectPuppyOptionInDogCategory() {
        methods.FocusOnTheElementByUsingXPath("(//button[@type='button'])[3]");
        methods.ClickByXpath("//a[contains(text(),'Puppy Food')]");
        methods.Sleep(2000);
        String Title=methods.GetTextByXPath("//h1[contains(text(),'Puppy Food')]");
        System.out.println("Title="+Title);
    }

    @Then("Get the Puppy food")
    public void getThePuppyFood() {
        List<String> food= new ArrayList<>();
        methods.Sleep(2000);

        int size= driver.findElements(By.xpath("//a[@class='main-link clickable autotag']")).size();
        System.out.println("Size-"+size);
        List<WebElement> Food= driver.findElements(By.xpath("//a[@class='main-link clickable autotag']"));

        methods.Sleep(2000);
        for (int i=1;i<=size;i++){
            methods.Sleep(2000);
            String Foods= methods.GetTextByXPath("(//a[@class='main-link clickable autotag'])["+i+"]");
            if(Foods.length()>1){
                System.out.println(i+Foods);
            }
            else {
                methods.ClickByXpath("//a[@data-toggle='next']");
                Foods= methods.GetTextByXPath("(//a[@class='main-link clickable autotag'])["+i+"]");
                System.out.println(i+Foods);
            }
        }
        System.out.println("Food:"+food);
    }

    @Then("Select Live Fish Food option in Cat category")
    public void selectLiveFishFoodOptionInCatCategory() {
        methods.FocusOnTheElementByUsingXPath("(//button[@type='button'])[4]");
        methods.ClickByXpath("//a[contains(text(),'Best Cat Food')]");
        methods.Sleep(2000);
        String Title=methods.GetTextByXPath("//h1[contains(text(),'Best Cat Food')]");
        System.out.println("Title="+Title);
    }
}
