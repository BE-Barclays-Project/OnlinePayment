package com.ccoew.onlinepayment.carduserdetails;

import com.ccoew.onlinepayment.validations.Validator;

public class Country {
	private String counrty;

	public static Country countryCreator(String counrty) {
		Country country1 = new Country(counrty);
		if (country1.isValid()) {
			System.out.println("it is valid");
			return country1;
		} else {
			System.out.println("it is not valid");
			return null;
		}
	}

	private Country(String counrty) {
		super();
		this.counrty = counrty;
	}

	public String getCounrty() {
		return counrty;
	}

	public void setCounrty(String counrty) {
		this.counrty = counrty;
	}

	@Override
	public String toString() {
		return "Country [counrty=" + counrty + "]";
	}

	public boolean isValid() {
		return (Validator.isValidName(getCounrty()) && Validator
				.isValidCountry(getCounrty()));
	}
}
