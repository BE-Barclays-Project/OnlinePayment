package com.ccoew.onlinepayment.carduserdetails;

import com.ccoew.onlinepayment.validations.Validator;

public class EmailAddress {
	private String emailAddress;

	public static EmailAddress emailAddressCreator(String emailAddress) {
		EmailAddress emailAddress1 = new EmailAddress(emailAddress);
		if (emailAddress1.isValid()) {
			System.out.println("It is valid email..");
			return emailAddress1;
		} else {
			System.out.println("It is not valid email..");
			return null;
		}
	}

	private EmailAddress(String emailAddress) {
		super();
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return  emailAddress ;
	}

	public boolean isValid() {
		return Validator.isValidEmail(getEmailAddress());
	}

}
