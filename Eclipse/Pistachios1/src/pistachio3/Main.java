package pistachio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner potato = new Scanner(System.in);

		System.out.println("What month were you born in?(number)");
		int month = potato.nextInt();

		System.out.println("What day (number)");
		int day = potato.nextInt();

		String[] days = {"first", "second", "third", "fourth", "fifth",
				"sixth", "seventh", "eighth", "ninth", "tenth", "eleventh",
				"twelfth", "thirteenth", "fourteenth", "fifteenth",
				"sixteenth", "seventeenth", "eighteenth", "ninteenth",
				"twentieth", "twenty-first", "twenty-second", "twenty-third",
				"twenty-fourth", "twenty-fifth", "twenty-sixth",
				"twenty-seventh", "twenty-eighth", "twenty-ninth", "thirtieth",
				"thirty-first"};
		String[] months = {"January", "February", "March", "April", "May",
				"June", "July", "August", "Sepetmber", "October", "November",
				"December"};

		if (month >= 1 && month <= 12) {
			
		}

	}

}
