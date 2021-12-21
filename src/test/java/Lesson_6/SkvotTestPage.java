package Lesson_6;


import Lesson_5.BasicTest;
import Lesson_6.Pages.SelectCity;
import org.junit.jupiter.api.Test;


public class SkvotTestPage extends BasicTest {

    private final String priceFromRub = "59999";
    private final String priceToRub = "109999";

    @Test
    void selectCityTest() throws InterruptedException {
        webDriver.get("https://www.skvot.com/");

        new SelectCity(webDriver)
                .city()
                .checkCity();
    }

    @Test
    void productFiltersTest() {
        webDriver.get("https://www.skvot.com/");

        new SelectCity(webDriver)
                .city()
                .selectCategory()
                .filters(priceFromRub, priceToRub)
                .confirmFilters()
                .checkFilters(priceFromRub, priceToRub);
    }

    @Test
    void productCartTest() {
        webDriver.get("https://www.skvot.com/");
        new SelectCity(webDriver)
                .city()
                .selectCategory()
                .filters(priceFromRub, priceToRub)
                .confirmFilters()
                .checkFilters(priceFromRub, priceToRub)
                .selectProduct()
                .addToCart()
                .checkCart();



    }
}


