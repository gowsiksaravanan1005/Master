package Reusables;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class Methods extends Superclass {
    public void ClickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void ClickByID(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void Sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void EnterByXpath(String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public void EnterByID(String id, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void EnterByWebElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public String GetTextByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String GetTextById(String id) {
        return driver.findElement(By.id(id)).getText();
    }

    public String GetTextByWebElement(WebElement element) {
        return element.getText();
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

    public void ClearByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).clear();
    }

    public void ClearById(String id) {
        driver.findElement(By.id(id)).clear();
    }

    public void ClearByWebElement(WebElement element) {
        element.clear();
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

    public void ImplicitWait(int second) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    public void ScrollUntilTheDataVisibleByXpath(String xpath) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(xpath));
        jse.executeScript("arguments[0].scrollIntoView;", element);
    }

    public void ScrollUntilTheDataVisibleById(String id) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id(id));
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
//        SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-YY HH-mm");
//        Date date = new Date(System.currentTimeMillis());
        File file = new File("Reports\\ConsoleOutput\\"  +scenarioName + ".txt");
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

    public void ClearAndEnterByXPath(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    public void ClearAndEnterById(String id, String data) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(data);
    }

    public void ClearAndEnterByElement(WebElement element, String data) {
        element.clear();
        element.sendKeys();
    }

    public void ClickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    public void FocusOnTheElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public void FocusOnTheElementByUsingID(String id) {
        new Actions(driver).moveToElement(driver.findElement(By.id(id))).perform();
    }

    public void FocusOnTheElementByUsingXPath(String xpath) {
        new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).perform();
    }

    public boolean IsDisplayedByXpath(String xpath) {
        String text = GetTextByXPath(xpath);
        if (text.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsDisplayedById(String id) {
        String text = GetTextByXPath(id);
        if (text.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void CloseCurrentWindow() {
        driver.close();
    }

    public void CloseAllWindows() {
        driver.quit();
    }

    public String GetPageTitle() {
        return driver.getTitle();
    }

    public void CheckIsSelectedByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.isSelected();
    }

    public void CheckIsSelectedById(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.isSelected();
    }

    public FluentWait<WebDriver> FluentWait() {
        return new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(TimeoutException.class)
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
    }

    public void WaitForTheElementToAppear(WebElement element) {
        FluentWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void WaitUntilPageLoad() {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("return document.readyState").toString().equals("complete");
    }


}
