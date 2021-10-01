package page;

import config.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage extends BasePage {

    public By productPriceLabel = By.cssSelector("[class='rd-cart-item-price mb-15']");
    public By productCountIncreaseButton = By.cssSelector("[id*='Cart_AddQuantity']");
    public By productCount = By.cssSelector("[class='item-quantity-input ignored']");
    public By productDeleteButton = By.cssSelector("[id*='Cart_ProductDelete']");
    public By productDeleteButtonPopUp = By.cssSelector("[class='modal-content'] [id*='Cart_ProductDelete']");
    public By nullProductText = By.cssSelector("[class='cart-empty-title']");

    public String getProductPrice() throws InterruptedException {
        Thread.sleep(1000);
        return getText(productPriceLabel);
    }

    public BasketPage productCountIncrease() throws InterruptedException {
        click(productCountIncreaseButton);
        return this;
    }

    public String getProductCount() {
        List<WebElement> elementList = driver.findElements(productCount);
        return elementList.get(0).getAttribute("value");
    }

    public BasketPage deleteProductWithIndex(int index) throws InterruptedException {
        List<WebElement> deleteProductButtons = driver.findElements(productDeleteButton);
        clickWithElement(deleteProductButtons.get(index));
        Thread.sleep(3000);
        click(productDeleteButtonPopUp);
        return this;
    }

    public BasketPage controlNullProduct() throws InterruptedException {
        Thread.sleep(3000);
        String text = getText(nullProductText);
        Assert.assertEquals(text, "Sepetinizde ürün bulunmamaktadır.");
        return this;
    }
}
