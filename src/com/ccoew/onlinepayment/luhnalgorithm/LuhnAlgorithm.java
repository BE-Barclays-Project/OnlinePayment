package com.ccoew.onlinepayment.luhnalgorithm;

public class LuhnAlgorithm {

	private static char[] doubleAlternateDigit(String cardNumber) {
		char[] digits = cardNumber.toCharArray();
		for (int i = digits.length - 1; i >= 0; i = i - 2) {
			int oddPlaceNumber = (int) (digits[i] - 48);
			int singleDigit = getSingleDigit(oddPlaceNumber * 2);
			digits[i] = (char) (singleDigit + 48);
		}
		return digits;
	}

	private static int calculateSum(String cardNumber) {
		char[] digits = doubleAlternateDigit(cardNumber);
		//System.out.println(digits);
		int sum = 0;
		for (char kar : digits) {
			int number = (int) (kar - 48);
			sum = sum + number;
		}
		return sum;
	}

	private static int getCheckDigit(String cardNumber) {
		int sum = calculateSum(cardNumber);
		//System.out.println("sum=" + " " + sum);
		int unitPlace = (sum % 10);
		int checkDigit = 10 - unitPlace;
		return checkDigit;
	}

	private static int getSingleDigit(int oddPlaceNumber) {
		int quotient = (oddPlaceNumber / 10);
		int remainder = (oddPlaceNumber % 10);
		return (remainder + quotient);
	}

	public static boolean isCheckDigitValid(String cardNumber) {

		int checkDigit = getCheckDigit(cardNumber.substring(0,
				cardNumber.length() - 1));
		//System.out.println("CD" + " " + checkDigit);
		int lastDigit = (int) (cardNumber.charAt(cardNumber.length() - 1) - 48);
		//System.out.println("LD" + " " + lastDigit);
		if (checkDigit == lastDigit) {
			return true;
		}
		return false;
	}

}
