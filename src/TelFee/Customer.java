package TelFee;

import java.io.IOException;

public class Customer {
	private String name;

	private Phone cPhone;

	public String getName() {
		return name;
	}
	public Phone getCPhone() {
		return cPhone;
	}
	
	/** Mutator methods */
	public void setName(String newName) {
		name = newName;
	}
	
	public void setcPhone(Phone newCPhone) {
		cPhone = newCPhone;
	}
	
	/** Constructor */
	public Customer() throws IOException {
		name = Input.getString("Enter name: ");
		int choice = Input.getInt("1:FLAT RATE 2:PRE-MINUTE Enter Choice: ", 1, 2);
		String cPhoneNumber = Input.getString("Enter Phone Number: ");
		double baseRate = Input.getDouble("Base Rate: ", 0.00, 100.00);
		if (choice == 1) {
			cPhone = new FlatRatePhone(cPhoneNumber, baseRate); 
		} else {
			cPhone = new PerMinutePhone(cPhoneNumber, baseRate); 
		}
	}
	
	/** display of output */
	public String toString() {
		return name + "    Number: " + cPhone.getPhoneNumber();
	}
}
