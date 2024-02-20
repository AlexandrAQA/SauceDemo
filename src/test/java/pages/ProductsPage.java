package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final By TITLE = By.xpath(".//span[@class='title']");
    private final String addToCartButton =
            ".//div[text()='%s']/ancestor::div[@class='inventory_item']//button";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.get(BASE_URL + "cart.html");
    }
    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    public void addProductToCart(String productName) {
       By fullLocator = By.xpath(String.format(addToCartButton, productName));
       driver.findElement(fullLocator).click();
    }
}
