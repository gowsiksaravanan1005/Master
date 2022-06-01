package coreframework;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class BrowserFactory extends Superclass{
    //public static WebDriver driver;
    Methods methods=new Methods();
    public static int images=1;
    public void launchTheApp(){
        if(ReadProperties.get("Browser").contains("Chrome")){
            System.setProperty("webdriver.chrome.driver",ReadProperties.get("ChromeDriver"));
            driver=new ChromeDriver();
            driver.get(ReadProperties.get("URL"));
            driver.manage().window().maximize();
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }

   @Before
    public void LaunchTheBrowser(){
        launchTheApp();
    }
//   @After
//    public void CloseDriver(){
//        driver.close();
//    }
    @AfterStep
    public static void takeScreenshot(){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("Screenshots\\"+images+".png");
        try {
            FileUtils.copyFile(srcFile,destFile);
            images++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static byte[] getByteScreenshot(){
        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
    @AfterStep
    public void as(Scenario music){
        music.attach(getByteScreenshot(),"image/png","");
    }
}
