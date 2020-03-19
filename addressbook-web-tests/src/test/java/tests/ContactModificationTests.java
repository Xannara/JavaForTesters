package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().contactList().size() == 0) {
            app.contact().gotoAddNewPage();
            app.contact().create(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test10"));
        }
    }

    @Test
    public void testContactModification() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().contactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(),"Lana", "Lanina", "Belgorod", "84722555555", "1@mail.ru", null);
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
