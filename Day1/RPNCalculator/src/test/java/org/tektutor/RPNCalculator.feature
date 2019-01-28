Feature: Develop a RPNCalculator application that takes math expressions in postix notation, evaluates
	 and gives out the result.

	Scenario Outline: I should be able to perform simple addition.
		 
		Given the rpn math expression is <rpnMathExpression> 
		When I invoke the evaluate method
		Then I expect the result to be <expectedOutput>

		Examples:
			| rpnMathExpression | expectedOutput |
			| "10 15 +"         | "25.0"         |
		        | "85 15 +"         | "100.0"        |
		        | "75 35 +"         | "110.0"        |

	Scenario Outline: I should be able to perform simple subtraction.
		 
		Given the rpn math expression is <rpnMathExpression> 
		When I invoke the evaluate method
		Then I expect the result to be <expectedOutput>

		Examples:
			| rpnMathExpression | expectedOutput |
			| "100 15 -"        | "85.0"         |
		        | "85 15 -"         | "70.0"         |
		        | "75 35 -"         | "40.0"         |

	Scenario Outline: I should be able to perform simple multiplication.
		 
		Given the rpn math expression is <rpnMathExpression> 
		When I invoke the evaluate method
		Then I expect the result to be <expectedOutput>

		Examples:
			| rpnMathExpression | expectedOutput |
			| "100 10 *"        | "1000.0"       |
		        | "85 10 *"         | "850.0"        |
		        | "75 10 *"         | "750.0"        |

	Scenario Outline: I should be able to perform simple division.
		 
		Given the rpn math expression is <rpnMathExpression> 
		When I invoke the evaluate method
		Then I expect the result to be <expectedOutput>

		Examples:
			| rpnMathExpression | expectedOutput |
			| "100 10 /"        | "10.0"         |
		        | "85 10 /"         | "8.5"          |
		        | "75 10 /"         | "7.5"          |

	Scenario: I should be able to perform complex expression.
		 
		Given the rpn math expression is "15 7 1 1 + - / 3 * 2 1 1 + + -" 
		When I invoke the evaluate method
		Then I expect the result to be "5.0" 
