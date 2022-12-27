package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import Classes.Driver;

public class RememberMeTest {

    @Test(dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void CheckBoxIn(String a,String b,String c) {





        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("http://localhost:5000/login");
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[1]/div/input")).sendKeys(a);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[2]/div/input")).sendKeys(c);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[3]/label/input")).click();
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/button")).click();
        driver.quit();

        WebDriver driver1 = new EdgeDriver();
        driver1.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver1.get("http://localhost:5000/profile");
        driver1.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver1.getCurrentUrl(),"http://localhost:5000/profile");
        driver1.quit();
    }


    @Test(dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void CheckBoxOut(String a,String b,String c) {




        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("http://localhost:5000/login");
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[1]/div/input")).sendKeys(a);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[2]/div/input")).sendKeys(c);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/button")).click();
        driver.quit();

        WebDriver driver1 = new EdgeDriver();
        driver1.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver1.get("http://localhost:5000/profile");
        driver1.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(driver1.getCurrentUrl(),"http://localhost:5000/login?next=%2Fprofile");
        driver1.quit();
    }


}
