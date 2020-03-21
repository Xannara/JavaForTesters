package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().allContact().size() == 0) {
      app.contact().gotoAddNewPage();
      app.contact().create(new ContactData()
              .withFirstname("Lena").withLastname("Lenina").withAddress("Moscow")
              .withHometelephone("88007776655").withEmail("lena@mail.com").withGroup("test10"));
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().allContact();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().allContact();
    Assert.assertEquals(after.size(),before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
