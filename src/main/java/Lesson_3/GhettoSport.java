package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GhettoSport {
    public static void main(String[] args) throws InterruptedException {


        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().window().setSize(new Dimension(1900,1000));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get ("https://ghettosport.ru/");

        Actions actions = new Actions (webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//a[contains(.,'Сноуборд')]"))).build().perform();
        webDriver.findElement(By.xpath("//a[contains(.,'Сноуборды')]")).click();

        webDriver.findElement(By.id("rdrf112-opt84-15057")).click(); //id статичные
        webDriver.findElement(By.id("rdrf112-opt96-17570")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Сноуборд Capita 2022 Defenders Of Awesome Wide')]")).click();
        webDriver.findElement(By.id("button-cart")).click();
        webDriver.findElement(By.xpath("//span[contains(.,'Корзина')]")).click();
        webDriver.findElement(By.xpath("//a[normalize-space(.)='Перейти в корзину']")).click();

        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[contains(.,'Сноуборд Capita 2022 Defenders Of Awesome Wide')]"))));


        Thread.sleep(10000);

        webDriver.quit();
    }
}
