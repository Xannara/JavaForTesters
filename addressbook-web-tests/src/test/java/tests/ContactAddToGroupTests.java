package tests;

import model.GroupData;
import org.testng.annotations.Test;

public class ContactAddToGroupTests extends TestBase {

    @Test
    public void testContactAddToGroup() throws Exception {

        app.getContactHelper().selectContact();
        app.getContactHelper().addToGroup(new GroupData());
        app.getContactHelper().returnToContactInGroup();
        app.getContactHelper().returnToAllContacts();
    }

}
