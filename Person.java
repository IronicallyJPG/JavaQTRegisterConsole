
package com.ironically.QTRegister;

import java.util.*;

public class Person {

	public double	Cash;
	public int		Mood;
	public double	change	= 0.0;

	public Person(double cash, int mood) {
		Cash = cash;
		Mood = mood;
	}

	public Person() {
		Random r = new Random();
		double x = (r.nextDouble() * 100);
		if (x > 90) {
			Cash = 100;
		}
		else if (x > 70) {
			Cash = 80;
		}
		else if (x > 50) {
			Cash = 60;
		}
		else if (x > 30) {
			Cash = 40;
		}
		else if (x > 10) {
			Cash = 80;
		}
		else {
			Cash = Math.floor(x * 100) / 100;
		}
		// ========================
		Mood = r.nextInt(10);
	}

	@Override
	public String toString() {
		return Cash + "<-->" + Mood;
	}

	public static void Secret(String secret) {

	}

}
