import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsModel.InventoryPage.InventoryPage;
import pageObjectsModel.Navigate.NaviTest;
import pageObjectsModel.cOutInformation.ChekOutInformation;
import pageObjectsModel.kartPage.YourKart;
import pageObjectsModel.loginPage.LoginTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTests extends BaseWebT {

    @Test //Script de Prueba #1: Agregar item al carrito
    public void gLoginTest() {

        String username = "standard_user";
        String password = "secret_sauce";

        NaviTest naviTest = new NaviTest(driver);
        naviTest.navigateToLoginPage();

        LoginTest loginTest = new LoginTest(driver);
        loginTest.login(username, password);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.inventoryProducts();

        NaviTest naviKart = new NaviTest(driver);
        naviKart.navigateToKartPage();

        YourKart verifyKart = new YourKart(driver);
        verifyKart.verifyItem();

        try {
            Thread.sleep(2000);
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test //Script de Prueba #3: Ordenamiento de Productos
    public void gLoginTest3() {

        String username = "standard_user";
        String password = "secret_sauce";

        NaviTest naviTest = new NaviTest(driver);
        naviTest.navigateToLoginPage();

        LoginTest loginTest = new LoginTest(driver);
        loginTest.login(username, password);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.inventorySort();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test //Script de Prueba #4: Flujo Completo de Compra (End-to-End)
    public void gLoginTest4() {

        String username = "standard_user";
        String password = "secret_sauce";
        String firstName = "Susan";
        String lastName = "Badilla";
        String zipCode = "30021546";

        NaviTest naviLogin = new NaviTest(driver);
        naviLogin.navigateToLoginPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        LoginTest loginTest = new LoginTest(driver);
        loginTest.login(username, password);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.inventoryProducts();

        NaviTest naviKart = new NaviTest(driver);
        naviKart.navigateToKartPage();

        YourKart kartChkout = new YourKart(driver);
        kartChkout.kartCheckout();

        ChekOutInformation chkinfo = new ChekOutInformation(driver);
        chkinfo.checkOutInfo(firstName,lastName,zipCode);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
