package Stepdefinitions;

import coreframework.Methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.Iterator;
import java.util.Set;

import static coreframework.Superclass.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Sample {
    Methods methods = new Methods();

    @Given("Flipkart login")
    public void flipkartLogin() {
        methods.ClickByXpath("//button[@class='_2KpZ6l _2doB4z']");
        methods.Sleep(2000);
    }

    @Then("Enter Mobiles {string} in Search bar")
    public void enterMobilesInSearchBar(String Search) {
        methods.SendKeys("//input[@title='Search for products, brands and more']",Search);
        methods.ClickByXpath("//button[@Type='submit']");
    }

    @Then("Print Mobile details")
    public void printMobileDetails() {
        methods.Sleep(2000);
        String numberOfMobiles = methods.GetText("//span[@class='_10Ermr']");
        System.out.println(numberOfMobiles);
        methods.Sleep(5000);
    }

    @Then("Filter the amount")
    public void filterTheAmount() {
        methods.SelectByVisibleText("(//select[@class='_2YxCDZ'])[1]", "₹10000");
        methods.Sleep(2000);
        methods.SelectByVisibleText("(//select[@class='_2YxCDZ'])[2]", "₹20000");
        methods.Sleep(3000);
        String numberOfMobiles2 = methods.GetText("//span[@class='_10Ermr']");
        System.out.println(numberOfMobiles2);
    }

    @And("Filter the brand {string}")
    public void filterTheBrand(String BrandName) {
        methods.SendKeys("(//input[@type='text'])[2]", BrandName);
        methods.ClickByXpath("//div[contains(text(),'SAMSUNG')]");
        methods.ImplicitWait(3000);
        String numberOfMobiles3 = methods.GetText("//span[@class='_10Ermr']");
        System.out.println(numberOfMobiles3);
        methods.ClickByXpath("(//span[contains(text(),'Clear all')])[2]");
        methods.ImplicitWait(10000);
        methods.ExplicitJavaScriptExecutor("//div[@class='QvtND5 _2w_U27']");
        methods.ImplicitWait(3000);
        methods.ClickByXpath("(//div[@class='_3t3VNA _19swAM'])[14]");
        methods.ClickByXpath("(//div[@class='_1Y4Vhm _4FO7b6'])[38]");
        System.out.println("Mobile brand is selected succesfully");
        methods.ClickByXpath("//div[@class='THxusM _3yuvK8']");
        methods.ImplicitWait(3000);
        String numberOfMobiles4= methods.GetText("//span[@class='_10Ermr']");
        System.out.println(numberOfMobiles4);
        //methods.ScrollDown();
        methods.ImplicitWait(10000);
    }

    @Then("Click first mobile in the list")
    public void clickFirstMobileInTheList() {
        methods.ClickByXpath("(//div[@class='_4rR01T'])[1]");
        methods.ImplicitWait(3000);
        methods.WindowHandle();
        String phoneModel = methods.GetText("//span[@class='B_NuCI']");
        System.out.println("Phone model:" + phoneModel);
        String amount = methods.GetText("//div[@class='_30jeq3 _16Jk6d']");
        System.out.println("Amount:" + amount);
        String offer = methods.GetText("//div[@class='_3Ay6Sb _31Dcoz']");
        System.out.println("Offer:" + offer);
        methods.ClickByXpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
        methods.ImplicitWait(3000);
    }

    @Then("Check {string} to estimate delivery")
    public void checkToEstimateDelivery(String Pincode) {
        String Cart=methods.GetText("//div[@class='_3g_HeN']");
        System.out.println(Cart);
        methods.ClickByXpath("//button[@class='_2MMH-I']");
        methods.ImplicitWait(5000);
        methods.SendKeys("//input[@placeholder='Enter pincode']",Pincode);
        methods.ClickByXpath("//div[contains(text(),'Submit')]");
        methods.ImplicitWait(5000);
        String EstimateDate=methods.GetText("//div[@class='_2pqhhf']");
        System.out.println("Estimate date of delivery: "+EstimateDate);
    }

    @Then("Print Rate of the product")
    public void printRateOfTheProduct() {
        methods.ImplicitWait(3000);
        String Amount=methods.GetText("(//div[@class='_2npqm0']//..//..//span)[1]");
        System.out.println("Price: "+Amount);
        String Discount=methods.GetText("(//div[@class='_2npqm0']//..//..//span)[2]");
        System.out.println("Discount: "+Discount);
        String DeliveryCharges=methods.GetText("(//div[@class='_2npqm0']//..//..//span)[3]");
        System.out.println("DeliveryCharges: "+DeliveryCharges);
        String PackagingFee=methods.GetText("(//div[@class='_2npqm0']//..//..//span)[4]");
        System.out.println("PackagingFee: "+PackagingFee);
        String TotalPrice=methods.GetText("(//div[@class='_2npqm0']//..//..//span)[5]");
        System.out.println("TotalPrice: "+TotalPrice);
    }
}