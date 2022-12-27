package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import Classes.Driver;

public class SpecialTests {


    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void GreetingTest1(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,a,c);
        String webelem = driver.findElement(By.xpath("/html/body/section/div[2]/div/h1")).getText();
        Assert.assertEquals("Welcome, "+b+"!", webelem);
        driver.quit();

    }

    @Test ()
    public void GreetingTest2() {
        String email=RandomStringUtils.randomNumeric(15) + "@gmail.com";
        String name="";
        String pass="12345";

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,email,name,pass);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,email,pass);


        String webelem = driver.findElement(By.xpath("/html/body/section/div[2]/div/h1")).getText();
        Assert.assertEquals(webelem,"Welcome!");
        driver.quit();

    }
    @Test ()
    public void NameToUpperCase() {
        String email=RandomStringUtils.randomNumeric(15) + "@gmail.com";
        String name="vanya";
        String pass="12345";

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,email,name,pass);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,email,pass);


        String webelem = driver.findElement(By.xpath("/html/body/section/div[2]/div/h1")).getText();
        Assert.assertEquals(webelem,"Welcome, "+name.substring(0, 1).toUpperCase() +name.substring(1)+"!");
        driver.quit();

    }

    @Test(dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void DoubleEmailRegistration(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,a,b+"1",c+"1");
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");
        driver.quit();
    }

    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void CheckIfWarning(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,a,b+"1",c+"1");
        String webelem = driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div")).getText();
        Assert.assertNotNull(webelem);
        driver.quit();
    }

    @Test  (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void EmailEqualsPass(String a,String b,String c) {



        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Registration(driver,a,a,a);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Auth(driver,a,a);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/profile");
        driver.quit();
    }

    @Test
    public void AccessProfileDenied() {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/profile");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login?next=%2Fprofile");
        driver.quit();


    }

    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void DoubleNameRegistration(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,"1"+a,b,c+"1");
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();
    }
    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void DoublePasswordRegistration(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,"1"+a,b+"1",c);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();
    }

    @Test (dataProvider="EmptyData", dataProviderClass = DataProviders.class)
    public void RegWithEmptyFields(String a, String b, String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");




        driver.quit();

    }
    @Test (dataProvider="EmptyData", dataProviderClass = DataProviders.class)
    public void AuthWithEmptyFields(String a, String b, String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/login");
        Driver.Auth(driver,a,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");

        driver.quit();

    }

    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void UpsideDown(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Auth(driver,c,a);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();
    }

}
