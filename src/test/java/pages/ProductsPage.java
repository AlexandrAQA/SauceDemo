package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

   WebDriver driver;
   private final By TITLE = By.xpath(".//span[@class='title']");

   public ProductsPage(WebDriver driver) {
      this.driver = driver;
   }

   public WebElement getTitle () {
      return driver.findElement(By.xpath(".//span[@class='title']"));
   }

}
