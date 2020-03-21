package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    List<ContactData> before = app.contact().contactList();
    app.contact().gotoAddNewPage();
    ContactData contact = new ContactData()
            .withFirstname("Lena").withLastname("Lenina").withAddress("Moscow")
            .withHometelephone("88007776655").withEmail("lena@mail.com").withGroup("test1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(),before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
