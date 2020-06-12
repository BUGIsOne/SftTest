package TelFee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PhoneCompany {
	private static BufferedReader stdIn = new BufferedReader(
			new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private ArrayList<Customer> customers;

	public static void main(String[] args) throws IOException {
		PhoneCompany ph = new PhoneCompany();
		ph.run();
	}

	/**
	 * Constructor
	 */
	public PhoneCompany() {
		customers = new ArrayList<Customer>();
	}

	/** Accessory methods */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * Presents the user with a menu of options and executes the selected task.
	 */
	private void run() throws IOException {

		int choice = getChoice();

		while (choice != 0) {

			if (choice == 1) {
				/** Add Customer */
				addCustomer();
			} else if (choice == 2) {
				/** Display Customer Bill */
				calcBills();
			}
			choice = getChoice();
		}
	}

	/**
	 * Displays a menu of options and verifies the user's choice.
	 * 
	 * @return an integer in the range [0,2]
	 */
	private int getChoice() throws IOException {

		int input;

		do {
			try {
				stdOut.println();
				stdOut.print("[1]  Add Customer\n"
						+ "[2]  Display Customer Bills\n" + "[0]  Quit\n\n"
						+ "Enter Choice: ");
				stdOut.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdOut.println();

				if (0 <= input && 2 >= input) {
					break;
				} else {
					stdErr.print("Invalid choice:  " + input);
					stdOut.flush();
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	public void addCustomer() throws IOException {
		Customer customer = new Customer();
		customers.add(customer);
	}


	public void calcBills() {
		double total = 0.00;
		stdOut.println();
		stdOut.print("AirHead Phone Company\n");
		for (Customer customer : customers) {
			stdOut.println(customer.toString());
			stdOut.println((customer.getCPhone()).toString());
			total = total + customer.getCPhone().calcuBefTaxBill()
					+ customer.getCPhone().getTaxAmt();
		}
		stdOut.println("TOTAL: " + total);
	}
}
