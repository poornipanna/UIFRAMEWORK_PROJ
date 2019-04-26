package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    ChromeDriver driver;

    @BeforeMethod(alwaysRun= true)
    public void setup() {

        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);
        System.setProperty("webdriver.chrome.driver",currentUsersWorkingDir+"/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("BeforeTest- tearDown");
    }

    @AfterMethod(alwaysRun= true)
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("AfterTest- tearDown");

    }

}
