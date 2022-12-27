package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import Classes.Driver;

public class LogoutTest {
    @Test(dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void LogoutAfterPage(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,a,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/section/div[1]/nav/div/div/div/a[3]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/");
        driver.quit();
    }
    @Test(dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void Logout(String a,String b,String c) {



        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Driver.Registration(driver,a,b,c);

        Driver.Auth(driver,a,c);


        driver.findElement(By.xpath("/html/body/section/div[1]/nav/div/div/div/a[3]")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/profile");
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login?next=%2Fprofile");
        driver.quit();
    }
    @Test(dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void LogoutLittlePage(String a,String b,String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,a,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/section/div[1]/nav/div/div/div/a[3]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/");
        driver.quit();
    }

}
