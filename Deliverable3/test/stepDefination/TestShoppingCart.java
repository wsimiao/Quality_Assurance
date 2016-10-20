/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author simiao
 */
public class TestShoppingCart {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    
    
    @Given("^I am at the page of one item$")
    public void I_am_at_the_page_of_one_item() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://store.demoqa.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("All Product")).click();
        driver.findElement(By.linkText("iPhone 5")).click();
        Thread.sleep(10000);


    }

    @When("^I click add to cart button$")
    public void I_click_add_to_cart_button() throws Throwable {
        driver.findElement(By.name("Buy")).click();
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.linkText("Go to Checkout"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.linkText("Go to Checkout")).click();
    }

    @Then("^I should see the text you just added the item to your cart$")
    public void I_should_see_the_text_you_just_added_the_item_to_your_cart() throws Throwable {
 
        //assertEquals("You just added \"Magic Mouse\" to your cart.", driver.findElement(By.cssSelector("#fancy_notification_content > span")).getText());
        //driver.findElement(By.linkText("Go to Checkout")).click(); 
        assertTrue(isElementPresent(By.linkText("iPhone 5")));

        driver.quit();
    }

    @Given("^(\\d+) item is in the shopping cart and I am in the cart page$")
    public void item_is_in_the_shopping_cart_and_I_am_in_the_cart_page(int arg1) throws Throwable {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://store.demoqa.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("All Product")).click();
        driver.findElement(By.linkText("iPhone 5")).click();
        Thread.sleep(10000);
        driver.findElement(By.name("Buy")).click();
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.linkText("Go to Checkout"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.linkText("Go to Checkout")).click();
        Thread.sleep(10000);

    }

    @When("^change the quantity with a positive number$")
    public void change_the_quantity_with_a_positive_number() throws Throwable {
        driver.get(baseUrl + "/products-page/checkout/");
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("3");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(10000);
        
    }

    @Then("^the quantity of items in the cart changes and total price changes$")
    public void the_quantity_of_items_in_the_cart_changes_and_total_price_changes() throws Throwable {
        assertEquals("3", driver.findElement(By.cssSelector("em.count")).getText());
        driver.quit();
    }

    @When("^change the quantity with a negative number$")
    public void change_the_quantity_with_a_negative_number() throws Throwable {
        driver.get(baseUrl + "/products-page/checkout/");
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("-3");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(10000);
    }

    @Then("^the cart is empty and I should see the text error$")
    public void the_cart_is_empty_and_I_should_see_the_text_error() throws Throwable {
        assertEquals("0", driver.findElement(By.cssSelector("em.count")).getText());
        assertEquals("Oops, there is nothing in your cart.", driver.findElement(By.cssSelector("div.entry-content")).getText());
        driver.quit();
    }

    @When("^I click remove button$")
    public void I_click_remove_button() throws Throwable {
        ///////
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]")).click();
        Thread.sleep(10000);
    }

    @Then("^the cart is empty and I should see the text (\\d+) item$")
    public void the_cart_is_empty_and_I_should_see_the_text_item(int arg1) throws Throwable {
        assertEquals("0", driver.findElement(By.cssSelector("em.count")).getText());
        assertEquals("Oops, there is nothing in your cart.", driver.findElement(By.cssSelector("div.entry-content")).getText());
        driver.quit();
    }

    @When("^I add the same item again$")
    public void I_add_the_same_item_again() throws Throwable {
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.name("submit"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.linkText("All Product")).click();
        driver.findElement(By.linkText("iPhone 5")).click();
        Thread.sleep(10000);
        driver.findElement(By.name("Buy")).click();
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.linkText("Go to Checkout"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.linkText("Go to Checkout")).click();
        Thread.sleep(10000);
    }

    @Then("^I should see the quantity of this item is (\\d+)$")
    public void I_should_see_the_quantity_of_this_item_is(int arg1) throws Throwable {
        assertEquals("2", driver.findElement(By.cssSelector("em.count")).getText());
        driver.quit();
    }

    
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
