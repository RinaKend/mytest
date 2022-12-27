package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Classes.Driver;
public class ScenarioTest {
    //Регистрация одного пользователя с разных браузеров
    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void Scen1(String a, String b, String c) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.quit();

        WebDriver driver1 = new ChromeDriver();
        Driver.Registration(driver1,a,b,c);
        Assert.assertEquals(driver1.getCurrentUrl(),"http://localhost:5000/signup");

       driver1.quit();

    }
                //Регистрация с Edge, вход с Chrome
    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void Scen2(String a, String b, String c) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.quit();

        WebDriver driver1 = new ChromeDriver();
        Driver.Auth(driver1,a,c);
        Assert.assertEquals(driver1.getCurrentUrl(),"http://localhost:5000/profile");

        driver1.quit();

    }
    //Авторизация через Edge, тот же пользователь не авторизован в Chrome
    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void Scen3(String a, String b, String c) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,a,c);


        WebDriver driver1 = new ChromeDriver();
        Driver.Auth(driver1,a,c);
        Assert.assertEquals(driver1.getCurrentUrl(),"http://localhost:5000/login?next=%2Fprofile");

        driver1.quit();
        driver.quit();
    }

    //Авторизованный пользователь открывает новое окно браузера, авторизация заново не требуется
    @Test (dataProvider="RandomEmailData", dataProviderClass = DataProviders.class)
    public void Scen4(String a, String b, String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Driver.Registration(driver,a,b,c);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Driver.Auth(driver,a,c);


        WebDriver driver1 = new EdgeDriver();
        Driver.Auth(driver1,a,c);
        Assert.assertEquals(driver1.getCurrentUrl(),"http://localhost:5000/profile");

        driver1.quit();
        driver.quit();
    }

    //Несколько пользователей поочередно регистрируются,авторизуются, выходят без задержек браузера
    @Test(dataProvider="RandomEmailData", dataProviderClass = DataProviders.class,threadPoolSize = 1, invocationCount = 10)
    public void SomeBaseScen(String a, String b, String c) {


        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        Driver.Registration(driver,a,b,c);
        Driver.Auth(driver,a,b);
        driver.findElement(By.xpath("/html/body/section/div[1]/nav/div/div/div/a[3]")).click();
        driver.get("http://localhost:5000/profile");
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:5000/login?next=%2Fprofile");
        driver.quit();
    }

}
