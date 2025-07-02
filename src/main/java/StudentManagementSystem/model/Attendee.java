package StudentManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , length = 50 , nullable = false)
    private String name;

    @Column(name = "first_last_name" , length = 50 , nullable = false)
    private String firstLastName;

    @Column(name = "second_last_name" , length = 50)
    private String secondLastName;

    @Pattern(
            regexp = "^\\+?[0-9\\-\\s]{9,15}$" ,
            message = "Phone number must be 9 - 15 numbers long, can include (+ , -) chars and empty spaces"
    )
    private String phoneNumber;

    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String contactMail;

    public Attendee() {

    }

    public Attendee(String name, String firstLastName, String secondLastName, String phoneNumber, String contactMail) {
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phoneNumber = phoneNumber;
        this.contactMail = contactMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }


    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Attendee attendee = (Attendee) o;
        return Objects.equals(id, attendee.id) && Objects.equals(name, attendee.name) && Objects.equals(firstLastName, attendee.firstLastName) && Objects.equals(secondLastName, attendee.secondLastName) && Objects.equals(phoneNumber, attendee.phoneNumber) && Objects.equals(contactMail, attendee.contactMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstLastName, secondLastName, phoneNumber, contactMail);
    }
}

//CLASSE ABSTRACTA PER ENTITATS D'ASSITENTS