/** Assignment 3 -- Aliaksandra Havia */

public abstract class Customer {
	private String name;
	private String address;
	private int age;
	private String telephoneNumber;
	private int customerNumber;

	// Constructor 
	public Customer(String name, String address, int age, String telephoneNumber, int customerNumber) {
		this.name = name;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
		this.customerNumber = customerNumber;
		this.age = age;
	}

	// Modifier methods
	public void setName (String name) {
		this.name = name;
	}

	public void setAddress (String address) {
		this.address = address;
	}

	public void setAge (int age) {
		this.age = age;
	}

	public void setTelephoneNumber (String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setCustomerNumber (int customerNumber) {
		this.customerNumber = customerNumber;
	}

	// Accessor methods
	public String getName () {
		return name;
	}

	public String getAddress () {
		return address;
	}

	public int getAge () {
		return age;
	}

	public String getTelephoneNumber () {
		return telephoneNumber;
	}

	public int getNumber () {
		return customerNumber;
	}

	@Override
	public String toString() {
		return(name + " | " + address + " | " + telephoneNumber + " | " + age + " | " + customerNumber);
	}

	public abstract double getSavingsInterest ();
	public abstract double getCheckingInterest ();
	public abstract double getCheckCharge ();
	public abstract double getOverdraftPenalty ();
	
}