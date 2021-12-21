package Lesson_6.Pages;

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

    public StartPage checkCity() {
        assertThat(cityName.getText()).isEqualTo("Санкт-Петербург");
        return this;
    }

    public CatalogPage selectCategory() {
        catalogBtn.click();
        category.click();
        subCutegory.click();
        return new CatalogPage(webDriver);
    }
}
