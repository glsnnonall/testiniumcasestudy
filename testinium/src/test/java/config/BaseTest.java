package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        BasePage.driver = this.driver;
        BasePage.openWebSite();
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
