/** Assignment 3 -- Aliaksandra Havia */
import java.util.Arrays;

public class CheckingAccount extends Account{

	//Constructor 
	public CheckingAccount(Customer customer, int accountNumber) {
		super(accountNumber);
		setCustomer(customer);
	}

	@Override
	public void deposit (double amount){
		boolean isFull = (Arrays.stream(transactions()).filter(i -> i != null).count() + 1 >= transactions().length);
		if(isFull)
			reallocate();
		Transaction t = new Transaction(getCustomer().getNumber(), "DEPOSIT", amount, "None");
		for(int i = 0; i < transactions().length; i++) {
			if(transactions()[i] == null) {
				transactions()[i] = t;
				break;
			}
		}
		t.processTran();
		System.out.println(t);
	}

	@Override
	public void withdraw (double amount){
		boolean isFull = (Arrays.stream(transactions()).filter(i -> i != null).count() + 1 >= transactions().length);
		if(isFull)
			reallocate();

		Transaction t = new Transaction(getCustomer().getNumber(), "WITHDRAW", amount, "None");
		for(int i = 0; i < transactions().length; i++) {
			if(transactions()[i] == null) {
				transactions()[i] = t;
				break;
			}
		}
		t.processTran();
		System.out.println(t);
	}

	@Override
	public void addInterest(double amount){
	}
}