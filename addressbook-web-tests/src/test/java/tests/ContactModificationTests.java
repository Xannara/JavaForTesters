package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().allContact().size() == 0) {
            app.contact().gotoAddNewPage();
            app.contact().create(new ContactData()
                    .withFirstname("Lena").withLastname("Lenina").withAddress("Moscow")
                    .withHomePhone("88007776655").withEmail("lena@mail.com").withGroup("test10"));
        }
    }

    @Test
    public void testContactModification() {
        app.goTo().homePage();
        Contacts before = app.contact().allContact();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Luna").withLastname("Lunina")
                .withAddress("Ekaterinburg").withHomePhone("84722555555").withEmail("2@mail.ru");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().allContact();
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }
}
