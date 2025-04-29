package testng;

import org.testng.annotations.*;

public class TestngAnnotationsSequenceDemo {

    @Test (priority = 0)
    public void test1() {
        System.out.println("@Test 1");
    }

    @Test
    public void aa() {
        System.out.println("@Test 2");
    }

    @Test
    public void test3() {
        System.out.println("@Test 2");
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}