package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

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
        Set<GroupData> before = app.group().allGroup();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test15").withHeader("test20").withFooter("test30");
        app.group().modify(group);
        Set<GroupData> after = app.group().allGroup();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
