package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    String removeButton = ".//div[text()='%s']//ancestor::div[@class='cart_item']//button[text()='Remove']";
    By productItemInCart = By.xpath(".//div[@class='inventory_item_name']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void removeProductFromCart(String productName) {
        By fullLocator = By.xpath(String.format(removeButton, productName));
        driver.findElement(fullLocator).click();
    }

    public List<WebElement> getAllProductsItemInCart() {
        return driver.findElements(productItemInCart);
    }
}
