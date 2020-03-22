package tests;

import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
       if ( app.group().allGroup().size() == 0) {
          app.group().create(new GroupData().withName("test1"));
       }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.group().allGroup();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().allGroup();

    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }
}
