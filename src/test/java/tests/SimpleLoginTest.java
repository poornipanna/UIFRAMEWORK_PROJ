package tests;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest {



    @Test(groups= "smoke")
    public void testLogin(){

        login("https://spree-vapasi.herokuapp.com", "spree@example.com", "spree123" );

        String expectedTextInHomePage =  driver.findElement(By.linkText("My Account")).getText();
        Assert.assertEquals(expectedTextInHomePage,"My Account","Login failed");
        System.out.println("Login");

    }

    private void login(String url, String loginId, String passWord) {
        driver.navigate().to(url);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(loginId);
        driver.findElement(By.id("spree_user_password")).sendKeys(passWord);
        driver.findElement(By.name("commit")).click();
    }

    @Test(groups = "smoke")
    public void testLogout()
    {
        System.out.println("Logout");}
    }

//https://spree-vapasi.herokuapp.com
//spree@example.com
//spree123