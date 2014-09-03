package com.ccoew.onlinepayment.carduserdetails;

import com.ccoew.onlinepayment.validations.Validator;

public class ZipCode {
	private String zipCode;

	public static ZipCode zipCodeCreator(String zipCode) {
		ZipCode zipCode1 = new ZipCode(zipCode);
		if (zipCode1.isValid()) {
			System.out.println("It is valid zp..");
			return zipCode1;
		} else
			System.out.println("It is nt valid zp..");
			return null;
	}

	private ZipCode(String zipCode) {
		super();
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "ZipCode [zipCode=" + zipCode + "]";
	}

	public boolean isValid() {
		return ((Validator.isEqualLength(getZipCode(), 6)) && (Validator
				.isValidNumber(getZipCode())));
	}

}
