package TelFee;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;


public class TestPhoneCompany {
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	public static void assertTrue(String message, boolean condition) {
		if (!condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);
		}
	}

	public static void main(String[] args) throws IOException {
		PhoneCompany ph = new PhoneCompany();
		assertTrue("1: testing constructor and accessor", 
				ph.getCustomers().size() == 0);

		ph.addCustomer();
		assertTrue("2: testing addCustomer", ph.getCustomers().size() == 1);
		assertTrue("3: testing addCustomer", (ph.getCustomers().get(0)
				.getName().equals("Bill Jones")));
		assertTrue("4: testing addCustomer", (ph.getCustomers().get(0)
				.getCPhone().getPhoneNumber().equals("613-111-1111")));
		assertTrue("5: testing addCustomer", (ph.getCustomers().get(0)
				.getCPhone().getBaseRate() == 29.00));
		assertTrue("6: testing addCustomer", (ph.getCustomers().get(0)
				.getCPhone().getTaxAmt() == 5.07));
		assertTrue("7: testing addCustomer", (ph.getCustomers().get(0)
				.getCPhone().calcuBefTaxBill() + ph.getCustomers().get(0)
				.getCPhone().getTaxAmt() == 44.07));
		
		/**
		 * Testing method addCustomer(), the customer infor as followings: 
		 * Jill Wilson
		 * 819-222-2222 
		 * Base Rate: 25.00 
		 * Minutes Used: 300
		 */
		ph.addCustomer();
		assertTrue("8: testing addCustomer", ph.getCustomers().size() == 2);
		assertTrue("9: testing addCustomer", (ph.getCustomers().get(1)
				.getName().equals("Jill Wilson")));
		assertTrue("10: testing addCustomer", (ph.getCustomers().get(1)
				.getCPhone().getPhoneNumber().equals("819-222-2222")));
		assertTrue("11: testing addCustomer", (ph.getCustomers().get(1)
				.getCPhone().getBaseRate() == 25.00));
		assertTrue("12: testing addCustomer", (ph.getCustomers().get(1)
				.getCPhone().getTaxAmt() == 13.00));
		assertTrue("13: testing addCustomer", (ph.getCustomers().get(1)
				.getCPhone().calcuBefTaxBill() + ph.getCustomers().get(1)
				.getCPhone().getTaxAmt() == 113.00));
		
		stdOut.println("Done!");
	}
}

