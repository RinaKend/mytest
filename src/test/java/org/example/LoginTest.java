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
import Classes.Driver;
import org.apache.commons.lang3.RandomStringUtils;
public class LoginTest {



    @Test (dataProvider="PosLoginData", dataProviderClass = DataProviders.class)
    public void PositiveLogin(String a) {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        Driver.Registration(driver,a,"the","12345");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");

        driver.quit();

    }

    @Test (dataProvider="NegLoginData", dataProviderClass = DataProviders.class)
    public void NegativeLogin(String a) {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        Driver.Registration(driver,a,"the","12345");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");

        driver.quit();

    }
    @Test ()
    public void VeryLongLogin() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        Driver.Registration(driver,RandomStringUtils.randomNumeric(50000) + "@gmail.com","the","12345");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/signup");

        driver.quit();

    }
    @Test ()
    public void ToUpCase() {

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        String email="hgtgtgtgt@gmail.com";
        Driver.Registration(driver,email,"the","12345");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Registration(driver,email.substring(0, 1).toUpperCase() +email.substring(1),"the","12345");
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login");

        driver.quit();

    }
}






