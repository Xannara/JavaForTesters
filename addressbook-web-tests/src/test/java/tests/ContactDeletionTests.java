package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    /*if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test10"));
    }*/
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectName(before.size() - 1);
    app.getContactHelper().deleteSelectedName();
    app.getContactHelper().submitAlert();
    app.getContactHelper().returnToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() - 1);
  }
}
