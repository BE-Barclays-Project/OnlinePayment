package com.ccoew.onlinepayment.address;

import com.ccoew.onlinepayment.validations.Validator;

public class City {
	private String city;

	public static City CreaterC(String city) {
		City city1 = new City(city);
		if (city1.isValideCity()) {
			return city1;
		} else {
			return null;
		}
	}

	private City(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return "" + getCity();
	}

	public boolean isValideCity() {
		return (Validator.isValidName(getCity()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
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
		City other = (City) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}
}
