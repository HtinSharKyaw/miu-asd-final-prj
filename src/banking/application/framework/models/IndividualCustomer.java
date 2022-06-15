package banking.application.framework.models;

import java.util.Date;

public class IndividualCustomer extends Customer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1478367162624182655L;

	public IndividualCustomer(String customerId,String name, String email, Address address, Date birthDate) {
        super(customerId,name, email, address, birthDate);
    }
}
