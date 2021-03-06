/*package tests;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest {

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("https://spree-vapasi.herokuapp.com", "spree@example.com", "spree123" );
        String expectedTextInHomePage =  driver.findElement(By.linkText("My Account")).getText();
        Assert.assertEquals(expectedTextInHomePage,"My Account","Login failed");
        System.out.println("Login");
    }

    @Test
    public void testSelectProduct()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("https://spree-vapasi.herokuapp.com", "spree@example.com", "spree123").selectCategoryAndProduct
                ("Bags" ,"Ruby on Rails Bag");
    }

    @Test
    public void testAddToCart()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("https://spree-vapasi.herokuapp.com", "spree@example.com", "spree123").selectCategoryAndProduct
                ("Bags" ,"Ruby on Rails Bag").clickAddToCart();

        System.out.println("Success after adding product");
    }




    @Test(groups = "smoke")
    public void testLogout()
    {
        System.out.println("Logout");}
    }
*/