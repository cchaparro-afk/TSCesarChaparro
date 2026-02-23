package pageObjectsModel.Navigate;

import org.openqa.selenium.WebDriver;

public class NaviTest {

    private WebDriver driver;

    public NaviTest(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        this.driver.get("https://www.saucedemo.com/");
    }
}