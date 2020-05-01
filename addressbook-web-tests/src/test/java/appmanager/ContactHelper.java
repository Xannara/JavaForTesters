package appmanager;

import model.ContactData;
import model.Contacts;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
    //  attach(By.name("photo"), contactData.getPhoto());

     /* if (creation) {
          new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
          Assert.assertFalse(isElementPresent(By.name("new_group")));
      }*/
}

    public void gotoAddNewPage() {
      click(By.linkText("add new"));
    }

    public void selectNameById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }

    public void deleteSelectedName() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitAlert() {
        wd.switchTo().alert().accept();
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("[href^='edit.php?id=" + id + "']")).click();
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

        /*if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }*/
    }

    public void create(ContactData contact) {
        fillNewNameForm(contact, true);
        submitNewNameCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        selectNameById(contact.getId());
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectNameById(contact.getId());
        deleteSelectedName();
        submitAlert();
        contactCache = null;
        returnToHome();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts allContact() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname)
                    .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobile(mobile).withWork(work);
    }

    public ContactData infoFromEditFormEmail(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    public ContactData infoFromEditFormAddress(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withAddress(address);
    }


    public void returnToAllContacts() {
        wd.findElement(By.name("group")).click();
        new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
        wd.findElement(By.xpath("//option[@value='']")).click();
    }

    public void returnToContactInGroup() {
        wd.findElement(By.linkText("group page \"test 1\"")).click();
    }

    public void addToGroup(GroupData groupData) {
        wd.findElement(By.name("to_group")).click();
        new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(groupData.getName());
        wd.findElement(By.xpath("(//option[@value='39'])[2]")).click();
        wd.findElement(By.name("add")).click();
    }

    public void returnToContactList() {
        wd.findElement(By.name("group")).click();
        new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
        wd.findElement(By.xpath("//option[@value='']")).click();
    }

    public void returnToContactsInGroup() {
        wd.findElement(By.linkText("group page \"test 1\"")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void selectContactInGroup() {
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.name("remove")).click();
    }

    public void selectGroup(GroupData groupData) {
        wd.findElement(By.name("group")).click();
        new Select(wd.findElement(By.name("group"))).selectByVisibleText(groupData.getName());
        wd.findElement(By.xpath("//option[@value='39']")).click();
    }
}
