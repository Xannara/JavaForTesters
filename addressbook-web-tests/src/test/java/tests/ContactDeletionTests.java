package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
       /* if ( app.group().list().size() == 0) {
            app.group().create(new GroupData("test1", null, null));  // contact
        }*/
  }

  @Test
  public void testContactDeletion() throws Exception {
    app.goTo().gotoHomePage();
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

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
