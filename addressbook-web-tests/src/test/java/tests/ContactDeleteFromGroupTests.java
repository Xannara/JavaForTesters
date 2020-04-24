package tests;

import java.util.concurrent.TimeUnit;

import model.GroupData;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactDeleteFromGroupTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/?group=");
  }

  @Test
  public void testContactDeleteFromGroup() throws Exception {

      selectGroup(new GroupData());
      selectContact();
      returnToContactsInGroup();
      returnToContactList();
  }

    private void returnToContactList() {
        wd.findElement(By.name("group")).click();
        new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
        wd.findElement(By.xpath("//option[@value='']")).click();
    }

    private void returnToContactsInGroup() {
        wd.findElement(By.linkText("group page \"test 1\"")).click();
    }

    private void selectContact() {
        wd.findElement(By.id("46")).click();
        wd.findElement(By.name("remove")).click();
    }

    private void selectGroup(GroupData groupData) {
        wd.findElement(By.name("group")).click();
        new Select(wd.findElement(By.name("group"))).selectByVisibleText(groupData.getName());
        wd.findElement(By.xpath("//option[@value='39']")).click();
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