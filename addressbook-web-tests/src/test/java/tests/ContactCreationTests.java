package tests;

import model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    app.gotoAddNewPage();
    app.fillNewNameForm(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com"));
    app.submitNewNameCreation();
    app.returnToHomePage();
  }
}
