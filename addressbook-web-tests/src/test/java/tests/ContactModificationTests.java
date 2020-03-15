package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
       /* if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().gotoAddNewPage();
            app.getContactHelper().createContact(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test10"));
        }*/
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectName(before.size() - 1);
        app.getContactHelper().initContactModification(before.size() - 1);
        app.getContactHelper().fillContactForm(new ContactData("Lana", "Lanina", "Belgorod", "84722555555", "1@mail.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
