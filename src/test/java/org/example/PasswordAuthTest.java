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
import Classes.Driver;

public class PasswordAuthTest {


    @Test (dataProvider="PosPassData", dataProviderClass = DataProviders.class)
    public void PositivePassword( String a ) {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        String pass=RandomStringUtils.randomNumeric(20) + "@gmail.com";
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,pass,"the",a);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Auth(driver,pass,a);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/profile");


        driver.quit();

    }

    @Test (dataProvider="NegPassData", dataProviderClass = DataProviders.class)
    public void NegativePassword( String a ) {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        String pass=RandomStringUtils.randomNumeric(20) + "@gmail.com";
        Driver.Registration(driver,pass,"the",a);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Auth(driver,pass,a);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");

        driver.quit();



    }
    @Test (dataProvider="PosPassData", dataProviderClass = DataProviders.class)
    public void WrongPassword( String a ) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String pass=RandomStringUtils.randomNumeric(20) + "@gmail.com";
        Driver.Registration(driver,pass,"the",a);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Auth(driver,pass,a+"1");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");


        driver.quit();


    }
    @Test
    public void ToUpperCase() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        String pass="password";
        String email=RandomStringUtils.randomNumeric(20) + "@gmail.com";;
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Registration(driver,email,"the",pass);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,email ,pass.substring(0, 1).toUpperCase() +pass.substring(1));
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();

    }
}
