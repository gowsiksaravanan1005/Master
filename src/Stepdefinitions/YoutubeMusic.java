package Stepdefinitions;

import coreframework.BrowserFactory;
import coreframework.Methods;
import coreframework.Superclass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class YoutubeMusic extends Superclass {
    Methods methods = new Methods();

    @Given("Click youtube link in google")
    public void clickYoutubeLinkInGoogle() {
        methods.Sleep(2000);
        methods.LogFile("music");
        methods.ClickByXpath("//h3[text()='YouTube']");
    }

    @And("Click Explore")
    public void clickExplore() {
        methods.Sleep(2000);
        methods.ClickByXpath("//span[text()='Explore']");
    }

    @And("Click Music Symbol")
    public void clickMusicSymbol() {
        methods.Sleep(2000);
        methods.ClickByXpath("//img[@src='//youtube.com/img/explore/destinations/icons/music_color_64.png']");
    }

    @And("Click Search")
    public void clickSearch() {
        methods.ClickByXpath("//input[@id='search']");
    }

    @Then("Enter the data {string} in search")
    public void enterTheDataInSearch(String songName) {
        methods.SendKeys("//input[@id='search']",songName);
    }

    @Then("Click Enter")
    public void clickEnter() {
        WebElement textbox = driver.findElement(By.xpath("//input[@id='search']"));
        textbox.sendKeys(Keys.ENTER);

    }

    @Then("Click the particular song {string}")
    public void clickTheParticularSong(String songName) {
        System.out.println("Song entered");
        methods.Sleep(2000);
        methods.ClickByXpath("//yt-formatted-string[text()='"+songName+"']");
        methods.Sleep(3000);
        driver.navigate().back();
    }
}