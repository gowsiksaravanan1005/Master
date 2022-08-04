package coreframework;

import Reusables.Methods;
import Reusables.Superclass;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserFactory extends Superclass {
    public static int images = 1;
    public static WebDriverWait wait;
    //public static WebDriver driver;
    Methods methods = new Methods();

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterStep
    public static void takeScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Reports\\Screenshots\\" + images + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            images++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getByteScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public void launchTheApp() {
        if (ReadProperties.get("Browser").contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", ReadProperties.get("ChromeDriver"));
            driver = new ChromeDriver();
            driver.get(ReadProperties.get("URL"));
            driver.manage().window().maximize();
            initializeWait();
        }
    }

    public WebDriverWait initializeWait() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return wait = new WebDriverWait(driver, 180);
    }

    @Before
    public void LaunchTheBrowser() throws IOException {
        launchTheApp();
    }

    @After
    public void CloseDriver() {
        driver.close();
    }

    @AfterStep
    public void as(Scenario music) {
        music.attach(getByteScreenshot(), "image/png", "");
    }

    @BeforeStep
    public void sce(Scenario scenario) {
        System.out.println("Scenario:" + scenario.getName());
        String featureName = FilenameUtils.getBaseName(scenario.getUri().toString());
        System.out.println("Feature: " + featureName);
        String fullFeatureName = FilenameUtils.getName(scenario.getUri().toString());
        System.out.println("Feature file Name: " + fullFeatureName);
    }
}
