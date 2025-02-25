package com.ems.EMS.model;

public class Address {
	
	private String street;
	private String city;
	private String State;
	private String zipcode;
	public String getStreet() {
		return street;
	}
	
	 public Address() {
	    }
	 
	public Address(String street, String city, String state, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		State = state;
		this.zipcode = zipcode;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", State=" + State + ", zipcode=" + zipcode + "]";
	}
	

}

