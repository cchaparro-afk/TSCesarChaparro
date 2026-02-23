package pageObjectsModel.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private By usernameImput = By.id("user-name");
    private By passwordImput = By.id("password");
    private By loginButton = By.id("login-button");

    private final WebDriver driver;

    public LoginTest(WebDriver driver) {

        this.driver = driver;
    }

    public void login(String username, String password) {

        driver.findElement(usernameImput).sendKeys(username);
        driver.findElement(passwordImput).sendKeys(password);
        driver.findElement(loginButton).click();
    }


}
