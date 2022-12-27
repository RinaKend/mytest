package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Classes.Const;

public class BrowserTest {

    //Проверка, что страница открывается в популярных браузерах
    @Test
    public void testEdge() {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(Const.homePage);
        Assert.assertEquals("Flask Auth Example", driver.getTitle());
        driver.quit();




    }

    @Test
    public void testChrome() {


        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(Const.homePage);
        Assert.assertEquals("Flask Auth Example", driver.getTitle());
        //driver.quit();



    }

    @Test
    public void testFirefox() {


        System.setProperty("webdriver.Firefox.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\firefoxdriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(Const.homePage);
        Assert.assertEquals("Flask Auth Example", driver.getTitle());
        driver.quit();



    }


}
