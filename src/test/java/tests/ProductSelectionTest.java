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

import static org.testng.Assert.assertTrue;


public class ProductSelectionTest extends BaseTest {


    @Test
    public void AddProductToCartTest() {

        driver.navigate().to("https://spree-vapasi.herokuapp.com");

        driver.findElement(By.linkText("Bags")).click();

        driver.findElement(By.linkText("Ruby on Rails Bag")).click();

        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("3");

        driver.findElement(By.id("add-to-cart-button")).click();

        List<WebElement> listOfItems = driver.findElement(By.id("cart-detail")).findElements(By.id("line_items"));
        int count= listOfItems.size();

       Iterator item = listOfItems.iterator();


  /*     for(int i=0;i < count; i++)
        {
            WebElement ele = listOfItems.get(i);
            String productText = ele.getText().split("\n")[0];
            System.out.println("*********"+productText);
            Assert.assertEquals( productText,"Ruby on Rails Bag");
        } */

        for (Iterator<WebElement>  productIterator= listOfItems.iterator();  productIterator.hasNext(); ) {
            WebElement product =   productIterator.next();
            String productText = product.getText().split("\n")[0];
            System.out.println("*********"+productText);
            Assert.assertEquals( productText,"Ruby on Rails Bag");

        }

    }


    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}