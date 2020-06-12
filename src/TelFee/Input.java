package TelFee;

import java.io.*;

public class Input {
	private static BufferedReader stdIn = new BufferedReader(
			new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	public static int getInt(String prompt) throws IOException {
		do {
			try {
				stdOut.print(prompt);
				stdOut.flush();
				int temp = Integer.parseInt(stdIn.readLine());
				return temp;
			} catch (NumberFormatException nfe) {
				stdErr.print("Invalid number format");
				stdErr.flush();
			}
		} while (true);
	}

	public static int getInt(String prompt, int low, int high) throws IOException {
		do {
			try {
				stdOut.print(prompt);
				stdOut.flush();
				int temp = Integer.parseInt(stdIn.readLine());
				if (temp >= low && temp <= high) {
					return temp;
				}
			} catch (NumberFormatException nfe) {
				stdErr.print("Invalid number format");
				stdErr.flush();
			}
		} while (true);
	}

	public static double getDouble(String prompt, double low, double high) throws IOException {
		do {
			try {
				stdOut.print(prompt);
				stdOut.flush();
				double temp = Double.parseDouble(stdIn.readLine());
				if (temp >= low && temp <= high) {
					return temp;
				}
			} catch (NumberFormatException nfe) {
				stdErr.print("Invalid number format");
				stdErr.flush();
			}
		} while (true);
	}

	public static String getString(String prompt) throws IOException {
		do {
			stdOut.print(prompt);
			stdOut.flush();
			String temp = stdIn.readLine();
			return temp;
		} while (true);
	}
}
