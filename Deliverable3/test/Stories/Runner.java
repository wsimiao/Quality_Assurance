/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stories;

/**
 *
 * @author simiao
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@Cucumber.Options(features = "features", glue={"stepDefination"})
@Cucumber.Options(features = {"features/login.feature", "features/shoppingCart.feature", "features/search.feature"}, glue={"stepDefination"})
public class Runner {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
/*
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://store.demoqa.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("a.account_icon > span.icon")).click();
    driver.findElement(By.id("log")).clear();
    driver.findElement(By.id("log")).sendKeys("m");
    driver.findElement(By.id("log")).clear();
    driver.findElement(By.id("log")).sendKeys("miaopoem");
    driver.findElement(By.id("pwd")).clear();
    driver.findElement(By.id("pwd")).sendKeys("g*^lPf&JaeC$4^!S");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.linkText("Howdy, miaopoem")).click();
  }
*/
//  @After
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }

//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
}
