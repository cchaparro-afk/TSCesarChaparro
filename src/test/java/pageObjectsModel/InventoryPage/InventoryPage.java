package pageObjectsModel.InventoryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryPage {

    private final WebDriver driver;

    public InventoryPage(WebDriver driver) {

        this.driver = driver;
    }

    public void inventoryProducts() {

        WebElement products = driver.findElement(By.xpath("//span[ text()='Products']"));
        assertThat(products.isDisplayed()).isTrue();

        WebElement firstProduct = driver.findElement(By.xpath("//button[text()='Add to cart'][1]"));
        firstProduct.click();
    }

    public void inventorySort(){

        List<WebElement> countProducts;
        double tempHigh;
        double tempLower;

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
    }
}
