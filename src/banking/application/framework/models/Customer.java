package banking.application.framework.models;

import java.util.Date;

public class Customer {
    private String name;
    private String email;
    private Address address;
    private Date birthDate;

    public Customer(String name, String email, Address address, Date birthDate) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
