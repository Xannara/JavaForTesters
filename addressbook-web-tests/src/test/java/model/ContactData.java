package model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String hometelephone;
    private final String email;
    private String group;

    public ContactData(String firstname, String lastname, String address, String hometelephone, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.hometelephone = hometelephone;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHometelephone() {
        return hometelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
