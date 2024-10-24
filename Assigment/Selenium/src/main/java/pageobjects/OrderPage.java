package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Mavensample.Abstract;

public class OrderPage extends Abstract {

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify that product prices in the cart match the added ones
    public void verifyProductPricesInCart(List<String> productPrices) {
        driver.findElement(By.id("nav-cart")).click();
        String pageSource = driver.getPageSource();

        for (String price : productPrices) {
            Assert.assertTrue(pageSource.contains(price), "Price not found in cart: " + price);
        }
    }
}