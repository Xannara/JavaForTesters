package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().allContact().size() == 0) {
      app.contact().gotoAddNewPage();
      app.contact().create(new ContactData()
              .withFirstname("Lena").withLastname("Lenina").withAddress("Moscow")
              .withHomePhone("88007776655").withEmail("lena@mail.com").withGroup("test10"));
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().allContact();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().allContact();
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }
}
