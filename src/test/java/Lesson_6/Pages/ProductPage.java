package Lesson_6.Pages;

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
    public ProductPage addToCart () {
        size.click();
        addProduct.click();
        return this;
    }
    public ProductPage checkCart () {

        assertThat(productCart.getText()).isEqualTo("1");
        return this;
    }
}
