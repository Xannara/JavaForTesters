package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactAddToGroupTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContactAddToGroup() throws Exception {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.id("46")).click();
    wd.findElement(By.name("to_group")).click();
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText("test 1");
    wd.findElement(By.xpath("(//option[@value='39'])[2]")).click();
    wd.findElement(By.name("add")).click();
    wd.findElement(By.linkText("group page \"test 1\"")).click();
    wd.findElement(By.name("group")).click();
    new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
    wd.findElement(By.xpath("//option[@value='']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
