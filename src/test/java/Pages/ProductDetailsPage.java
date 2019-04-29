package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver)
    {
        this.driver = driver;

    }

    public void productDetails(String url,  String product) {


        //https://spree-vapasi.herokuapp.com , Bags , Ruby on Rails Bag , add-to-cart-button
        driver.navigate().to(url);

        driver.findElement(By.linkText(product)).click();

    }

    public boolean IsProductDisplayed(String product)
    {

        boolean isDisplayed = driver.findElement(By.className(product)).isDisplayed();
        if (isDisplayed)
            return true;
        else
            return false;
    }
}