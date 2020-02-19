package tests;

import model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    app.getContactHelper().gotoAddNewPage();
    app.getContactHelper().fillNewNameForm(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com"));
    app.getContactHelper().submitNewNameCreation();
    app.returnToHomePage();
  }
}
