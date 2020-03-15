package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    /*if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test10"));
    }*/
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectName();
    app.getContactHelper().deleteSelectedName();
    app.getContactHelper().submitAlert();
    app.getContactHelper().returnToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before - 1);
  }
}
