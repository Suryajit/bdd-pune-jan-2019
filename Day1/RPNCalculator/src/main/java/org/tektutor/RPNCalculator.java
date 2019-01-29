package org.tektutor;

import java.util.Stack;

public class RPNCalculator {

	private Stack<Double> numberStack;
	private double firstNumber, secondNumber, result;

	public RPNCalculator() {
		numberStack = new Stack<Double>();
		firstNumber = secondNumber = result = 0.0;
	}

	private void retrieveOperands() {
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
	}

/** 
 * These are dead code now - feel free to delete them. 
 * I left them commented just for your reference
 *
	private void add() {
		retrieveOperands();
		result = firstNumber + secondNumber;
		numberStack.push ( result );
	}

	private void subtract() {
		retrieveOperands();
		result = firstNumber - secondNumber;
		numberStack.push ( result );
	}

	private void multiply() {
		retrieveOperands();
		result = firstNumber * secondNumber;
		numberStack.push ( result );
	}

	private void divide() {
		retrieveOperands();
		result = firstNumber / secondNumber;
		numberStack.push ( result );
	}

**/

	private boolean isMathOperator( String token ) {
		String strMathOperators = "+-*/";
		return strMathOperators.contains ( token );
	}

	public double evaluate ( String rpnMathExpression ) {

		String[] rpnTokens = rpnMathExpression.split ( " " );

		MathOperation mathOperation = null;

		for ( String token : rpnTokens ) {
			if ( isMathOperator ( token ) ) {
				retrieveOperands();

				mathOperation = MathFactory.getMathObject ( token );
				result = mathOperation.evaluate ( firstNumber, secondNumber ); 

				numberStack.push ( result );
			}
			else {
				numberStack.push ( Double.parseDouble ( token ) );
			}
		}

		return numberStack.pop();
	
	}

}
