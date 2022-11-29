package PageObject;

import Reusables.Methods;
import Reusables.Superclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Javatpoint_Page extends Superclass {

    public Javatpoint_Page() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a//img[@alt='java']")
    WebElement search_java;

    public void ClickJava(){
        search_java.click();
    }

}