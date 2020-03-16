package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoAddNewPage();
    ContactData contact = new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test1");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
