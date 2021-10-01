package page;

import config.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    public By loginButton = By.cssSelector("[class='header-profile-icon']");
    public By account = By.cssSelector("[id='header-login-section'] [class='header-icon-label']");
    public By search = By.id("search");
    public By searchButton = By.cssSelector("[class='search-button active']");
    public By moreSeen = By.cssSelector("[class='lazy-load-button']");
    public By productLabel = By.cssSelector("[data-tracking-label='Ürünüİncele']");

    public LoginPage clickLoginButton() throws InterruptedException {
        click(loginButton);
        return new LoginPage();
    }

    public HomePage controlLoginSuccessfully(boolean flag) {
        String accountName = getText(account);
        if (flag == true) {
            Assert.assertEquals(accountName, "Hesabım");
        } else {
            Assert.assertNotEquals(accountName, "Hesabım");
        }
        return this;
    }

    public HomePage searchText(String value) throws InterruptedException {
        sendKeys(search,value);
        click(searchButton);
        return this;
    }

    public HomePage scrollAndClickSeenMoreSeen() throws InterruptedException {
        Thread.sleep(3000);
        scrollWithElement(moreSeen);
        click(moreSeen);
        return this;
    }

    public ProductDetailPage randomProductAddToBasket() throws InterruptedException {
        List<WebElement> productLabels = driver.findElements(productLabel);
        Random rn = new Random();
        int randomIndex = rn.nextInt(productLabels.size())-1;
        clickWithElement(productLabels.get(randomIndex));
        return new ProductDetailPage();
    }
}
