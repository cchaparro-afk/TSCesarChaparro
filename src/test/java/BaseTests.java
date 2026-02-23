import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjectsModel.Navigate.NaviTest;
import pageObjectsModel.loginPage.LoginTest;

import java.text.DecimalFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.BIG_DECIMAL;

public class BaseTests extends BaseWebT {

    @Test //Script de Prueba #1: Agregar item al carrito
    public void gLoginTest() {

        String username = "standard_user";
        String password = "secret_sauce";

        NaviTest naviTest = new NaviTest(driver);
        naviTest.navigateToLoginPage();

        LoginTest loginTest = new LoginTest(driver);
        loginTest.login(username, password);

        WebElement products = driver.findElement(By.xpath("//span[ text()='Products']"));
        assertThat(products.isDisplayed()).isTrue();

        WebElement firstProduct = driver.findElement(By.xpath("//button[text()='Add to cart'][1]"));
        firstProduct.click();

        WebElement kart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        kart.click();

        WebElement verifyProducts = driver.findElement(By.xpath("//div[@class='cart_item'][1]//a"));
        assertThat(verifyProducts.getText()).isEqualTo("Sauce Labs Backpack");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test //Script de Prueba #2: Validación de Login Inválido
    public void gLoginTest2() {

        String username = "locked_out_user";
        String password = "secret_sauce";

        NaviTest naviTest = new NaviTest(driver);
        naviTest.navigateToLoginPage();

        LoginTest loginTest = new LoginTest(driver);
        loginTest.login(username, password);

        WebElement verifyProducts = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));
        assertThat(verifyProducts.getText()).isEqualTo("Epic sadface: Sorry, this user has been locked out.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test //Script de Prueba #3: Ordenamiento de Productos
    public void gLoginTest3() {

        String username = "standard_user";
        String password = "secret_sauce";
        List<WebElement> countProducts;
        double tempHigh;
        double tempLower;

        NaviTest naviTest = new NaviTest(driver);
        naviTest.navigateToLoginPage();

        LoginTest loginTest = new LoginTest(driver);
        loginTest.login(username, password);

        Select selectSort = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectSort.selectByVisibleText("Price (high to low)");

        countProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        WebElement highPrice = driver.findElement(By.xpath("//div[@class='inventory_item'][1]//div[@class='inventory_item_price']"));
        WebElement lowerPrice = driver.findElement(By.xpath("//div[@class='inventory_item']["+countProducts.stream().count()+"]//div[@class='inventory_item_price']"));

        tempHigh = Double.parseDouble((highPrice.getText().replace("$","")));
        tempLower = Double.parseDouble((lowerPrice.getText().replace("$","")));

        assertThat(tempHigh).isGreaterThan(tempLower);

        System.out.println("Mayor precio es: "+tempHigh);
        System.out.println("Menor precio es: "+tempLower);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
