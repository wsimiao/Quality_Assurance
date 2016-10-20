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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 *
 * @author simiao
 */
public class TestSearch {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Given("^Open firefox and open the website$")
    public void Open_firefox_and_open_the_website() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://store.demoqa.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @When("^I enter iphone in the search bar$")
    public void I_enter_iphone_in_the_search_bar() throws Throwable {
        driver.findElement(By.name("s")).clear();
        driver.findElement(By.name("s")).sendKeys("iphone");
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @Then("^iphone is returned in the resulte list$")
    public void iphone_is_returned_in_the_resulte_list() throws Throwable {
        try {
            assertEquals("iPhone 5", driver.findElement(By.linkText("iPhone 5")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.quit();

    }

    @When("^I enter cream in the search bar$")
    public void I_enter_cream_in_the_search_bar() throws Throwable {
        driver.findElement(By.name("s")).clear();
        driver.findElement(By.name("s")).sendKeys("cream");
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);

    }

    @Then("^There is no result list returned and it shows nothing matches$")
    public void There_is_no_result_list_returned_and_it_shows_nothing_matches() throws Throwable {
        try {
            assertEquals("Sorry, but nothing matched your search criteria. Please try again with some different keywords.", driver.findElement(By.cssSelector("p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.quit();
    }

}
