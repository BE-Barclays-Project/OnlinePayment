package com.ccoew.onlinepayment.authenticateuser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.ccoew.onlinepayment.creditcard.CreditCard;
import com.ccoew.onlinepayment.datatransfer.client.ExcelToCollectionTransferClient;
import com.ccoew.onlinepayment.dateenum.Month;

public class AuthenticateUser {

	public static boolean authenticate(CreditCard creditCard, double payment)
			throws ClassNotFoundException, IOException {

		ExcelToCollectionTransferClient.transferData();
		Logger log = Logger.getAnonymousLogger();
		if (isCreditCardUserValid(creditCard.getCardNumber(),
				creditCard.getCardHolder())
				&& doesCCVMatch(creditCard.getCardNumber(), creditCard.getCcv())

				&& isExpiryValid(creditCard.getCardNumber(),
						creditCard.getExpMonth(), creditCard.getExpYear())

				&& isBalanceValid(creditCard.getCardNumber(), payment)) {
			log.info("user authenticated");
			return true;
		}
		log.info("user not authenticated");
		return false;
	}

	private static boolean isExpiryValid(String cardNumber, String expMonth,
	 String expYear) {
		 Map<String, Integer> months=
		 months
	 String expM=expMonth.toUpperCase();
	 if (Integer.parseInt(ExcelToCollectionTransferClient.getCreditCardUsers()
	 .get(cardNumber).getExpYear())>=Integer.parseInt(expYear) && Month.
	
	 ){
	 return true;
	 }
	 return false;
	 }

	private static boolean doesCCVMatch(String cardNumber, String ccv) {
		if (ExcelToCollectionTransferClient.getCreditCardUsers()
				.get(cardNumber).getCcv().equals(ccv)) {
			return true;
		}
		return false;
	}

	private static boolean isCreditCardUserValid(String cardNumber,
			String cardHolder) {
		if (ExcelToCollectionTransferClient.getCreditCardUsers()
				.get(cardNumber).getCardHolder().equals(cardHolder)) {
			return true;
		}
		return false;
	}

	private static boolean isBalanceValid(String cardNumber, double payment) {
		if (ExcelToCollectionTransferClient.getCreditCardUsers()
				.get(cardNumber).getBalance() >= payment) {
			return true;
		}
		return false;
	}

}
