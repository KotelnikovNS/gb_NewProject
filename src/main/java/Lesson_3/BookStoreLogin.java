package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BookStoreLogin {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().window().setSize(new Dimension(1900, 1000));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://demoqa.com/");

        webDriver.findElement(By.xpath("//*[normalize-space(.)='Book Store Application']")).click();
        webDriver.findElement(By.id("login")).click();
        webDriver.findElement(By.id("newUser")).click();

        webDriver.findElement(By.id("firstname")).sendKeys("Gordon");
        webDriver.findElement(By.id("lastname")).sendKeys("Freeman");
        webDriver.findElement(By.id("userName")).sendKeys("G-Man");
        webDriver.findElement(By.id("password")).sendKeys("*City17*");

        webDriver.findElement(By.id("g-recaptcha")).click();
        webDriver.findElement(By.id("register")).click();
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[contains(.,'User Register Successfully."))));

//        Если капчу не обойти
//        webDriver.findElement(By.id("register")).click();
//        new WebDriverWait(webDriver, 5)
//                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[contains(.,'Please verify reCaptcha to register!')]"))));
//

        Thread.sleep(10000);

        webDriver.quit();
    }
}
