/** Assignment 3 -- Aliaksandra Havia */

public class Senior extends Customer {

	public static final double SAVINGS_INTEREST = 0.00;
	public static final double CHECKING_INTEREST = 0.00;
	public static final double CHECK_CHARGE = 0.00;
	public static final double OVERDRAFT_PENALTY = 5.00;

	//Constructor 
	public Senior(String name, String address, int age, String telephoneNumber, int customerNumber) {
		super(name, address, age, telephoneNumber, customerNumber);
	}

	// Accessor 
	@Override
	public double getSavingsInterest () {
		return SAVINGS_INTEREST;
	}
	@Override
	public double getCheckingInterest () {
		return CHECKING_INTEREST;
	}
	@Override
	public double getCheckCharge () {
		return CHECK_CHARGE;
	}
	@Override
	public double getOverdraftPenalty () {
		return OVERDRAFT_PENALTY;
	}
	
}