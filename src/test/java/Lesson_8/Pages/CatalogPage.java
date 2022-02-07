package Lesson_8.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static org.assertj.core.api.Assertions.assertThat;


public class CatalogPage{


    private SelenideElement priceFrom = $(By.id("filter-price-input-1"));
    private SelenideElement priceTo = $(By.id("filter-price-input-2"));
    private SelenideElement confirmButton = $(By.xpath("//button[contains(@class, 'filter-buttons__button button')]"));



    @Step ("Указать границы цены {priceFromRub} и {priceToRub}")
    public CatalogPage filters(String priceFromRub, String priceToRub) {
        priceFrom.sendKeys(priceFromRub);
        priceTo.sendKeys((Keys.CONTROL + "a"));
        priceTo.sendKeys(priceToRub);
        return this;
    }
    @Step ("Нажать кнопку Показать")
    public CatalogPage confirmFilters() {
        confirmButton.click();
        return this;
    }

    @Step ("Проверить првильность отображения фильтра цены {priceFromRub} и {priceToRub}")
    public CatalogPage checkFilters(String priceFromRub, String priceToRub) {
        assertThat(priceFrom.getAttribute("value"))
                .isEqualTo(priceFromRub);
        assertThat(priceTo.getAttribute("value"))
                .isEqualTo(priceToRub);
        return this;
    }

    @Step ("Выбрать продукт номер 9")
    public ProductPage selectProduct() {
        ElementsCollection products = $$(By.xpath("//a[contains(@class, 'top-item top-item--catalog')]"));
        products.get(9).click();

        return page(ProductPage.class);

    }
}