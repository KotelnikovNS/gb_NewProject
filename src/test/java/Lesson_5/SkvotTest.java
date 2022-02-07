package Lesson_5;


import org.junit.jupiter.api.Test;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SkvotTest extends BasicTest {

    @SneakyThrows
    @Test
    void dragAndDropPriceFilterTest() throws InterruptedException {
        webDriver.get("https://www.skvot.com/catalog/snowboarding-and-newschool/snowboards;price:0-142000");

        webDriver.findElement(By.xpath("//a[contains(@class, 'button button--modal button--transparent no')]")).click();
        webDriver.findElement(By.xpath("//b[contains(text(),'Санкт-Петербург')]")).click();
        assertThat(webDriver.findElement(By.xpath("//div[contains(@class,'information__title')]")).getText())
                .isEqualTo("Санкт-Петербург");

        assertThat(webDriver.findElement(By.id("filter-price-input-1")).getAttribute("value"))
                .isEqualTo("0");
        assertThat(webDriver.findElement(By.id("filter-price-input-2")).getAttribute("Value"))
                .isEqualTo("142000");

        WebElement sliderLower = webDriver.findElement(By.xpath("//div[contains(@class, 'noUi-handle noUi-handle-lower')]"));
        WebElement sliderUpper = webDriver.findElement(By.xpath("//div[contains(@class, 'noUi-handle noUi-handle-upper')]"));
        Actions move = new Actions(webDriver);
        Action actionLower = (Action) move.dragAndDropBy(sliderLower, 70, 0).build();  // length 236.25px
        Action actionUpper = (Action) move.dragAndDropBy(sliderUpper, -70, 0).build();
        actionLower.perform();
        actionUpper.perform();

        Thread.sleep(5000);

        assertThat(webDriver.findElement(By.id("filter-price-input-1")).getAttribute("value"))
                .isEqualTo("42074");
        assertThat(webDriver.findElement(By.id("filter-price-input-2")).getAttribute("value"))
                .isEqualTo("99926");

        webDriver.findElement(By.xpath("//button[contains(@class, 'filter-buttons__button button')]")).click();

        Actions action = new Actions(webDriver);

        action.moveToElement(webDriver.findElement(By.xpath("//div[contains(.,'Frontier (21-22)')]")))
                .pause(Duration.ofSeconds(1))
                .moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'top-item__view button')]")))
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(Keys.ESCAPE)
                .build()
                .perform();

        assertThat(webDriver.findElement(By.xpath("//div[contains(@class,'cart-btn__count')]")).getText())
                .isEqualTo("0");

        webDriver.findElement(By.xpath("//div[contains(.,'Frontier (21-22)')]")).click();
        webDriver.findElement(By.xpath("//label[contains(@for, 'product-size-247048')]")).click();
        webDriver.findElement(By.xpath("//a[contains(@class, 'button button--icon product-buttons__button goods_buy')]")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'cart-btn__count')]")));

        assertThat(webDriver.findElement(By.xpath("//div[contains(@class,'cart-btn__count')]")).getText())
                .isEqualTo("1");

    }
}

