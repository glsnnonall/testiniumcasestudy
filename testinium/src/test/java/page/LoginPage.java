package page;

import config.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public By email = By.id("LoginEmail");
    public By password = By.id("Password");
    public By loginButton = By.id("loginLink");



    public LoginPage loginEmail(String value) throws InterruptedException {
        sendKeys(email, value);
        return this;
    }

    public LoginPage loginPassword(String value) throws InterruptedException {
        sendKeys(password, value);
        return this;
    }

    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage();
    }
}
