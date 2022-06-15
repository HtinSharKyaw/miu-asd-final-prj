package banking.application.framework.dataaccess;

import java.util.ArrayList;
import java.util.List;

import banking.application.framework.models.Account;

/**
 * This class loads data into the data repository and also
 * sets up the storage units that are used in the application.
 * The main method in this class must be run once (and only
 * once) before the rest of the application can work properly.
 * It will create three serialized objects in the dataaccess.storage
 * folder.
 * 
 *
 */
public class TestData {
	
	
	public static void main(String[] args) {
		TestData td = new TestData();
		td.bookData();	
		AccountDAO da = new AccountDAOHandler();
		System.out.println(da.retrieveAccounts());
		//System.out.println(da.retrieveCustomers());
	}
	///create books
	public void bookData() {
		AccountDAOHandler.loadAccounts(allAccounts);
	}
	


	@SuppressWarnings("serial")
	List<Account> allAccounts = new ArrayList<Account>() {
		{
			
	
		}
	};

}
