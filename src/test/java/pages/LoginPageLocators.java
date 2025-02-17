package pages;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By emailField = By.xpath("//input[@name='email']");
    public static final By passwordField = By.xpath("//input[@name='password']");
    public static final By loginButton = By.xpath("//button[@type='submit']");
    public static final By errorMessage = By.xpath("//div[contains(text(),'Your email and/or password are incorrect')]");
}