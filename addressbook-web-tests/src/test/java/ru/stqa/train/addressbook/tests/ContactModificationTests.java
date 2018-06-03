package ru.stqa.train.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.train.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().List().size() == 0) {
      app.contact().create(new ContactData("First name", "Middle",
              "Last name", "Address new", "84953864656",
              "example@mail.com", null), false);
    }
    app.goTo().HomePage();

  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().List();
    int index = before.size() - 1;
    ContactData contact = new ContactData("First name modified", "Middle modified",
            "Last name modified", "Address modified", "84951111111",
            "example_modified@mail.com", null);
    app.contact().modify(index, contact);
    app.goTo().HomePage();
    List<ContactData> after = app.contact().List();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
