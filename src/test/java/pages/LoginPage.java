package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(LoginPageLocators.emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginPageLocators.passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LoginPageLocators.loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(LoginPageLocators.errorMessage).isDisplayed();
    }
}
