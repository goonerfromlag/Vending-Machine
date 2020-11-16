package me.victor.vendingmachine;

public enum Coin {

	PENNY(1, "Penny"), NICKEL(5, "Nickel"), DIME(10, "Dime"), QUARTER(25, "Quarter");

	int value;

	String name;

	Coin(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getName();
	}

}
