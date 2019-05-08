package tests;

import Pages.LoginPage;
import Pages.ProductListingPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

//import pages.*;

@Listeners(CustomListener.class)
public class SpreeAppTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com", "spree123");
        assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
        System.out.println("Success for Login");
    }

    @Test
    public void productListingPageTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com", "spree123")
                .selectCategoryAndProduct
                        ("Mugs", "Ruby on Rails Mug");
        assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
        System.out.println("Success on displaying Products Listing Page");
    }

    @Test
    public void productDetailPageTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com", "spree123").selectCategoryAndProduct
                ("Mugs", "Ruby on Rails Mug").clickAddToCart();
        assertTrue(driver.findElement(By.id("cart-detail")).findElement(By.linkText("Ruby on Rails Mug")).isDisplayed());
        System.out.println("Success on adding product to the Add to Cart Page");
    }

    @Test
    public void shoppingAddressCartAndCheckOutTest() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com", "spree123").selectCategoryAndProduct
                ("Mugs", "Ruby on Rails Mug").clickAddToCart().clickCheckOut();
        assertTrue(driver.findElement(By.xpath("//a[text()='Address']")).isDisplayed());
        System.out.println("Success of adding the product to the CheckOut");
    }

    @Test
    public void checkOutAsGuestUserTest() {
        ProductListingPage plp = new ProductListingPage(driver);
        plp.selectCategoryAndProduct("Bags", "Ruby on Rails Bag").clickAddToCart().clickCheckOut();
        Assert.assertEquals(false, true);
    }

    @Test
    public void registrationTest() {
        ProductListingPage plp = new ProductListingPage(driver);
        plp.selectCategoryAndProduct("Bags", "Ruby on Rails Bag").clickAddToCart().clickCheckOut();
        Pages.RegistrationPage regPage = new Pages.RegistrationPage(driver);
        regPage.createNewAccount("abc@gmail.com", "abcdef", "abcdef");
    }


    @Test(dataProvider = "getCategoryAndProduct")
    public void addingCategoryAndProductTest(String category, String product) {

        driver.findElement(By.linkText(category)).click();
        driver.findElement(By.linkText(product)).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElements(By.xpath("//tbody[@id='line_items']")).size();
        System.out.println(driver.findElements(By.xpath("//tbody[@id='line_items']")).size());
    }

    @DataProvider(name = "getCategoryAndProduct")
    public Object[][] getCategoryAndProduct() {
        return new Object[][]
                {
                        {"Bags", "Ruby on Rails Tote"},
                        {"Mugs", "Ruby on Rails Mug"}

                };
    }


}