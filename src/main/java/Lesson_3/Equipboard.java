package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Equipboard {
    public static void main(String[] args) throws InterruptedException {


        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().window().setSize(new Dimension(1900,1000));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get ("https://equipboard.com/");

        webDriver.findElement(By.id("home-search")).sendKeys("Robert Smith \n");
        webDriver.findElement(By.linkText("Robert Smith")).click();
        webDriver.findElement(By.xpath("//a[contains(@href,'/pros/robert-smith?gear=effects-pedals')]")).click();
        webDriver.findElement(By.linkText("Tech 21 SansAmp Classic")).click();
        webDriver.findElement(By.xpath("//img[@alt='Reverb logo']")).click();

        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[contains(.,'Tech 21 SansAmp Classic')]"))));


        Thread.sleep(10000);

        webDriver.quit();
    }
}