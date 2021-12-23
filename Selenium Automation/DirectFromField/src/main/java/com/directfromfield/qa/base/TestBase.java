package com.directfromfield.qa.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.directfromfield.qa.util.TestUtil.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //Declaration
    public static WebDriver driver;
    public static Properties prop;

    //Initialization
    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream propertiesFile = new FileInputStream(currentDir+"\\src\\main\\java\\com\\directfromfield\\qa\\config\\config.properties");
            prop.load(propertiesFile);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //Action
    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", currentDir+"\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", currentDir+"\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else {
            System.setProperty("webdriver.edge.driver", currentDir+"\\src\\main\\resources\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    public static String takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String var = ""+System.currentTimeMillis() + ".png";
        FileUtils.copyFile(scrFile, new File(currentDir+"\\screenshots\\" + var));
        return var;
    }

}
