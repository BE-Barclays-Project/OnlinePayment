package com.ccoew.onlinepayment.carduserdetails;

import com.ccoew.onlinepayment.validations.Validator;

public class ContactNumber {
	private String contactNumber;

	public static ContactNumber contactNumberCreator(String contactNumber) {
		ContactNumber contactNumber1 = new ContactNumber(contactNumber);
		if (contactNumber1.isValid()) {
			System.out.println("it is valid cn");
			return contactNumber1;
		} else {
			System.out.println("it is not  valid cn");
			return null;
		}

	}

	private ContactNumber(String contactNumber) {
		super();
		this.contactNumber = contactNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return contactNumber;
	}

	public boolean isValid() {
		return (Validator.isValidContactNumber(getContactNumber(), 10));
	}
}
