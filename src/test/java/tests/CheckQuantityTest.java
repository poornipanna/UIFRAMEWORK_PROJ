package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckQuantityTest extends BaseTest{



    @Test(priority= 3)
    public void checkQuantityOfProductSelectedTest() {

        driver.navigate().to("https://spree-vapasi.herokuapp.com");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.findElement(By.linkText("Bags")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.findElement(By.linkText("Ruby on Rails Bag")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //add-to-cart-button

        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("3");

        driver.findElement(By.id("add-to-cart-button")).click();

        List<WebElement> listOfItems = driver.findElement(By.id("cart-detail")).findElements(By.id("line_items"));
        int count= listOfItems.size();

        Iterator item = listOfItems.iterator();


        for(int i=0;i < count; i++)
        {
            WebElement ele = listOfItems.get(i);
            String productText = ele.getText().split("\n")[0];
            System.out.println("*********"+productText);
            Assert.assertEquals( productText,"Ruby on Rails Bag");
        }


    }





}
