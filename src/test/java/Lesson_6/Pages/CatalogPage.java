package Lesson_6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CatalogPage extends BasicView {
    @FindBy(id = "filter-price-input-1")
    private WebElement priceFrom;

    @FindBy(id = "filter-price-input-2")
    private WebElement priceTo;

    @FindBy(xpath = "//button[contains(@class, 'filter-buttons__button button')]")
    private WebElement confirmButton;


    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

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
        List<WebElement> products = webDriver.findElements(By.xpath("//a[contains(@class, 'top-item top-item--catalog')]"));
        new Actions(webDriver).moveToElement(products.get(9))
                .click()
                .build()
                .perform();

        return new ProductPage(webDriver);

    }
}