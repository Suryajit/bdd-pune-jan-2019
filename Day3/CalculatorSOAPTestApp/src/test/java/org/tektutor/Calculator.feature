Feature: Develop a Calculator SOAP API

	Scenario: Should be able to add two numbers

		Given the first input is "10"
		And the second input is "20"
		When I invoke the add API
		Then I expect the result "30"
