package com.example.transactions.SpringTransaction;

public class Address {

	private String addressLine;

	public Address(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getAddressLine() {
		return addressLine;
	}

	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + "]";
	}

}
