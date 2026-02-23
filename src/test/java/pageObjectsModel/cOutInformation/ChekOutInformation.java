package pageObjectsModel.cOutInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class ChekOutInformation {

    private By firstnameInput = By.id("first-name");
    private By lastnameInput = By.id("last-name");
    private By zipCodeInput = By.id("postal-code");

    private final WebDriver driver;

    public ChekOutInformation(WebDriver driver) {

        this.driver = driver;
    }

    public void checkOutInfo(String firstname, String lastname, String zipcode) {

        driver.findElement(firstnameInput).sendKeys(firstname);
        driver.findElement(lastnameInput).sendKeys(lastname);
        driver.findElement(zipCodeInput).sendKeys(zipcode);

        WebElement continuar = driver.findElement(By.xpath("//input[@id='continue']"));
        continuar.click();

        WebElement finish = driver.findElement(By.xpath("//button[@id='finish']"));
        finish.click();

        WebElement verifyProducts = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
        assertThat(verifyProducts.getText()).isEqualTo("Thank you for your order!");

    }
}
