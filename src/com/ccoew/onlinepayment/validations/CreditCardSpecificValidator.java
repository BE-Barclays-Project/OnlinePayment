package com.ccoew.onlinepayment.validations;

import java.util.logging.Logger;

import com.ccoew.onlinepayment.luhnalgorithm.LuhnAlgorithm;

public class CreditCardSpecificValidator {

	public static boolean isCreditCardNumberValid(String cardNumber) {
		Logger log=Logger.getAnonymousLogger();
//		if (checkCardValidity(cardNumber)) {
//			log.info("no. checked");
			return LuhnAlgorithm.isCheckDigitValid(cardNumber);
//		}
//		
//		return false;
	}

	private static boolean checkCardValidity(String cardNumber) {
		Logger log=Logger.getAnonymousLogger();
		System.out.println("isNull"+cardNumber);
		//if (!Validator.isNull(cardNumber)) {
			
			if (Validator.isValidNumber(cardNumber)) {
				if (!Validator.isAllZeros(cardNumber)) {
					
					return true;
				}
			//}
		}log.info("validator checked");
		return false;
	}

	public static boolean isCCVValid(String cardType, String ccv) {
		System.out.println(cardType+ccv);
		if ((cardType.equals("masterCard") || cardType.equals("visa")
				|| cardType.equals("discover") || cardType.equals("enroute") || cardType
					.equals("jcb")) && (ccv.length() == 3)) {
			Logger log=Logger.getAnonymousLogger();
			log.info("valid ccv");
			return true;
		}
		if (cardType.equals("amex") && ccv.length() == 4) {
			return true;
		}
		return false;
	}
}
