package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;


    public ProductListingPage(WebDriver driver)
    {
        this.driver = driver;

    }

    public void addProductToCart(String url, String categoryName, String product) {

        //https://spree-vapasi.herokuapp.com , Bags , Ruby on Rails Bag , add-to-cart-button
        driver.navigate().to(url);

        driver.findElement(By.linkText(categoryName)).click();

        driver.findElement(By.linkText(product)).click();

        driver.findElement(By.id("add-to-cart-button")).click();
    }

}
