package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    Set<ContactData> before = app.contact().allContact();
    app.contact().gotoAddNewPage();
    ContactData contact = new ContactData()
            .withFirstname("Lena").withLastname("Lenina").withAddress("Moscow")
            .withHometelephone("88007776655").withEmail("lena@mail.com").withGroup("test1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().allContact();
    Assert.assertEquals(after.size(),before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
