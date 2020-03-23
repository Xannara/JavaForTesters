package tests;

import model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().allContact().size() == 0) {
            app.contact().gotoAddNewPage();
            app.contact().create(new ContactData()
                    .withFirstname("Lena").withLastname("Lenina").withAddress("Moscow")
                    .withHomePhone("88007776655").withMobile("89167776655").withWork("4722555555")
                    .withEmail("lena@mail.com").withGroup("test10"));
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().allContact().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
