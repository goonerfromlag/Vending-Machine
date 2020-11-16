package me.victor.vendingmachine;

public enum Drink {

	COKE(25, "Coke"), PEPSI(35, "Pepsi"), SODA(45, "Soda");

	int price;

	String name;

	Drink(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return getName();
	}

}
