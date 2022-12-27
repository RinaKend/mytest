package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Classes.Const;

public class PageTest {

    @Test
    public void CSSElements() {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(Const.homePage);


        String colour=driver.findElement(By.xpath("//html/body")).getCssValue("color");
        String FontSize=driver.findElement(By.xpath("//html/body")).getCssValue("font-size");
        String FontWeight=driver.findElement(By.xpath("//html/body")).getCssValue("font-weight");
        String FontFamily=driver.findElement(By.xpath("//html/body")).getCssValue("font-family");

        System.out.println("Colour: "+colour);
        System.out.println("FontSize: "+FontSize);
        System.out.println("FontWeight: "+FontWeight);
        System.out.println("FontFamily: "+FontFamily);

    }

    @Test
    public void LinkBroken() {

        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;

        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(Const.homePage);
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

            url = it.next().getAttribute("href");



            if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if(!url.startsWith(Const.homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        driver.quit();

    }
}
