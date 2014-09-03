package com.ccoew.onlinepayment.creditcard;

import com.ccoew.onlinepayment.validations.Validator;

public class CreditCard {
	private String cardType;
	private String cardNumber;
	private String ccv;
	private String cardHolder;
	private String expMonth;
	private String expYear;
	private double balance;

	public CreditCard(String cardNumber, String ccv, String cardHolder,
			String expMonth, String expYear, double balance) {
		this.cardType = getCardType(cardNumber);
		this.cardNumber = cardNumber;
		this.ccv = ccv;
		this.cardHolder = cardHolder;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.balance = balance;
	}

	public CreditCard(String cardNumber, String ccv, String cardHolder,
			String expMonth, String expYear) {
		this.cardType = getCardType(cardNumber);
		this.cardNumber = cardNumber;
		this.ccv = ccv;
		this.cardHolder = cardHolder;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}

	private static String getCardType(String cardNumber) {

		if (Validator.isEqualLength(cardNumber, 16)
				|| Validator.isEqualLength(cardNumber, 13)) {
			if (cardNumber.startsWith("4")) {
				String visa = "visa";
				return visa;
			}
		}
		if (Validator.isEqualLength(cardNumber, 16)) {
			if (cardNumber.startsWith("5")) {
				if (cardNumber.charAt(1) <= '5' && cardNumber.charAt(1) >= '1') {
					String masterCard = "masterCard";
					return masterCard;
				}
			}
		}
		if (Validator.isEqualLength(cardNumber, 15)) {
			if (cardNumber.startsWith("34") || cardNumber.startsWith("37")) {
				String amex = "amex";
				return amex;
			}
		}
		if (Validator.isEqualLength(cardNumber, 16)) {
			if (cardNumber.startsWith("6011")) {
				String discover = "discover";
				return discover;
			}
		}
		if (Validator.isEqualLength(cardNumber, 15)) {
			if (cardNumber.startsWith("2014") || cardNumber.startsWith("2149")) {
				String enroute = "enroute";
				return enroute;
			}
		}
		if (Validator.isEqualLength(cardNumber, 16)) {
			if (cardNumber.startsWith("3088") || cardNumber.startsWith("3096")
					|| cardNumber.startsWith("3112")
					|| cardNumber.startsWith("3158")
					|| cardNumber.startsWith("3337")
					|| cardNumber.startsWith("3528")) {
				String jcb = "jcb";
				return jcb;
			}
		}
		return null;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getCcv() {
		return ccv;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	@Override
	public String toString() {
		return "CreditCard [cardType=" + cardType + ", cardNumber="
				+ cardNumber + ", ccv=" + ccv + ", cardHolder=" + cardHolder
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + "]";
	}

}
