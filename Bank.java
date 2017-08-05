/** Assignment 3 -- Aliaksandra Havia */

import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Bank {
	private static Account[] accounts;
	public static int SIZE = 2;
	private static Scanner in;

	public Bank() {
		accounts = new Account[SIZE];
		in = new Scanner(System.in);
	}

	public void addAccount(Account account) {
		if(account == null)
			return;
		
		boolean isFull = (Arrays.stream(accounts).filter(i -> i != null).count() < accounts.length);
		
		// If accounts is full increase the array by twice the original size
		if(isFull)
			reallocate(accounts.length * 2);
		
		//Search for an empty space
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i] == null) {
				accounts[i] = account;
				break;
			}
		}
	}

	// Make a deposit
	public static void makeDeposit() {
		System.out.println("\nDeposit: ");
		Account account = findAccount();

		if (account == null) {
			System.out.println("\nAccount does not exist");
			return;
		}
		System.out.println("\nHow much would you like to deposit: ");
		double deposit = in.nextDouble();
		account.deposit(Double.parseDouble(new DecimalFormat(".##").format(deposit)));
		System.out.println(account);
		System.out.println("Deposit Complete");
	}

	public static void makeWithdrawl () {
		System.out.println("\nWithdrawl: ");
		Account account = findAccount();

		if (account == null) {
			System.out.println("\nAccount idoes not exist");
			return;
		}
		System.out.println("\nHow much would you like to withdraw: ");
		double withdraw = in.nextDouble();
		account.withdraw(Double.parseDouble(new DecimalFormat(".##").format(withdraw)));
		System.out.println(account);
		System.out.println("Withdrawl Complete");

	}

	public static void accountInfo() {
		System.out.println("\nAccount Info: ");
		Account account = findAccount();

		if (account == null) {
			System.out.println("\nAccount idoes not exist");
			return;
		}
		System.out.println(account);
		System.out.println("\nComplete.");
	}

	public static Account findAccount() {
		String name;
		int accountNumber = 0;

		System.out.println("\nEnter customer's name: ");
		name = in.next(); 

		System.out.println("\nAccount #: ");
		accountNumber = in.nextInt();
		return (getAccount(name, accountNumber));
	}

	public Account getAccount(int i) {
		return ((i >= 0 && i < accounts.length) ? accounts[i] : null);
	}

	public static Account getAccount(String name, int accountNumber) {
		Account account = null;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				if (accounts[i].getCustomer().getName().equalsIgnoreCase(name) && accounts[i].getNumber() == accountNumber) {
					account = accounts[i];
					break;
				}
			}
		}
		return account;
	}

	public void reallocate (int size){
		System.out.println("Reallocate ");
		if(size < 0) {
			return;
		} 
		SIZE = size;
		Account[] temp = accounts;
		accounts = new Account[SIZE];
		System.arraycopy(temp, 0, accounts, 0, temp.length);

	}

}