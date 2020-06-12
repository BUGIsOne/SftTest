package TelFee;

import java.io.IOException;

public class FlatRatePhone extends Phone{
	private double flatRatePremium;
	
	public double getFlatRatePremium() {
		return flatRatePremium;
	}
	
	public void setFlatRatePremium(double newFlatRatePremium) {
		flatRatePremium = newFlatRatePremium;
	}
	
	public FlatRatePhone(String intCPhoneNumber, double intBaseRate) throws IOException {
		super(intCPhoneNumber, intBaseRate);
		flatRatePremium = Input.getDouble("Flat Rate Premium: ", 0.00, 100.00);
		double taxAmt = calcuTax();
		super.setTaxAmt(taxAmt);
	}
	
	/** to calculate the before-tax bill total */
	public double calcuBefTaxBill() {
		return super.getBaseRate() + flatRatePremium;
	}
	
	/** The tax calculation method */
	public double calcuTax() {
		return super.getHST() * calcuBefTaxBill();		
	}
	
	/** display of output */
	public String toString() {
		return "  Amt: $ " + (super.getBaseRate() + flatRatePremium) + "\n"
			 + "  Tax: $ " + super.getTaxAmt() + "\n"
			 + "  TOTAL: $ " + (calcuBefTaxBill() + super.getTaxAmt()) + "\n"
		     + "    FLAT RATE PLAN: Premium: "  + flatRatePremium;
	}
}
