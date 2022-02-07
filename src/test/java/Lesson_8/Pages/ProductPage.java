package Lesson_8.Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductPage {


    private SelenideElement size = $(By.xpath("//label[contains(@for, 'product-size-233091')]"));
    private SelenideElement addProduct = $(By.xpath("//a[contains(@class, 'button button--icon product-buttons__button goods_buy')]"));
    private SelenideElement productCart = $(By.xpath("//div[contains(@class,'cart-btn__count')]"));



    @Step ("Выбрать размер продукта 166")
    public ProductPage selectSizeOfProduct () {
        size.click();
        return this;
    }
    @Step ("Нажать кнопку В корзину")
        public ProductPage addToCart () {
        addProduct.click();
        return this;
    }
    @Step ("Проверить правильность отображения количества товара в корзине")
    public ProductPage checkCart () {

        assertThat(productCart.getText()).isEqualTo("1");
        return this;
    }
}
