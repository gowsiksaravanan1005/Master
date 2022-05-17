package Stepdefinitions;

import coreframework.Methods;
import coreframework.Superclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class YoutubeNews extends Superclass {
    Methods methods = new Methods();
    @And("Click News Symbol")
    public void clickNewsSymbol() {
        methods.Sleep(2000);
        methods.ClickByXpath("//img[@src='//youtube.com/img/explore/destinations/icons/news_color_64.png']");
    }

    @Then("Click Channels in news section")
    public void clickChannelsInNewsSection() {
        methods.Sleep(2000);
        methods.ClickByXpath("//div[@id='tabsContent']//tp-yt-paper-tab[2]//div[@class='tab-content style-scope tp-yt-paper-tab']");
    }

    @Then("Click the subdivision news {string}")
    public void clickTheSubdivisionNews(String subdivisionNews) {
        WebElement l=driver.findElement(By.xpath("//span[text()='"+subdivisionNews+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
        methods.Sleep(3000);
        methods.ClickByXpath("//span[text()='"+subdivisionNews+"']");
    }

    @Then("Click PlayAll symbol")
    public void clickPlayAllSymbol() {
        methods.Sleep(30000);
        methods.ClickByXpath("//span[text()='Top Stories']//..//..//..//..//*[local-name()='g']/*[local-name()='path' and @d='M6,4l12,8L6,20V4z']");
    }
}