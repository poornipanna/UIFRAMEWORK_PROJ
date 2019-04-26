package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class TestNGTest {


    @BeforeSuite
    public void Test_BeforeSuite()
    {
        System.out.println("Before Suite: Test_BeforeSuite");
    }

    @BeforeTest
    public void Test_BeforeTest()
    {
        System.out.println("Before Test: Test_BeforeTest");
    }

    @BeforeClass
    public void Test_BeforeClass()
    {
        System.out.println("Before Class: Test_BeforeClass");
    }


    @BeforeMethod
    public void Test_BeforeMethod()
    {
        System.out.println("Before Method: Test_BeforeMethod");
    }


    @AfterSuite
    public void Test_AfterSuite()
    {
        System.out.println("After Suite: Test_AfterSuite");
    }

    @AfterTest
    public void Test_AfterTest()
    {
        System.out.println("After Test: Test_AfterTest");
    }

    @AfterClass
    public void Test_AfterClass()
    {
        System.out.println("After Class: Test_AfterClass");
    }

    @AfterMethod
    public void Test_AfterMethod()
    {
        System.out.println("After Method: Test_AfterMethod");
    }


    @Test
    public void Test1()
    {
        System.out.println("Test1-----------");
        assertTrue(false);
      //  SoftAssert softAssert = new SoftAssert();
      //  softAssert.assertEquals(true, false);
        System.out.println("Test1-----------");
        //softAssert.assertEquals(true, false);
        //softAssert.assertAll();
    }

    @Test
    public void Test2()
    {
        System.out.println("Test2------------");
        Assert.assertTrue(false);
    }




}
