package tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectName();
    app.getContactHelper().deleteSelectedName();
    app.getContactHelper().submitAlert();
  }
}
