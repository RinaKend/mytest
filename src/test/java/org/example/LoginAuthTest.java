package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.apache.commons.lang3.RandomStringUtils;

import Classes.Driver;

public class LoginAuthTest {
    @Test (dataProvider="RealPosLoginData", dataProviderClass = DataProviders.class)
    public void PositiveLogin(String a) {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        Driver.Auth(driver,a,"12345");

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/profile");
        driver.quit();

    }


    @Test
    public void NoRegisterUser() {

            System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

            WebDriver driver = new EdgeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);



            Driver.Auth(driver,RandomStringUtils.randomNumeric(20) + "@gmail.com","12345");
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
            driver.quit();

        }
    @Test
    public void CheckIfWarning() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Auth(driver,RandomStringUtils.randomNumeric(20) + "@gmail.com","12345");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String webelem = driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div")).getText();


        Assert.assertNotNull(webelem);

        driver.quit();

    }

    @Test (dataProvider="RealNegLoginData", dataProviderClass = DataProviders.class)
    public void NegativeLogin(String a) {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Auth(driver,a,"12345");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();

    }
    @Test
    public void ToUpperCase() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        String email="klavsld@gmail.com";
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Registration(driver,email,"the","12345");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,email.substring(0, 1).toUpperCase() +email.substring(1),"12345");
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();

    }

}
