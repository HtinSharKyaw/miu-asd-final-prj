package banking.application.ui.bank;

import banking.application.banking.models.SavingAccount;
import banking.application.framework.enums.AccountType;
import banking.application.framework.models.Account;
import banking.application.framework.models.Address;
import banking.application.framework.models.Customer;
import banking.application.framework.services.AccountService;
import banking.application.framework.services.AccountServiceImpl;
import banking.application.ui.ccard.JDialogGenBill;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class BankFrm extends javax.swing.JFrame
{
	/****
	 * init variables in the object
	 ****/
	String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit,expdate,email, customerType;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	BankFrm myframe;
	private Object rowdata[];
	private AccountService accountService=AccountServiceImpl.getInstance();

	public BankFrm()
	{
		myframe = this;

		setTitle("Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		rowdata = new Object[8];
		newaccount=false;


		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);

	}


	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch (Exception e) {
			}

			//Create a new instance of our application's frame, and make it visible.
			(new BankFrm()).setVisible(true);
		}
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication()
	{
		try {
			this.setVisible(false);    // hide the Frame
			this.dispose();            // free the system resources
			System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == BankFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	//When the Exit button is pressed this code gets executed
	//this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "P";
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount=false;
		}



	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object
		 set the boundaries and
		 show it
		*/

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		System.out.println(accountnr + "C");

		if (newaccount){
			customerType = "Company";
			Address address=new Address(street,city,state,zip);
			Customer customer=new Customer(UUID.randomUUID().toString(),clientName,email,address,new Date("1/1/1985"));
			customerType = "Personal";
			Account account=new SavingAccount(accountnr,customer,0.0, AccountType.COMPANY) ;

			String [] controller = accountService.getAccountDetails(account);

			// add row to table
			rowdata[0] = controller[1];
			rowdata[1] = controller[0];
			rowdata[2] = controller[5];
			rowdata[3] = customerType;
			rowdata[4] = accountType;
			rowdata[5] = controller[4];
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount=false;
		}


	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accnr = (String)model.getValueAt(selection, 0);
			String CC = (String) model.getValueAt(selection,0);

			//Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			// compute new amount
			double amount = Double.parseDouble(amountDeposit);
			accountService.deposit(CC, amount,"No Description");
			double result =accountService.getAccountById(CC).getBalance();
					model.setValueAt(String.valueOf(result),selection, 5);
		}


	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0){
			String name = (String) model.getValueAt(selection, 1);
			String CC = (String) model.getValueAt(selection,0);
			double balance = Double.parseDouble((String) model.getValueAt(selection, 5));
			if (balance > 0) {
			 accountService.addInterest(CC);
				double result =accountService.getAccountById(CC).getBalance();
				JOptionPane.showMessageDialog(JButton_Withdraw, "Dear "+ name +", Your interest is calculated, and the current balance is $"+result+" !");
				model.setValueAt(String.valueOf(result), selection, 5);
			} else {
//				JOptionPane.showMessageDialog(JButton_Withdraw, " "+ name +" You do not have loan in your account then your interest is 0.");
				JOptionPane.showMessageDialog(JButton_Addinterest,  "Dear "+name + " ,you will not have an interest.\n your account balance is 0 or below 0", " no interest was calculated" ,JOptionPane.WARNING_MESSAGE);

			}
		}
	}
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0){
			String CC = (String) model.getValueAt(selection,0);

			JDialogGenBill billFrm = new JDialogGenBill();
			billFrm.setBounds(450, 20, 400, 350);
			String report = accountService.generateReport(CC);
			System.out.println(report);
			billFrm.JTextArea.append(report);
			billFrm.show();
		}
	}
}
