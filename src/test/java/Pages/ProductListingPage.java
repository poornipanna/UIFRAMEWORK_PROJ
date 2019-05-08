package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;


    public ProductListingPage(WebDriver driver)
    {
        this.driver = driver;

    }

    public Pages.ProductDetailsPage
    selectCategoryAndProduct(String categoryName, String product) {
        driver.findElement(By.linkText(categoryName)).click();
        driver.findElement(By.linkText(product)).click();
        return new Pages.ProductDetailsPage(driver);

    }

  /*  driver.findElement(By.id("add-to-cart-button")).click();

        return new ShopingCartPage(driver);*/




}
