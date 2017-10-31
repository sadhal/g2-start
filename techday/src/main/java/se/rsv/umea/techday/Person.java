package se.rsv.umea.techday;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Person {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String email;
    public String twitterHandle;
    public Date createdOn = new Date();

    public Person() {}

    public Person(String firstName, String lastName, String email, String twitterHandle, Date createdOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.twitterHandle = twitterHandle;
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", twitterHandle='" + twitterHandle + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
