package Lesson_3;

import Lesson_3.elements.CalendarDemoqa;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class StudentRegistrationForm {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().window().setSize(new Dimension(1900, 1000));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://demoqa.com/");

        webDriver.findElement(By.xpath("//*[normalize-space(.)='Forms']")).click();
        webDriver.findElement(By.xpath("//*[normalize-space(.)='Practice Form']")).click();

        webDriver.findElement(By.id("firstName")).sendKeys("Gordon");
        webDriver.findElement(By.id("lastName")).sendKeys("Freeman");
        webDriver.findElement(By.id("userEmail")).sendKeys("vortigaunts-lover@hev.com");
        webDriver.findElement(By.xpath("//*[normalize-space(.)='Male']")).click();
        webDriver.findElement(By.id("userNumber")).sendKeys("2222222222");

//        webDriver.findElement(By.id("dateOfBirthInput")).click();
//        new CalendarDemoqa(webDriver).selectDate(LocalDate.of(1971, 11, 15));

        webDriver.findElement(By.id("dateOfBirthInput")).click();
        webDriver.findElement(By.id("dateOfBirthInput")).sendKeys((Keys.CONTROL + "a"));
        webDriver.findElement(By.id("dateOfBirthInput")).sendKeys("15 Nov 1971\n");


        webDriver.findElement(By.cssSelector("input#subjectsInput")).sendKeys("Physics");
        webDriver.findElement(By.cssSelector("div.subjects-auto-complete__menu")).click();

        webDriver.findElement(By.xpath("//*[normalize-space(.)='Sports']")).click();
        webDriver.findElement(By.id("currentAddress")).sendKeys("none of your business, stupid combine");

        WebDriverWait WaitState = new WebDriverWait(webDriver, 3);
        WaitState.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("react-select-3-input")))).sendKeys("Haryana\n");

        WebDriverWait WaitCity = new WebDriverWait(webDriver, 3);
        WaitCity.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("react-select-4-input")))).sendKeys("Panipat\n");

       WebElement submitBtn = webDriver.findElement(By.id("submit"));
       ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);",submitBtn);
       webDriver.findElement(By.id("submit")).click();

//       WebElement submitBtn = webDriver.findElement(By.id("submit"));
//       Actions actions = new Actions(webDriver);
//       actions.moveToElement(submitBtn);
//       actions.perform();
       // webDriver.findElement(By.id("userForm")).sendKeys((Keys.PAGE_DOWN));

        WebElement title = webDriver.findElement(By.id("example-modal-sizes-title-lg"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);",title);
        webDriver.findElement(By.xpath("//*[contains(.,'Thanks for submitting the form')]"));



        Thread.sleep(10000);

        webDriver.quit();

    }
}
