/** Assignment 3 -- Aliaksandra Havia */

public class Adult extends Customer {

	public static final double SAVINGS_INTEREST = 0.02;
	public static final double CHECKING_INTEREST = 0.02;
	public static final double CHECK_CHARGE = 0.02;
	public static final double OVERDRAFT_PENALTY = 35.00;

	// Constructor 
	public Adult(String name, String address, int age, String telephoneNumber, int customerNumber) {
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