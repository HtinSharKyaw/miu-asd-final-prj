package banking.application.framework.models;

import java.util.Date;

public class CompanyCustomer extends Customer {
    public CompanyCustomer(String name, String email, Address address, Date birthDate) {
        super(name, email, address, birthDate);
    }
}
