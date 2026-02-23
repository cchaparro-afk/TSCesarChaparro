package pageObjectsModel.Navigate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NaviTest {

    private WebDriver driver;

    public NaviTest(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        this.driver.get("https://www.saucedemo.com/");
    }

    public void navigateToKartPage() {
        WebElement kart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        kart.click();
    }
}