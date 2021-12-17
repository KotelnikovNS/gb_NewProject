package Lesson_5;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

    public class sliderGhettoSportTest extends BasicTest {

        @SneakyThrows
        @Test
        void dragAndDropPriceFilterTest() throws InterruptedException {
            webDriver.get("https://ghettosport.ru/snoubord/splitbordy?rdrf[price]=16000;105290");


            assertThat(webDriver.findElement(By.xpath("//button[contains(@class, 'btn btn-default btn-xs')]")).getText())
                    .isEqualTo("ЦЕНА: 16000 — 105290₽×");


            WebElement sliderFrom = webDriver.findElement(By.xpath("//span[contains(@class, 'irs-handle from')]"));
            WebElement sliderTo = webDriver.findElement(By.xpath("//span[contains(@class, 'irs-handle to')]"));
            Actions move = new Actions(webDriver);
            Action actionLower = (Action) move.dragAndDropBy(sliderFrom, 70, 0).build();  // length 263.75px
            Action actionUpper = (Action) move.dragAndDropBy(sliderTo, -70, 0).build();
            actionLower.perform();
            actionUpper.perform();

            Thread.sleep(5000);

            Thread.sleep(5000);

            assertThat(webDriver.findElement(By.xpath("//button[contains(@class, 'btn btn-default btn-xs')]")).getText())
                    .isEqualTo("ЦЕНА: 39698 — 81592₽×");

        }
    }
