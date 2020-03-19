package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().contactList().size() == 0) {
      app.contact().gotoAddNewPage();
      app.contact().create(new ContactData("Lena", "Lenina", "Moscow", "88007776655", "lena@mail.com", "test10"));
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    List<ContactData> before = app.contact().contactList();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(),before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
