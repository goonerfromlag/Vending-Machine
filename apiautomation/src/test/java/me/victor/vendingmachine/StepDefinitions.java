package me.victor.vendingmachine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import java.util.Objects;

import static me.victor.vendingmachine.Coin.*;
import static me.victor.vendingmachine.Drink.*;

public class StepDefinitions {

	private VendingMachine machine;
	private boolean isDrinkGiven;


	@Given("A vending machine")
	public void the_vending_machine() {
		if (Objects.isNull(machine)) {
			machine = new VendingMachine();
		}
	}

	@Given("A vending machine with a balance of {int}")
	public void the_vending_machine_with_balance(int balance) {
		the_vending_machine();
		machine.setBalance(balance);
	}

	@When("I reset the machine")
	public void i_reset_the_machine() {
		machine.reset();
	}

	@When("I insert a {string}")
	public void i_insert_a_coin(String coin) {
		switch (coin.toLowerCase()) {
			case "penny" :
				i_insert_penny();
				break;
			case "nickel" :
				i_insert_nickel();
				break;
			case "dime" :
				i_insert_dime();
				break;
			case "quarter" :
				i_insert_quarter();
				break;
			default :
				System.out.println(coin + " is an invalid coin type");
		}

	}

	private void i_insert_penny() {
		machine.insertCoin(PENNY);
	}
	    
	private void i_insert_dime() {
		machine.insertCoin(DIME);
	}

	private void i_insert_nickel() {
		machine.insertCoin(NICKEL);
	}

	private void i_insert_quarter() {
		machine.insertCoin(QUARTER);
	}

	@Then("My balance should be {int}")
	public void my_balance_should_be(int amount) {
		assertEquals(amount, machine.getBalance());
	}

	@When("I select a drink of {string}")
	public void i_select_a_drink(String drink) {
		switch (drink.toLowerCase()) {
			case "coke" :
				i_select_coke();
				break;
			case "pepsi" :
				i_select_pepsi();
				break;
			case "soda" :
				i_select_soda();
				break;
			default :
				System.out.println(drink + " is an invalid drink choice");
		}

	}

	private void i_select_coke() {
		machine.select(COKE);
	}

	private void i_select_pepsi() {
		machine.select(PEPSI);
	}

	private void i_select_soda() {
		machine.select(SODA);
	}

	@Then("I should get the drink")
	public void i_should_get_the_drink() {
		isDrinkGiven = machine.giveOutDrink();
	}

	@When("I cancel the request")
	public void i_cancel_the_request() {
		machine.cancel();
	}

	@Then("My selection is refused")
	public void my_selection_is_refused() {
		assertFalse(isDrinkGiven);
	}

	@Then("I should get a refund of {int}")
	public void i_should_get_refund(int amount) {
		i_should_get_change(amount);
	}
	
	@Then("I should get change of {int}")
	public void i_should_get_change(int amount) {
		assertEquals(amount, machine.getBalance());
		machine.change();
		assertEquals(0, machine.getBalance());
	}

}
