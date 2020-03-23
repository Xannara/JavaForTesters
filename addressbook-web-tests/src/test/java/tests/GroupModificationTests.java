package tests;

import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
          if ( app.group().allGroup().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
          }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.group().allGroup();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test15").withHeader("test20").withFooter("test30");
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().allGroup();
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    }
}
