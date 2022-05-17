package coreframework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Methods extends Superclass {
    public void ClickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void ClickByID(String id) {
        driver.findElement(By.xpath(id)).click();
    }

    public void Sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void SendKeys(String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public String GetText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String GetAttribute(String xpath, String attribute) {
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
    }
public void NavigateBack(){
    driver.navigate().back();
}
    public void CheckPageText(String xpath,String text) {
        String title = driver.findElement(By.xpath(xpath)).getText();
        if (title.equals(text)) {
            System.out.println("launched successfully");
        } else {
            System.out.println("error in loading page");
        }}
    public void ClickRadioButton(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void Clear(String xpath) {
        driver.findElement(By.xpath(xpath)).clear();
    }

    public void AlertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void AlertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void AlertGetText(){
        Alert alert=driver.switchTo().alert();
        alert.getText();
    }
    public void SwitchToFrame(String name){
        driver.switchTo().frame(name);
    }
    public void ScrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }
    public void ScrollDownToVisibleText(String xpath){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement element= driver.findElement(By.xpath(xpath));
        jse.executeScript("arguments[0].scrollIntoView;",element);
    }
    public void SelectByVisibleText(String xpath,String value){
        Select se = new Select(driver.findElement(By.xpath(xpath)));
        se.selectByVisibleText(value);
    }
    public void WaitUntilXpath(String xpath){
        WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void LogFile(String scenarioName){
        SimpleDateFormat formatter=new SimpleDateFormat("d-MMM-YY HH-mm");
        Date date=new Date(System.currentTimeMillis());
        File file=new File("ConsoleOutput\\"+scenarioName+formatter.format(date)+".txt");
        PrintStream stream=null;
        try {
            stream=new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(stream);
    }

}
