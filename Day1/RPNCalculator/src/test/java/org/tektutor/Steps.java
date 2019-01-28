package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

import static org.junit.Assert.*;

public class Steps {

	private String rpnMathExpression;
	private RPNCalculator rpnCalculator;
	private double expectedResult, actualResult;

	@Given("the rpn math expression is {string}")
	public void the_rpn_math_expression_is(String rpnMathExpression) {
		this.rpnMathExpression = rpnMathExpression;
	}

	@When("I invoke the evaluate method")
	public void i_invoke_the_evaluate_method() {
		rpnCalculator = new RPNCalculator();
		actualResult  = rpnCalculator.evaluate ( rpnMathExpression );
	}

	@Then("I expect the result to be {string}")
	public void i_expect_the_result_to_be(String strExpectedResult) {
		expectedResult = Double.parseDouble ( strExpectedResult );

		assertEquals ( expectedResult, actualResult, 0.0001 );
	}

}
