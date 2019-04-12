package models;

public class User {

    int id;
    String FirstName;
    String lastName;

    public User(int id, String firstName, String lastName) {
        this.id = id;
        FirstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return lastName;
    }

}
