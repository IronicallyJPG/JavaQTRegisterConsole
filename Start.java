
package com.ironically.QTRegister;

import java.math.*;
import java.util.*;

import main.*;

public class Start {
	// ===============================================
	// The Beginning of the QT_Register Program
	public static void main(String[] args) {
		LL.console("Welcome to QuikTrip Register!");
		ArrayList<Person> people = new ArrayList<Person>();
		while (true) {
			String x = LL.askQuestion("Amount of Problems? ");
			if (x.equals("exit")) break;
			try {
				int t = Integer.parseInt(x);
				for (int i = 0; i < t; i++) {
					people.add(new Person());
				}
				Begin(people);
				break;
			}
			catch (Exception e) {}
		}

	}

	// ===============================================
	// Begins The Loop of asking problems
	private static void Begin(ArrayList<Person> peeps) {
		String secret = LL.askQuestion("Press Enter to begin....");
		Person.Secret(secret);
		long starttime = System.currentTimeMillis();
		for (Person x : peeps) {
			Problem(x);
		}
		long endtime = System.currentTimeMillis();
		long diff = endtime - starttime;
		long avg = diff / peeps.size();
		LL.console(">>==========================<<");
		LL.console("TIME > " + (diff / 1000) + "." + (diff % 1000) + " Seconds");
		if (peeps.size() > 1) LL.console("Average > " + LL.ConvertMillisToString(avg) + " Per Problem!");

	}

	// ===============================================
	// The actual Code that creates, and runs through a problem.
	private static void Problem(Person x) {
		// == Random Math determines Total
		BigDecimal Total = BigDecimal
				.valueOf((Math.floor((((Math.random() * ((x.Cash - 0.1) + 1)) + 0.1)) * 100)) / 100);
		// == Calculates the Change Before Hand.
		BigDecimal change = new BigDecimal(x.Cash + "").subtract(new BigDecimal(Total + ""));;
		if (change.doubleValue() < 0.00) {
			while (change.doubleValue() < 0.00) {
				// == Random Math determines Total
				Total = BigDecimal.valueOf((Math.floor((((Math.random() * ((x.Cash - 0.1) + 1)) + 0.1)) * 100)) / 100);
				// == Calculates the Change Before Hand.
				change = new BigDecimal(x.Cash + "").subtract(new BigDecimal(Total + ""));;
			}
		}
		LL.console("<<============================>>");
		LL.console("TOTAL\t\t: " + Total);
		LL.console("CASH GIVEN\t: " + x.Cash);
		while (true) {
			String f = LL.askQuestion("Change? ");
			if (f.toLowerCase().equals("cheat")) {
				LL.console(change);
			}
			else {
				try {
					BigDecimal inp = BigDecimal.valueOf(Double.valueOf(f));
					if ((inp + "").equals(change + "")) {
						break;
					}
					else {
						LL.console("WRONG!");
					}
				}
				catch (Exception e) {}
			}

		}
	}
}
