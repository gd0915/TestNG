package techproed.tests;

import org.testng.annotations.*;

public class Day16_Annotations {
    /*
       suite > test > group > class > method
       @Test : creates test case
       @Before and @After : 10 before and after annotations. They are used to control FLOW and DESIGN of the tests
       @Ignore : skip test case
       @Test(enable=false) : Disable the test case. By default, enable=true.(stronger than ignore)
       @Test(priority=number) : prioritize/order test case execution.
       NOTE: Tests that has no priority parameter has a priority of 0. Test(priority=0) ==> runs first
       TestNG test cases runs in alphabetical order by default.
       We should use priority when there are multiple test cases in the same class.
       -3, 0(ALSO TESTS WITH NO PRIORITY ), 4, 9  ==> test execution order
        */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @Test(priority = 2)
    public void test1(){
        System.out.println("test1");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test(enabled = false)
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("test4");
    }
    @Test(priority = 1,groups = "minor-regression-group")
    public void test5(){
        System.out.println("test5");
    }
    @Test(groups = "minor-regression-group")
    public void test6(){
        System.out.println("test6");
    }
}
/*
                     ===TestNG===
    TestNG is open source where NG stands for new generation.
    It is the newer version of JUnit which is another simpler tool.
    TestNG works only with JAVA and requires JDK 7 or higher
    TestNG and JUnit are both Java frameworks.
    TestNG has more annotations and methods. We can do more advanced design with TestNG.
    With TestNG, we can do Unit testing, Integration, Smoke, Regression, End-to-End testing, UI testing, DataBase testing, API testing
    TestNG official documentation is here:
    https://testng.org/doc/documentation-main.html

                    ===WHY TestNG===
    TestNG simply give more control to testers and makes testing effective.
    We can prioritize test cases.
    Multiple before and after annotations.
        Good control the flow of the test execution.
        Same test method can be used multiple times.
    Grouping test cases.
        Dependent methods/groups.
    Parallel testing.
        Multi thread execution. Runs from multiple methods at the same time.
        TestNG is thread safe that enables parallel testing to reduce test
        execution time.
    'Data Driven Testing' with excel or 'data provider'(coming from TestNG, JUnit does not have it).
    Useful for generating HTML, or xml reports.

                    ===TestNG ANNOTATIONS===
        @BeforeSuite @AfterSuite => runs before/ after all tests in this suite ==>>larger than test(testNGProject). There can be only 1 test suite.
        @BeforeTest @AfterTest => run before/after all the test methods(not each test methods, larger scope) after Test  ==>>testNGProject.There can be more than 1 test.
        @BeforeGroups @AfterGroups =>run before/after any specific test group
        @BeforeClass @AfterClass =>run once before/ after each test class
        @BeforeMethod @AfterMethod =>run before/ after each test method (SAME AS  @Before method in the JUnit)


 */
