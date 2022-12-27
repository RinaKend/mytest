package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import Classes.Const;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static void RegistrationAndQuit(String email, String name, String pass){
        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        //создание экземпляра драйвера
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        //driver.get("http://localhost:5000/signup");
        driver.get(Const.signupPage);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[1]/div/input")).sendKeys(email);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[2]/div/input")).sendKeys(name);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[3]/div/input")).sendKeys(pass);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();

    }

    public static WebDriver Registration(WebDriver driver,String email, String name, String pass){

        driver.get(Const.signupPage);

        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[1]/div/input")).sendKeys(email);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[2]/div/input")).sendKeys(name);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[3]/div/input")).sendKeys(pass);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;

    }

    public static WebDriver Auth(WebDriver driver, String email, String pass){
        //System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        //создание экземпляра драйвера

        driver.get(Const.loginPage);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[1]/div/input")).sendKeys(email);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/div[2]/div/input")).sendKeys(pass);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/form/button")).click();
        return driver;
}}

