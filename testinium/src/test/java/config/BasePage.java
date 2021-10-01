package config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void openWebSite() {
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        wait = new WebDriverWait(driver, 10);
    }

    public void click(By by) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        moveToElement(by);
        driver.findElement(by).click();
    }

    public void clickWithElement(WebElement webElement) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        scrollWithElement(webElement);
        webElement.click();
    }

    public void sendKeys(By by, String value) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        driver.findElement(by).sendKeys(value);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void scrollWithElement(By by) throws InterruptedException {
        WebElement element = driver.findElement(by);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
        Thread.sleep(500);
    }

    public void scrollWithElement(WebElement element) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
        Thread.sleep(500);
    }

    public void moveToElement(By by) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        WebElement element = driver.findElement(by);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    public void moveToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }
}
