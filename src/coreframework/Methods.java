package coreframework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

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

    public void NavigateBack() {
        driver.navigate().back();
    }

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

    public void AlertGetText() {
        Alert alert = driver.switchTo().alert();
        alert.getText();
    }

    public void ExplicitJavaScriptExecutor(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void SwitchToFrame(String name) {
        driver.switchTo().frame(name);
    }

    public void ScrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-350)");
    }

    public void ScrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,350)");
    }

    public void ScrollDownAddPixels(String script) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(script);
    }

    public void ImplicitWait(int second) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    public void ScrollDownToVisibleText(String xpath) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(xpath));
        jse.executeScript("arguments[0].scrollIntoView;", element);
    }

    public void SelectByVisibleText(String xpath, String value) {
        Select se = new Select(driver.findElement(By.xpath(xpath)));
        se.selectByVisibleText(value);
    }

    public void WaitUntilXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void Close() {
        driver.close();
    }

    public void Quit() {
        driver.quit();
    }

    public void LogFile(String scenarioName) {
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-YY HH-mm");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("ConsoleOutput\\" + scenarioName + formatter.format(date) + ".txt");
        PrintStream stream = null;
        try {
            stream = new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(stream);
    }

    public void WindowHandle() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }
    }

    public void WindowHandles() {
        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.close();
            }
        }
    }

    public void SwitchToParentWindow() {
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.close();
                System.out.println("Child window closed");
            }
        }
        driver.switchTo().window(mainwindow);
    }

    public void ClearAndEnterData(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }
}