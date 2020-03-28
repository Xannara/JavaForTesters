package tests;

import model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

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
    public void testContactEmail() {
        app.goTo().homePage();
        ContactData contact = app.contact().allContact().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditFormAddress(contact);

        assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
    }
}
