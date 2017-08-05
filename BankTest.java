/** Assignment 3 -- Aliaksandra Havia */
import java.util.Scanner;
import java.text.DecimalFormat;

public class BankTest {
	private static Bank bank;
	private static int choice;
	private static Scanner in;
	private static boolean isRunning = true;	

	public static void main(String[] args) {
		in = new Scanner(System.in);

		// load all data
		bank = new Bank();
		while (isRunning) {
			options();
			choice = in.nextInt();
			process(choice);
		}
		// in.close();

	}

	public static void options() {
		System.out.println("\nWelcome to our Bank");
		System.out.println("What would you like to do?");
		System.out.println("1 - Open an account");
		System.out.println("2 - Make a deposit");
		System.out.println("3 - Make a withdrawl");
	    System.out.println("4 - View Account Information");
	    System.out.println("5 - Exit");
	    System.out.println("choice: ");
	}

	public static void process(int choice) {
		switch (choice) {
			case 1:	
				createAccount();
				break;
			case 2:
				Bank.makeDeposit();	
				break;
			case 3:
				Bank.makeWithdrawl();
				break;
			case 4:
				Bank.accountInfo();
				break;
			case 5:
				System.out.println("Thank you!");
				isRunning = false;
                break;
            default:
                System.out.println("Not a valid choice!");
			}	
	}

	public static void createAccount(){
		Customer customer = null;
		Account account = null;
		String name, address, telephoneNumber;
		String accountType = "";
		int age, customerNumber, accountNumber = 0;

		// Get new customer's info
		System.out.println("\nEnter customer's name: ");
		name = in.next(); 
		System.out.println("\nEnter customer's address: ");
		address = in.next();
        address += in.nextLine();
		System.out.println("\nEnter customer's telephone: ");
		telephoneNumber = in.nextLine(); 
		System.out.println("\nEnter the age of customer: ");
		age = in.nextInt(); 
		System.out.println("\nEnter customer's number: ");
		customerNumber = in.nextInt();

		// check age to set type of customer
		if (age >= 65) {
			customer = new Senior(name, address, age, telephoneNumber, customerNumber);
		} else if (age < 65 && age >= 23) {
			customer = new Adult(name, address, age, telephoneNumber, customerNumber);
		} else if (age < 23) {
			customer = new Student(name, address, age, telephoneNumber, customerNumber);
		} else {
			customer = new Adult(name, address, age, telephoneNumber, customerNumber);
		}

		System.out.println("\nEnter 3 digit account #: ");
		accountNumber = in.nextInt();
		// check what type of account this is: checking or savings
		System.out.println("\nEnter account type: \"s\" for savings \"c\" for checking");
		accountType = in.next();
		if(accountType.equalsIgnoreCase("s")){
			System.out.println("Creating savings");
			account = new SavingsAccount(customer, accountNumber);
		} else if (accountType.equalsIgnoreCase("c")){
			System.out.println("Creating checking");
			account = new CheckingAccount(customer, accountNumber);
		} else {
			System.out.println("Not a valid choice!");
		}
		in.nextLine(); // Clears the scanner by advancing the scanner to the next line

		System.out.println("Initial deposit: ");
		double deposit = in.nextDouble();
		if(deposit > 0)
			account.setBalance(account.getBalance() + Double.parseDouble(new DecimalFormat(".##").format(deposit)));
		in.nextLine(); // Clears the scanner by advancing the scanner to the next line
		// Add an account
		bank.addAccount(account);
		System.out.println("\nBank: "
				+ (account instanceof CheckingAccount ? "Checking " : "Savings ") +
				"Account \nName: " + name + "\nAge: " + age + "\nAccount Number: " + accountNumber + "\nDeposit: " + deposit + "\nCreated successfully.");
	}

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

	public static void makeWithdraw () {
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
		return (bank.getAccount(name, accountNumber));
	}

	public static Bank getBank() {
		return bank;
	}
}