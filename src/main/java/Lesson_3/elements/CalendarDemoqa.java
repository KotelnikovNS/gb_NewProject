package Lesson_3.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class CalendarDemoqa implements WrapsElement {
    private WebElement webElement;


        @Override
        public WebElement getWrappedElement() {
            return null;
        }


        public CalendarDemoqa(WebDriver webDriver) {
            this.webElement= webDriver.findElement(By.className("react-datepicker__month-container"));
        }

        public void selectDate(LocalDate localDate) {
            new Select(webElement.findElement(By.className("react-datepicker__month-select"))).selectByVisibleText(String.valueOf(localDate.getMonthValue() - 1));
            new Select(webElement.findElement(By.className("react-datepicker__year-select"))).selectByVisibleText(String.valueOf(localDate.getYear()));
            new Select(webElement.findElement(By.className("react-datepicker__month"))).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        }
    }
