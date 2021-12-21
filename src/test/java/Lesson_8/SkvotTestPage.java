package Lesson_8;


import Lesson_8.extention.ConfigExtension;
import Lesson_8.Pages.SelectCity;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import static com.codeborne.selenide.Selenide.page;

@ExtendWith(ConfigExtension.class)

public class SkvotTestPage {

    private final String priceFromRub = "59999";
    private final String priceToRub = "109999";


    @Test
    @DisplayName("City selection check")
    @Severity (SeverityLevel.NORMAL)
     void selectCityTest() {
        Selenide.open("https://www.skvot.com/");
        page(SelectCity.class)
                .anotherCity()
                .city()
                .checkCity();
    }

    @Test
    @DisplayName("Сhecking the filters")
    @Severity (SeverityLevel.CRITICAL)
    void productFiltersTest() {
        Selenide.open("https://www.skvot.com/");

        page(SelectCity.class)
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
        Selenide.open("https://www.skvot.com/");
        page(SelectCity.class)
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


