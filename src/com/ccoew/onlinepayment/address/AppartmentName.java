package com.ccoew.onlinepayment.address;

import com.ccoew.onlinepayment.validations.Validator;

public class AppartmentName {
	private String appartmentName;

	public static AppartmentName Creater(String appartmentName) {
		AppartmentName appartment = new AppartmentName(appartmentName);
		if (appartment.isValide()) {
			return appartment;
		} else {
			return null;
		}
	}

	private AppartmentName(String appartmentName) {
		super();
		this.appartmentName = appartmentName;
	}

	public String getAppartmentName() {
		return appartmentName;
	}

	public void setAppartmentName(String appartmentName) {
		this.appartmentName = appartmentName;
	}

	public boolean isValide() {
		return (Validator.isValidName(getAppartmentName()));
	}

	public String toString() {
		return "" + getAppartmentName();
	}
}
