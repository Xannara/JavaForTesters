package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    Contacts before = app.contact().allContact();
    app.contact().gotoAddNewPage();
    ContactData contact = new ContactData()
            .withFirstname("Lena").withLastname("Lenina").withAddress("Moscow")
            .withHomePhone("88007776655").withEmail("lena@mail.com").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().allContact();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
