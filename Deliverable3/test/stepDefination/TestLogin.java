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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author simiao
 */
public class TestLogin {
    
    private WebDriver driver;
    private String baseUrl;
    
    @Given("^Open firefox and start application$")
    public void Open_firefox_and_start_application() throws Throwable {
        
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://store.demoqa.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
        
    }

    @When("^I enter valid username and valid password$")
    public void I_enter_valid_username_and_valid_password() throws Throwable {
        driver.findElement(By.linkText("AccountMy Account")).click();
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys("miaopoem");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("g*^lPf&JaeC$4^!S");
        
    }

    @Then("^user should be able to login successfully$")
    public void user_should_be_able_to_login_successfully() throws Throwable {
        //driver.findElement(By.linkText("Howdy, miaopoem")).click();
        driver.findElement(By.id("login")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.quit();
    }
    
    
    @When("^I enter invalid username or invalid password$")
    public void I_enter_invalid_username_or_invalid_password() throws Throwable {
        driver.findElement(By.linkText("AccountMy Account")).click();
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys("miaopoem");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("123456");
    }

    @Then("^User cannot login$")
    public void User_cannot_login() throws Throwable {
        driver.findElement(By.id("login")).click();
        assertEquals("ERROR", driver.findElement(By.cssSelector("strong")).getText());
        try {
          assertEquals("", driver.findElement(By.cssSelector("strong")).getAttribute("value"));
        } catch (Error e) {
        }
        driver.quit();
    }

}
