package Lesson_6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SelectCity extends BasicView {

    @FindBy(xpath = "//a[contains(@class, 'button button--modal button--transparent no')]")
    private WebElement anotherCityButton;

    @FindBy(xpath = "//b[contains(text(),'Санкт-Петербург')]")
    private WebElement citySPb;


    public SelectCity(WebDriver webDriver) {
        super(webDriver);
    }

    public StartPage city() {
        anotherCityButton.click();
        citySPb.click();
        return new StartPage(webDriver);

    }
}
