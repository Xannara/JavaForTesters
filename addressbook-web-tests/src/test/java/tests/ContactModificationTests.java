package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
       /* if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().gotoAddNewPage();
            app.getContactHelper().createContact(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test10"));
        }*/
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectName();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Lana", "Lanina", "Belgorod", "84722555555", "1@mail.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before);
    }
}
