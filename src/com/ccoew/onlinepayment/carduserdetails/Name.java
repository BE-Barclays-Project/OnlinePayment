package com.ccoew.onlinepayment.carduserdetails;

import com.ccoew.onlinepayment.validations.Validator;

public class Name {
	private String firstName;

	// private String middleName;
	// private String lastName;

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @return Name object if valid
	 */
	// public static Name nameCreater(String firstName, String middleName,
	// String lastName) {
	// Name name1 = new Name(firstName, middleName, lastName);
	// if (name1.isValide()) {
	// return name1;
	// } else {
	// return null;
	// }
	// }
	public static Name nameCreater(String firstName) {
		Name name1 = new Name(firstName);
		if (name1.isValide()) {
			return name1;
		} else {
			return null;
		}
	}

	private Name(String firstName) {
		super();

		this.firstName = firstName;
		// this.middleName = middleName;
		// this.lastName = lastName;
	}

	public String toString() {
		return " " + firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// public String getMiddleName() {
	// return middleName;
	// }
	//
	// public void setMiddleName(String middleName) {
	// this.middleName = middleName;
	// }
	//
	// public String getLastName() {
	// return lastName;
	// }
	//
	// public void setLastName(String lastName) {
	// this.lastName = lastName;
	// }

	/**
	 * @return true if name is valid
	 */
	public boolean isValide() {
		return ((Validator.isValidName(getFirstName())))
				&& (((Validator.isValideLength(getFirstName(), 50))));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());

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
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;

		return true;
	}
}
