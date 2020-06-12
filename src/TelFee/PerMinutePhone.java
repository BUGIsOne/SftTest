package TelFee;

import java.io.IOException;

public class PerMinutePhone extends Phone {
	private double minutes;
	
	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double newMinutes) {
		minutes = newMinutes;
	}

	/** Constructor */
	public PerMinutePhone(String intCPhoneNumber, double intBaseRate)
			throws IOException {
		super(intCPhoneNumber, intBaseRate);
		minutes = Input.getDouble("Minutes Used: ", 0.00, 500.00);
		double taxAmt = calcuTax();
		super.setTaxAmt(taxAmt);
	}

	/** to calculate the before-tax bill total */
	public double calcuBefTaxBill() {
		return super.getBaseRate() + minutes * 0.25;
	}

	/** The tax calculation method */
	public double calcuTax() {
		return super.getHST() * calcuBefTaxBill();
	}

	/** display of output */
	public String toString() {
		return "  Amt: $ " + calcuBefTaxBill() + "\n" 
			 + "  Tax: $ " + super.getTaxAmt() + "\n" 
			 + "  TOTAL: $ " + (calcuBefTaxBill() + super.getTaxAmt()) + "\n"
			 + "    PER MINUTE PLAN: Rate:0.25  Minutes Used: " + minutes;
	}
}
