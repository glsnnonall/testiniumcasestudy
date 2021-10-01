package testCase;


import config.BasePage;
import config.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.BasketPage;
import page.HomePage;
import page.ProductDetailPage;

public class OrnekTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    BasketPage basketPage = new BasketPage();

    @Test
    public void basketCase() throws InterruptedException {
        homePage.clickLoginButton()
                .loginEmail("glsnnonall@gmail.com")
                .loginPassword("Gulsunonal02")
                .clickLoginButton()
                .controlLoginSuccessfully(true)
                .searchText("pantolon")
                .scrollAndClickSeenMoreSeen()
                .randomProductAddToBasket();
        String productPrice = productDetailPage.getProductPrice();

        productDetailPage.randomSelectBodySize()
                .addToBasket()
                .goToBasketPage();
        String basketProductPrice = basketPage.getProductPrice();
        Assert.assertEquals(productPrice, basketProductPrice);
        basketPage.productCountIncrease();
        Thread.sleep(3000);
        String productCount = basketPage.getProductCount();
        Assert.assertEquals(productCount, "2");
        basketPage.deleteProductWithIndex(0)
                .controlNullProduct() ;
    }

}
