package com.ccoew.onlinepayment.carduserdetails;

import com.ccoew.onlinepayment.address.AppartmentName;
import com.ccoew.onlinepayment.address.City;
import com.ccoew.onlinepayment.address.PinCode;

public class Address {
	private int flatNo;
	private AppartmentName appartmentName;
	private String streetName;
	private City city;
	private PinCode pincode;

	public Address(int flatNo, AppartmentName appartmentName,
			String streetName, City city, PinCode pincode) {
		super();
		this.flatNo = flatNo;
		this.appartmentName = appartmentName;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public AppartmentName getAppartmentName() {
		return appartmentName;
	}

	public void setAppartmentName(AppartmentName appartmentName) {
		this.appartmentName = appartmentName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public PinCode getPincode() {
		return pincode;
	}

	public void setPincode(PinCode pincode) {
		this.pincode = pincode;
	}

	public String toString() {
		return " " + getFlatNo() + " " + getAppartmentName() + " "
				+ getStreetName() + " " + getCity() + "  " + getPincode();
	}
}
