package tests;


import Pages.ProductDetailsPage;
import Pages.ProductListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class ProductSelectionTest extends BaseTest {


    @Test
    public void addProductToCartTest() {

        ProductListingPage productListingPage = new ProductListingPage(driver);

        productListingPage.addProductToCart("https://spree-vapasi.herokuapp.com", "Bags" ,"Ruby on Rails Bag");

        List<WebElement> listOfItems = driver.findElement(By.id("cart-detail")).findElements(By.id("line_items"));
        int count;
        count = listOfItems.size();

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

    @Test
    void productExitsOrNotTest()
    {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.productDetails("https://spree-vapasi.herokuapp.com", "Ruby on Rails Bag");

        Assert.assertTrue( productDetailsPage.IsProductDisplayed("Ruby on Rails Bag"));
    }

    @Test
    void verifyAddToCartMatchesShoppingCart()
    {
        
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}