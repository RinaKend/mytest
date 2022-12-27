package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import Classes.Driver;

public class NumberAttemptsTest {

    @BeforeTest()
    private void beforeClass() {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,"33ff6nf6zdffdkk89989@yand","the","1");
        driver.quit();

    }
    @Test (dataProvider="PassData", dataProviderClass = DataProviders.class)
    public void NumberAttempts( String a) {

        WebDriver driver = new EdgeDriver();
        Driver.Auth(driver,"33ff6nf6zdffdkk89989@yand",a);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertFalse(driver.getCurrentUrl().equals("http://localhost:5000/profile"));
        driver.quit();
    }
    }
