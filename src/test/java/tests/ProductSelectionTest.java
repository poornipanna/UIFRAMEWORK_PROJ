package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class ProductSelectionTest extends BaseTest {


    @Test(priority = 2)
    public void addProductToCartTest() {

        addProductToCart("https://spree-vapasi.herokuapp.com", "Bags" ,"Ruby on Rails Bag");

        List<WebElement> listOfItems = driver.findElement(By.id("cart-detail")).findElements(By.id("line_items"));
        int count= listOfItems.size();

       Iterator item = listOfItems.iterator();


        /*for(int i=0;i < count; i++)
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

    private void addProductToCart(String url, String categoryName, String product) {

        //https://spree-vapasi.herokuapp.com , Bags , Ruby on Rails Bag , add-to-cart-button
        driver.navigate().to(url);

        driver.findElement(By.linkText(categoryName)).click();

        driver.findElement(By.linkText(product)).click();

        driver.findElement(By.id("add-to-cart-button")).click();
    }


    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}