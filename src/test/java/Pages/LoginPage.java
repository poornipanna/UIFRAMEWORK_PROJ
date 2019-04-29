package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {


    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

     public void login(String url, String loginId, String passWord) {
        driver.navigate().to(url);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(loginId);
        driver.findElement(By.id("spree_user_password")).sendKeys(passWord);
        driver.findElement(By.name("commit")).click();
    }

}
