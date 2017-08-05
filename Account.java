/** Assignment 3 -- Aliaksandra Havia */
import java.util.Arrays;
import java.text.DecimalFormat;

public abstract class Account {
	protected Customer customer;
	protected int accountNumber;
	protected double balance = 0;
	protected Transaction[] transactions;
	private double interest = 0.00d;
	/** Constructors */
	/* Static constructor */
	{
		transactions = new Transaction[2];
		balance = 0.00d;
	}

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	// Accessor methods
	public double getBalance () {
		return balance;
	}

	public Customer getCustomer () {
		return customer;
	}

	public int getNumber() {
		return accountNumber;
	}

	public double getInterest() {
		return interest;
	}

	public Transaction[] transactions() {
		return transactions;
	}

	// Modifier methods
	public void setBalance (double amount) {
		balance = Double.parseDouble(new DecimalFormat(".##").format(amount));
	}

	public void setCustomer (Customer customer){
		this.customer = customer;
	}

	public void setInterest(double amount) {
		this.interest = amount;
	}

	@Override
	public String toString () {
		return ("Account type: " + (this instanceof CheckingAccount ? "checking " : "savings ") + "\nAccount number: " + accountNumber + "\nBalance: " + balance + "\nCustomer: " + customer);
	}

	public void reallocate(){
		Transaction[] temp = transactions;
		transactions = new Transaction[temp.length * 2];
		System.arraycopy(temp, 0, transactions, 0, temp.length);
	}

	public abstract void deposit (double amount);
	public abstract void withdraw (double amount);
	public abstract void addInterest (double amount);



}