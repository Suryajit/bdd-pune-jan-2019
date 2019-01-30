package org.tektutor;

import cucumber.api.java.en.*;
import static org.junit.Assert.*;

import org.tempuri.*;

public class Steps {

	private Calculator calculator;
	private CalculatorSoap calculatorSoap;
	private int firstNumber, secondNumber, actualResult, expectedResult;

	@Given("the first input is {string}")
	public void the_first_input_is(String strFirstInput) {
		this.firstNumber = Integer.parseInt( strFirstInput );
	}

	@Given("the second input is {string}")
	public void the_second_input_is(String strSecondInput) {
		this.secondNumber = Integer.parseInt( strSecondInput );
	}

	@When("I invoke the add API")
	public void i_invoke_the_add_API() {
		calculator = new Calculator();
		calculatorSoap = calculator.getCalculatorSoap();

		this.actualResult = calculatorSoap.add ( this.firstNumber, this.secondNumber );
	}

	@Then("I expect the result {string}")
	public void i_expect_the_result(String strExpectedResult) {
		this.expectedResult = Integer.parseInt ( strExpectedResult );
		assertEquals ( this.expectedResult, this.actualResult );
	}

}
