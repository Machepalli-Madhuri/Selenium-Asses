package pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Mavensample.Abstract;

public class AddTOCart extends Abstract {
    private List<String> productPrices = new ArrayList<>();

    public AddTOCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getProductPrices() {
        return productPrices;
    }

    public void addToCart() {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='a-section a-spacing-base']"));
        int productsAdded = 0;

        for (int i = 0; i < products.size() && productsAdded < 2; i++) {
            WebElement product = products.get(i);

            // Get product price
            String price = product.findElement(By.xpath(".//span[@class='a-price-whole']")).getText();
            productPrices.add(price);

            // Wait for the "Add to Cart" button and click
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to')]")));
            addToCartButton.click();
            productsAdded++;
        }
    }
}