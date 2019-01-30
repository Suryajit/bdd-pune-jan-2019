package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

public class Steps {

	@Given("first step")
	public void first_step() {
		System.out.println ( "First step" );
	}

	@Given("second step")
	public void second_step() {
		System.out.println ( "Second step" );
	}

	@Given("third step")
	public void third_step() {
		System.out.println ( "Third step" );
	}

	@When("fourth step")
	public void fourth_step() {
		System.out.println ( "Fourth step" );
	}

	@Then("fifth step")
	public void fifth_step() {
		System.out.println ( "Fifth step" );
	}

	@Given("sixth step")
	public void sixth_step() {
		System.out.println ( "Sixth step" );
	}

	@When("seventh step")
	public void seventh_step() {
		System.out.println ( "Seventh step" );
	}

	@Then("eighth step")
	public void eighth_step() {
		System.out.println ( "Eighth step" );
	}

	@Given("ninth step")
	public void ninth_step() {
		System.out.println ( "Ninth step" );
	}

	@When("tenth step")
	public void tenth_step() {
		System.out.println ( "Tenth step" );
	}

	@Then("eleventh step")
	public void eleventh_step() {
		System.out.println ( "Eleventh step" );
	}
}
