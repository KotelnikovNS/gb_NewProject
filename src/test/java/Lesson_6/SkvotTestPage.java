package Lesson_6;


import Lesson_5.BasicTest;
import Lesson_6.Pages.SelectCity;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SkvotTestPage extends BasicTest {

    private final String priceFromRub = "59999";
    private final String priceToRub = "109999";

    @Test
    @DisplayName("City selection check")
    @Severity (SeverityLevel.NORMAL)
     void selectCityTest() {
        webDriver.get("https://www.skvot.com/");

        new SelectCity(webDriver)
                .anotherCity()
                .city()
                .checkCity();
    }

    @Test
    @DisplayName("Сhecking the filters")
    @Severity (SeverityLevel.CRITICAL)
    void productFiltersTest() {
        webDriver.get("https://www.skvot.com/");

        new SelectCity(webDriver)
                .anotherCity()
                .city()
                .clickAllCatalog()
                .selectCategory()
                .selectSubCategory()
                .filters(priceFromRub, priceToRub)
                .confirmFilters()
                .checkFilters(priceFromRub, priceToRub);
    }

    @Test
    @Flaky
    @DisplayName("Сhecking the cart")
    @Severity (SeverityLevel.BLOCKER)
    void productCartTest() {
        webDriver.get("https://www.skvot.com/");
        new SelectCity(webDriver)
                .anotherCity()
                .city()
                .clickAllCatalog()
                .selectCategory()
                .selectSubCategory()
                .filters(priceFromRub, priceToRub)
                .confirmFilters()
                .selectProduct()
                .selectSizeOfProduct()
                .addToCart()
                .checkCart();

    }
}


