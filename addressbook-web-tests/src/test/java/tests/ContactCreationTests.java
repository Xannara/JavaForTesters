package tests;

import model.ContactData;
import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test1"));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);
  }
}
