package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.ContactData;
import model.Contacts;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJSON() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
          String json = "";
          String line = reader.readLine();
          while (line != null) {
            json += line;
            line = reader.readLine();
          }
          Gson gson = new Gson();
          List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
          }.getType());
          return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validContactsFromJSON")
    public void testAddName(ContactData contact) throws Exception {
        Contacts before = app.db().contacts();
        app.contact().gotoAddNewPage();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
