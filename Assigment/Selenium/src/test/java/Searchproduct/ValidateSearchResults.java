package Searchproduct;


import org.testng.annotations.Test;

import TestCases.BaseTest;
import pageobjects.AddTOCart;
import pageobjects.OrderPage;

public class ValidateSearchResults extends BaseTest {

    @Test
    public void testAddProductsToCart() throws InterruptedException {
        // Create page object instances
        AddTOCart addToCart = new AddTOCart(driver);
        OrderPage orderPage = new OrderPage(driver);

        // Navigate to Amazon and search for products
        driver.get("https://www.amazon.com/");
        
        // Add products to cart
        addToCart.addToCart();

        // Verify the added product prices on the cart page
        orderPage.verifyProductPricesInCart(addToCart.getProductPrices());
    }
}
