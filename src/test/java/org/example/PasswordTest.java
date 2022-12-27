package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import Classes.Driver;

public class PasswordTest {


    @Test (dataProvider="PosPassData", dataProviderClass = DataProviders.class)
    public void PositivePass( String a ) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("http://localhost:5000/signup");
        Driver.Registration(driver,RandomStringUtils.randomNumeric(20) + "@gmail.com","the",a);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();

        }


   @Test (dataProvider="NegPassData", dataProviderClass = DataProviders.class)
    public void NegativePass(String a) {
       System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
       WebDriver driver = new EdgeDriver();
       driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

       driver.get("http://localhost:5000/signup");
       Driver.Registration(driver,RandomStringUtils.randomNumeric(20) + "@gmail.com","the",a);

       driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");
        driver.quit();

    }

    @Test ()
    public void VeryLongPassword() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        Driver.Registration(driver,RandomStringUtils.randomNumeric(10) + "@gmail.com","the",RandomStringUtils.randomNumeric(50000) + "@gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");

        driver.quit();

    }
}
