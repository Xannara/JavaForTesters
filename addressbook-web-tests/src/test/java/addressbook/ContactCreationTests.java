package addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddName() throws Exception {
    gotoAddNewPage();
    fillNewNameForm(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com"));
    submitNewNameCreation();
    returnToHomePage();
  }
}
