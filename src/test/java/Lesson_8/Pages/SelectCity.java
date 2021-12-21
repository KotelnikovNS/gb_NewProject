package Lesson_8.Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class SelectCity {

    private SelenideElement anotherCityButton = $(By.xpath("//a[contains(@class, 'button button--modal button--transparent no')]"));
    private SelenideElement citySPb = $(By.xpath("//b[contains(text(),'Санкт-Петербург')]"));



    @Step("Нажать кнопку Нет, выбрать другой город, выбрать 'Санкт-Петербург'")
    public SelectCity anotherCity() {
        anotherCityButton.click();
        return this;
    }

    @Step ("Выбрать город Санкт-Петербург")
    public StartPage city() {
        citySPb.click();
        return page(StartPage.class);

    }
}
