package PageObject;

import Reusables.Methods;
import Reusables.Superclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IciciPage extends Superclass {

    public IciciPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[contains(text(),'Later')])[1]")
    WebElement later;
    @FindBy(xpath = "//span[contains(text(),'Accounts')]")
    WebElement account;
    @FindBy(xpath = "(//label[contains(text(),'Deposits')])[1]")
    WebElement deposit;
    @FindBy(xpath = "(//a[@class='ic-more'])[16]")
    WebElement btnmore;
    @FindBy(xpath = "//h3[contains(text(),'Fixed Deposit Calculator')]")
    WebElement pageTitle;

    public void login() {
        //later.click();
        methods.ClickByWebElement(later);
        methods.ClickByWebElement(account);
    }

    public void deposit() {
        methods.FocusOnTheElement(deposit);
        methods.ClickByWebElement(btnmore);
    }

    public void titleVerification() {
        String text = methods.GetTextByWebElement(pageTitle);
        if (text.contains("Fixed Deposit Calculator")) {
            System.out.println("Launched correctly");
        } else {
            System.out.println("Error in loading page");
        }
    }
}
