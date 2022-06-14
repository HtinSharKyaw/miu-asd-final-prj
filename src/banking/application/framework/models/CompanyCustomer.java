package banking.application.framework.models;

import java.util.Date;

public class CompanyCustomer extends Customer {
    public CompanyCustomer(String customerId,String name, String email, Address address, Date birthDate) {
        super(customerId,name, email, address, birthDate);
    }
}
