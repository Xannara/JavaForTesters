package tests;

import model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    app.getContactHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test1"));
  }
}
