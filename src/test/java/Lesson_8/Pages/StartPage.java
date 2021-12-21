package Lesson_8.Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.assertj.core.api.Assertions.assertThat;

public class StartPage {

    private SelenideElement cityName = $(By.xpath("//div[contains(@class,'information__title')]"));
    private SelenideElement catalogBtn = $(By.className("catalog-btn"));
    private SelenideElement category = $(By.xpath("//a[contains(text(),'Сноубординг и Newschool')]"));
    private SelenideElement subCutegory = $(By.linkText("Сноуборды"));


    @Step("Проверить корректность выбранного города")
    public StartPage checkCity() {
        assertThat(cityName.getText()).isEqualTo("Санкт-Петербург");
        return this;
    }

    @Step("Нажать кнопку Весь каталог")
    public StartPage clickAllCatalog() {
        catalogBtn.click();
        return this;
    }

    @Step("Выбрать каталог Сноубординг и Newschool")
    public StartPage selectCategory() {
        category.click();
        return this;
    }

    @Step("Выбрать подкаталог Сноуборды")
    public CatalogPage selectSubCategory() {
        subCutegory.click();
        return page(CatalogPage.class);
    }
}
