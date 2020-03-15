package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewNameCreation() {
      click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillNewNameForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"), contactData.getFirstname());
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("address"), contactData.getAddress());
      type(By.name("home"), contactData.getHometelephone());
      type(By.name("email"), contactData.getEmail());

      if (creation) {
          new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
          Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
}

    public void gotoAddNewPage() {
      click(By.linkText("add new"));
    }

    public void selectName(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedName() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitAlert() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void returnToHome() {
        click(By.linkText("home"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHometelephone());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void createContact(ContactData contact) {
        fillNewNameForm(contact, true);
        submitNewNameCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstname = element.getText();
            String lastname = element.getText();
            ContactData contact = new ContactData(firstname, lastname, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
