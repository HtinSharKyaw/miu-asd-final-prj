package banking.application.framework.models;

import java.util.Date;

public class IndividualCustomer extends Customer {

    public IndividualCustomer(String customerId,String name, String email, Address address, Date birthDate) {
        super(customerId,name, email, address, birthDate);
    }
}
