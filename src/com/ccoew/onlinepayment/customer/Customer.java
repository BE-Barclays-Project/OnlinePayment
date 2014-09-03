package com.ccoew.onlinepayment.customer;

import com.ccoew.onlinepayment.carduserdetails.Address;
import com.ccoew.onlinepayment.carduserdetails.ContactNumber;
import com.ccoew.onlinepayment.carduserdetails.Country;
import com.ccoew.onlinepayment.carduserdetails.EmailAddress;
import com.ccoew.onlinepayment.carduserdetails.Name;
import com.ccoew.onlinepayment.carduserdetails.State;

public class Customer {
	private Name name;
	private EmailAddress emailAddress;
	private int flatNo;
	private Address address;
	private String streetName;
	private State state;
	private Country country;
	private ContactNumber contactNumber;
	private double payment;

	public Customer(Name name, EmailAddress emailAddress, int flatNo,
			Address address, String streetName, State state, Country country,
			ContactNumber contactNumber, double payment) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.flatNo = flatNo;
		this.address = address;
		this.streetName = streetName;
		this.state = state;
		this.country = country;
		this.contactNumber = contactNumber;
		this.payment=payment;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public ContactNumber getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(ContactNumber contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", emailAddress=" + emailAddress
				+ ", address=" + address + ", state=" + state + ", country="
				+ country + ", contactNumber=" + contactNumber + "]";
	}

}
