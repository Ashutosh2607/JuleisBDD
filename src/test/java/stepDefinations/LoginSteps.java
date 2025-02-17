package stepDefinations;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
    	WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximizes the browser window
        driver = new ChromeDriver(options);

        driver.get(ConfigReader.getProperty("baseURL"));
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("{string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        if (message.equalsIgnoreCase("redirected to dashboard")) {
            wait.until(ExpectedConditions.urlContains("purchases"));
            assertTrue(driver.getCurrentUrl().contains("purchases"));
        } else if (message.equalsIgnoreCase("Your email and/or password are incorrect")) {
        	wait.until(ExpectedConditions.alertIsPresent());
            assertTrue(loginPage.isErrorMessageDisplayed());
        } else if (message.equalsIgnoreCase("Required")) {
            assertTrue(loginPage.isErrorMessageDisplayed());
        }
        driver.quit();
    }
}
