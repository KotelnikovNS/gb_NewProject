package Lesson_6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.assertj.core.api.Assertions.assertThat;

public class StartPage extends BasicView {


    @FindBy(xpath = "//div[contains(@class,'information__title')]")
    private WebElement cityName;

    @FindBy(className = "catalog-btn")
    private WebElement catalogBtn;

    @FindBy(xpath = "//a[contains(text(),'Сноубординг и Newschool')]")
    private WebElement category;

    @FindBy(linkText = "Сноуборды")
    private WebElement subCutegory;


    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

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
        return new CatalogPage(webDriver);
    }
}
