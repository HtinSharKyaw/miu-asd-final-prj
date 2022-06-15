package banking.application.framework.models;

import java.util.Date;

public class CompanyCustomer extends Customer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6255370638015680987L;

	public CompanyCustomer(String customerId,String name, String email, Address address, Date birthDate) {
        super(customerId,name, email, address, birthDate);
    }
}
