package com.ccoew.onlinepayment.address;

import com.ccoew.onlinepayment.validations.Validator;

public class PinCode {
	private int pincode;

	/**
	 * @param pinCode
	 * @return pincode object if valid
	 */
	public static PinCode Creater(int pinCode) {
		PinCode pin = new PinCode(pinCode);
		if (pin.isValide()) {
			return pin;
		} else {
			return null;
		}
	}

	private PinCode(int pincode) {
		super();
		this.pincode = pincode;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public boolean isValide() {
		return (Validator.isValideIntLength(getPincode(), 6));
	}

	public String toString() {
		return "" + getPincode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pincode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PinCode other = (PinCode) obj;
		if (pincode != other.pincode)
			return false;
		return true;
	}

}
