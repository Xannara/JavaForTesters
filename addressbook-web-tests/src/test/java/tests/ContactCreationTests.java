package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test1"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before + 1);
  }
}
