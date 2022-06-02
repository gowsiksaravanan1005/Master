package Stepdefinitions;

import Reusables.Methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Flipkartfunctionality {
    Methods methods = new Methods();

    @Then("Enter Mobiles {string} in Search bar")
    public void enterMobilesInSearchBar(String Search) {
        methods.EnterByXpath("//input[@title='Search for products, brands and more']",Search);
        methods.ClickByXpath("//button[@Type='submit']");
    }

    @Then("Print Mobile details")
    public void printMobileDetails() {
        methods.Sleep(2000);
        String numberOfMobiles = methods.GetTextByXPath("//span[@class='_10Ermr']");
        System.out.println(numberOfMobiles);
        methods.Sleep(5000);
    }

    @Then("Filter the amount")
    public void filterTheAmount() {
        methods.SelectByVisibleText("(//select[@class='_2YxCDZ'])[1]", "₹10000");
        methods.Sleep(2000);
        methods.SelectByVisibleText("(//select[@class='_2YxCDZ'])[2]", "₹20000");
        methods.Sleep(3000);
        String numberOfMobiles2 = methods.GetTextByXPath("//span[@class='_10Ermr']");
        System.out.println(numberOfMobiles2);
    }

    @Then("Search Mobiles in search bar")
    public void searchMobilesInSearchBar() {
        methods.EnterByXpath("//input[@title='Search for products, brands and more']","Mobiles");
        System.out.println("Data entered successfully in search bar");
        methods.ClickByXpath("//button[@Type='submit']");
    }

    @And("Filter the brand {string}")
    public void filterTheBrand(String BrandName) {
        methods.EnterByXpath("(//input[@type='text'])[2]", BrandName);
        methods.ClickByXpath("//div[contains(text(),'SAMSUNG')]");
        methods.ImplicitWait(3000);
        String numberOfMobiles3 = methods.GetTextByXPath("//span[@class='_10Ermr']");
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
        String numberOfMobiles4= methods.GetTextByXPath("//span[@class='_10Ermr']");
        System.out.println(numberOfMobiles4);
        //methods.ScrollDown();
        methods.ImplicitWait(10000);
    }

    @Then("Click first mobile in the list")
    public void clickFirstMobileInTheList() {
        methods.ClickByXpath("(//div[@class='_4rR01T'])[1]");
        methods.ImplicitWait(3000);
        methods.WindowHandle();
        String phoneModel = methods.GetTextByXPath("//span[@class='B_NuCI']");
        System.out.println("Phone model:" + phoneModel);
        String amount = methods.GetTextByXPath("//div[@class='_30jeq3 _16Jk6d']");
        System.out.println("Amount:" + amount);
        String offer = methods.GetTextByXPath("//div[@class='_3Ay6Sb _31Dcoz']");
        System.out.println("Offer:" + offer);
        methods.ClickByXpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
        methods.ImplicitWait(3000);
    }

    @Then("Check {string} to estimate delivery")
    public void checkToEstimateDelivery(String Pincode) {
        String Cart=methods.GetTextByXPath("//div[@class='_3g_HeN']");
        System.out.println(Cart);
        methods.ClickByXpath("//button[@class='_2MMH-I']");
        methods.ImplicitWait(5000);
        methods.EnterByXpath("//input[@placeholder='Enter pincode']",Pincode);
        methods.ClickByXpath("//div[contains(text(),'Submit')]");
        methods.ImplicitWait(5000);
        String EstimateDate=methods.GetTextByXPath("//div[@class='_2pqhhf']");
        System.out.println("Estimate date of delivery: "+EstimateDate);
    }

    @Then("Print Rate of the product")
    public void printRateOfTheProduct() {
        methods.ImplicitWait(3000);
        String Amount=methods.GetTextByXPath("(//div[@class='_2npqm0']//..//..//span)[1]");
        System.out.println("Price: "+Amount);
        String Discount=methods.GetTextByXPath("(//div[@class='_2npqm0']//..//..//span)[2]");
        System.out.println("Discount: "+Discount);
        String DeliveryCharges=methods.GetTextByXPath("(//div[@class='_2npqm0']//..//..//span)[3]");
        System.out.println("DeliveryCharges: "+DeliveryCharges);
        String PackagingFee=methods.GetTextByXPath("(//div[@class='_2npqm0']//..//..//span)[4]");
        System.out.println("PackagingFee: "+PackagingFee);
        String TotalPrice=methods.GetTextByXPath("(//div[@class='_2npqm0']//..//..//span)[5]");
        System.out.println("TotalPrice: "+TotalPrice);

    }
}