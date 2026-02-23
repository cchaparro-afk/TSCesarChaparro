package pageObjectsModel.kartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class YourKart {

    private final WebDriver driver;

    public YourKart(WebDriver driver) {

        this.driver = driver;
    }

    public void kartCheckout() {

        WebElement checkout = driver.findElement(By.xpath("//button[text()='Checkout']"));
        checkout.click();
    }

    public void verifyItem(){

        WebElement verifyProducts = driver.findElement(By.xpath("//div[@class='cart_item'][1]//a"));
        assertThat(verifyProducts.getText()).isEqualTo("Sauce Labs Backpack");
        System.out.println("El item seleccionado es: "+verifyProducts.getText());
    }

}
