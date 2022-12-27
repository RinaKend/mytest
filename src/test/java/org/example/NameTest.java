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
import org.apache.commons.lang3.RandomStringUtils;
public class NameTest {

    @Test (dataProvider="NameData", dataProviderClass = DataProviders.class)
    public void AllNameTest( String a ) {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,RandomStringUtils.randomNumeric(20) + "@gmail.com",a,"123");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");
        driver.quit();
}

    @Test ()
    public void VeryLongName() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        Driver.Registration(driver,RandomStringUtils.randomNumeric(10) + "@gmail.com",RandomStringUtils.randomNumeric(50000) + "@gmail.com","12345");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");

        driver.quit();

    }
}
