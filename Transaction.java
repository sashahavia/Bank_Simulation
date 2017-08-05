/** Assignment 3 -- Aliaksandra Havia */
import java.util.Date;
import java.text.DateFormat;

public class Transaction {
	private int customerNumber;
	private String transactionType;
	private double amount;
	private Date date;
	private String fees;
	
	// Constructor
	public Transaction(int customerNumber, String transactionType, double amount, String fees) {
		this.customerNumber = customerNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.fees = fees;
		date = new Date();
	}


	public void processTran() {
		Account account = null;
		//Find account
		for(int i = 0; i < Bank.SIZE; i++) {
			if(BankTest.getBank().getAccount(i) != null) {
				if(BankTest.getBank().getAccount(i).getCustomer().getNumber() == this.customerNumber) {
					account = BankTest.getBank().getAccount(i);
					break;
				}
			} 
		}
		//Account not found
		if(account == null){
			return;
		}

		switch (transactionType) {
			case "DEPOSIT": 
				// System.out.println("\nT Deposit " + (account.getBalance() + amount));
				account.setBalance(account.getBalance() + amount);
				break;

			case "WITHDRAW":
				double newAmount = account.getBalance() - amount;
				double overdraft = 0.00;
				//Apply penalty for overdrawing
				if (newAmount < 0) {
					overdraft = newAmount * account.getCustomer().getOverdraftPenalty();
				}
				// System.out.println("\nT Withdraw " + newAmount);
				account.setBalance(newAmount + overdraft);
				break;

			default:
				break;
		}
		
	}

	@Override
	public String toString() {
		return("CustomerNumber: " + customerNumber
				+ " TransactionType: " + transactionType
				+ " " + DateFormat.getDateInstance().format(date) + " "
				+ " Amount: " + amount
				+ " Fees: " + fees);
	}
}