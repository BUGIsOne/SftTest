package TelFee;

public abstract class Phone {
	private String phoneNumber;
	private double baseRate;
	private double taxAmt;
	private final double HST = 0.13;

	/** Accessor methods */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public double getBaseRate() {
		return baseRate;
	}

	public double getTaxAmt() {
		return taxAmt;
	}

	public double getHST() {
		return HST;
	}

	/** Mutator methods */
	public void setPhoneNumber(String newPhoneNumber) {
		phoneNumber = newPhoneNumber;
	}

	public void setBaseRate(double newBaseRate) {
		baseRate = newBaseRate;
	}

	public void setTaxAmt(double newTaxAmt) {
		taxAmt = newTaxAmt;
	}

	/** Constructor */
	public Phone(String intPhoneNumber, double intBaseRate) {
		phoneNumber = intPhoneNumber;
		baseRate = intBaseRate;
	}

	/** to calculate the before-tax bill total */
	public abstract double calcuBefTaxBill();

	/** The tax calculation method */
	public abstract double calcuTax();
}
