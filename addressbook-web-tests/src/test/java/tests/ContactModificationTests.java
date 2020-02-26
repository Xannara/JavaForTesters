package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectName();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Lana", "Lanina", "Belgorod", "84722555555", "1@mail.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
