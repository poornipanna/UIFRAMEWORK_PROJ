package tests;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;



public class BaseTest {

    public static WebDriver driver;
    String browserName = null;


    @BeforeMethod(alwaysRun= true)
    public void setUp() throws IOException{

        Properties prop = new Properties();
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);
        //this is to establish the connection
        FileInputStream ip = new FileInputStream( currentUsersWorkingDir + "/src/test/java/config/config.properties");

        prop.load(ip);

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", currentUsersWorkingDir + "/src/test/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            driver = new FirefoxDriver();

        }else if(browserName.equals("safari")){
            driver = new SafariDriver();
        }
        else{
            System.out.println("No browser value is given");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }

    public static void captureScreenshot(String testMethodName)   {
        File sourceFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("/Users/vapasi/IdeaProjects/VapasiUiFramework/screenshotsLogs/"+testMethodName+"_"+".jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun= true)
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("AfterTest- tearDown");

    }

}
