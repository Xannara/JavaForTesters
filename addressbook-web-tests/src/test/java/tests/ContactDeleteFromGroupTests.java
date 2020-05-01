package tests;

import model.GroupData;
import org.testng.annotations.Test;

public class ContactDeleteFromGroupTests extends TestBase {

    @Test
  public void testContactDeleteFromGroup() throws Exception {

      app.getContactHelper().selectGroup(new GroupData());
      app.getContactHelper().selectContactInGroup();
      app.getContactHelper().returnToContactsInGroup();
      app.getContactHelper().returnToContactList();
  }

}
