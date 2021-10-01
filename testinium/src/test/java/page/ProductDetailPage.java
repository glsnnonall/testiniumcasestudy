package page;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ProductDetailPage extends BasePage {

    public By productPriceLabel = By.cssSelector("[class='price']");
    public By addToBasketButton = By.id("pd_add_to_cart");
    public By goToBasketButton = By.id("spanCart");
    public By bodySizeLabel = By.cssSelector("[data-tracking-label='BedenSecenekleri']");
    public By sizeLabel = By.cssSelector("[data-tracking-label='BoySecenekleri']");

    public String getProductPrice() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(productPriceLabel);
        return elements.get(1).getText();
    }

    public ProductDetailPage addToBasket() throws InterruptedException {
        click(addToBasketButton);
        return this;

    }

    public ProductDetailPage randomSelectBodySize() throws InterruptedException {
        List<WebElement> sizeLabels = driver.findElements(sizeLabel);
        List<WebElement> bodySizeLabels = driver.findElements(bodySizeLabel);
        Random random = new Random();
        if (sizeLabels.size() > 1) {
            int randomIndex = random.nextInt(sizeLabels.size()) / 2;
            clickWithElement(sizeLabels.get(randomIndex));
        }
        if (bodySizeLabels.size() > 1) {
            int randomIndex = random.nextInt(bodySizeLabels.size()) / 2;
            clickWithElement(bodySizeLabels.get(randomIndex));
        }
        return this;
    }

    public BasketPage goToBasketPage() throws InterruptedException {
        click(goToBasketButton);
        return new BasketPage();
    }
}
