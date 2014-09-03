package com.ccoew.onlinepayment.validations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean isValidName(String name) {
		char[] alphs = name.toCharArray();
		for (char ch : alphs) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		Logger log = Logger.getAnonymousLogger();
		log.info("valid name");
		return true;
	}

	public static boolean isValidNumber(String number) {
		char[] alphs = number.toCharArray();
		for (char kar : alphs) {
			if (!Character.isDigit(kar)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEqualLength(String name, int len) {
		if ((name.length() != len)) {
			return false;
		}
		return true;
	}

	public static boolean isValideLength(String name, int len) {
		if ((name.length() <= len)) {
			return true;
		}
		return false;
	}

	public static boolean isValideIntLength(int number, int length) {
		boolean result = false;
		switch (length) {
		case 1:
			result = number > 0 && number < 10;
			break;
		case 2:
			result = number > 9 && number < 100;
			break;
		case 3:
			result = number > 99 && number < 1000;
			break;
		case 4:
			result = number > 999 && number < 10000;
			break;
		case 5:
			result = number > 9999 && number < 100000;
			break;
		case 6:
			result = number > 99999 && number < 1000000;
			break;
		default:
			result = false;
			break;
		}
		return result;
	}

	public static boolean isValidContactNumber(String contactNumber, int length) {
		if (isValidNumber(contactNumber)) {
			if (isEqualLength(contactNumber, length))
				return true;
		}
		return false;
	}

	public static boolean isNull(String cardNumber) {
		if (cardNumber==null) {
			return true;
		}
		return false;
	}

	public static boolean isAllZeros(String number) {
		char[] alphs = number.toCharArray();
		for (char kar : alphs) {
			if (kar == '0') {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidEmail(String email) {
		// Pattern emailPattern = Pattern
		// .compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
		Pattern emailPattern = Pattern
				.compile(".+"+"@"+".+"+"."+".+");
		Matcher emailMatcher = emailPattern.matcher(email);
		return emailMatcher.matches();
	}

	public static boolean isValidCountry(String country) {
		final Set<String> ISO_Countries = new HashSet<String>(
				Arrays.asList(Locale.getISOCountries()));
		//System.out.println(ISO_Countries);
		return ISO_Countries.contains(country);

	}
}
