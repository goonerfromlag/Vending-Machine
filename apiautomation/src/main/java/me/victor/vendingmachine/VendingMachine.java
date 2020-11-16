package me.victor.vendingmachine;

public final class VendingMachine {
	
	private int balance;

	private Drink cursor;
	
	/*
	 * select product
	 * take refund
	 * return selected product and remaining change
	 * reset
	 */
	
	public void select(Drink drink) {
		cursor = drink;
		System.out.println("Selected " + drink);
	}
	
	public boolean giveOutDrink() {
		if(cursor.getPrice() <= balance) {
			System.out.println("Selected drink (" + cursor + ") is given");
			balance -= cursor.getPrice();
			return true;
		}
		System.out.println("Insufficient funds. No drink was given");
		return false;
	}
	
	public void printBalance() {
		System.out.println("Balance: " + getBalance());
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void insertCoin(Coin coin) {
		System.out.println("Inserted coin: " + coin);
		balance = balance + coin.getValue();
		System.out.println("Current balance: " + balance);
	}
	
	public void cancel() {
		cursor = null;
		System.out.println("The request is cancelled");
	}
	
	public void reset() {
		balance = 0;
		cursor = null;
		System.out.println("Machine is reset");
	}
	
	public void change() {
		System.out.println(balance + " is given as change");
		balance = 0;
	}

}
