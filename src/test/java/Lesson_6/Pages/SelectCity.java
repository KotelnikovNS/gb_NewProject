package Lesson_6.Pages;

import io.qameta.allure.Step;
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

    @Step("Нажать кнопку Нет, выбрать другой город, выбрать 'Санкт-Петербург'")
    public SelectCity anotherCity() {
        anotherCityButton.click();
        return this;
    }

    @Step ("Проверить корректоность отображения количества товара в корзине")
    public StartPage city() {
        citySPb.click();
        return new StartPage(webDriver);

    }
}
