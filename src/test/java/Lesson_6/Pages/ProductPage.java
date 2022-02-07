package Lesson_6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.assertj.core.api.Assertions.assertThat;

public class ProductPage extends BasicView{


    @FindBy (xpath = "//label[contains(@for, 'product-size-233091')]")
    private WebElement size;

    @FindBy (xpath = "//a[contains(@class, 'button button--icon product-buttons__button goods_buy')]")
    private WebElement addProduct;

    @FindBy (xpath = "//div[contains(@class,'cart-btn__count')]")
    private WebElement productCart;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

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
    @Step ("Проверить корректоность отображения количества товара в корзине")
    public ProductPage checkCart () {

        assertThat(productCart.getText()).isEqualTo("1");
        return this;
    }
}
