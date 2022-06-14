package banking.application.framework.models;

import java.util.Date;

public class IndividualCustomer extends Customer {

    public IndividualCustomer(String name, String email, Address address, Date birthDate) {
        super(name, email, address, birthDate);
    }
}
