package com.kevinnam.fitnesse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonFixture {

    // Variables
    private WebDriver driver;
    private String goToUrl;
    private String productName;

    private final String PATH_TO_CHROME_DRIVER = "/Users/knam/Downloads/chromedriver";
    private final String PRODUCT_URL = "https://www.amazon.ca/Monoprice-115365-Select-Mini-Printer/dp/B01FL49VZE/ref=sr_1_1?ie=UTF8&qid=1488132110&sr=8-1&keywords=3d+printer";
    private final String DELETE_BTN_NAME = "submit.delete.C3NLW69582M4B4";
    private final String CART_URL = "https://www.amazon.ca/gp/cart/view.html/ref=nav_cart";
    private final String ADD_TO_CART_BTN = "add-to-cart-button";
    private final String ACTIVE_CART = "sc-active-cart";
    private final String CHECKOUT_BTN = "sc-proceed-to-checkout";


    public boolean addProductToCart() {
        // If add to cart button exists, click on it and return true
        try {
            System.out.println("Attempting to find Add to cart button... ");
            WebElement btn = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(By.id(ADD_TO_CART_BTN)));
            System.out.print("Found!\n");
            btn.click();
            System.out.println("Clicking add to cart button");
            return true;
        } catch (Exception e) {
            System.out.println("No add to cart button present");
            return false;
        }
    }

    public boolean addProductToCartTwice() {
        // Go to the product url page and add it twice, returns true if successful
        goTo(PRODUCT_URL);
        addProductToCart();
        goTo(PRODUCT_URL);
        return addProductToCart();
    }

    public boolean quantityIsTwo() {
        // Attempt to find quantity, if 2 then return true
        System.out.println("Attempting to find quantity... ");
        WebElement dropDown = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("a-dropdown-prompt")));
        System.out.print("Found!\n");
        return searchForText(dropDown.getText(), "2");
    }

    public boolean productIsInCart() {
        goTo(CART_URL);

        // Attempt to find active cart
        WebElement cart = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(ACTIVE_CART)));

        // Product name should be in active cart
        return searchForText(cart.getText(), productName);
    }

    public boolean deleteProductFromCart() {
        // Go to active shopping cart and press delete button, if successful return true
        try {
            goTo(CART_URL);
            System.out.println("Attempting to find delete button... ");
            WebElement btn = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(By.name(DELETE_BTN_NAME)));
            System.out.print("Found!\n");
            btn.click();
            System.out.println("Clicking delete button.");
            return true;
        } catch (Exception e) {
            System.out.println("No delete button present");
            return false;
        }
    }

    public boolean checkoutButtonExists() {
        // Attempt to find checkout button, if present then return true
        try {
            System.out.println("Attempting to find checkout button");
            WebElement checkoutBtn = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className(CHECKOUT_BTN)));
            System.out.println("Found checkout button.");
            driver.quit();
            return true;
        } catch (Exception e) {
            driver.quit();
            return false;
        }
    }

    // Set and get functions

    public void setGoToUrl(String goToUrl) {
        setupSeleniumWebDrivers();
        this.goToUrl = goToUrl;
        driver.get(goToUrl);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    // Helper Functions

    private void setupSeleniumWebDrivers() {
        try {
            if (driver == null) {
                System.out.println("Setting up ChromeDriver... ");
                System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                System.out.print("Done!\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean searchForText(String text, String textToFind) {
        return text.contains(textToFind);
    }

    private void goTo(String url) {
        if (driver != null) {
            System.out.println("Going to " + url);
            driver.get(url);
        }
    }


}
