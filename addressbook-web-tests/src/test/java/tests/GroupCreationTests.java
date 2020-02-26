package tests;

import model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    app.logout();
    }

}
