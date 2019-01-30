Feature: Demonstrates the use of Background in Cucucumber

	 When there are many repeatitive steps that are required for many scenario, the
	 Background comes in handy.

	 Background:
		Given first step 
		Given second step 

	 Scenario: First test scenario
		Given third step 
		When  fourth step 
		Then  fifth step 

	 Scenario: Second test scenario
		Given sixth step 
		When  seventh step 
		Then  eighth step 

	 Scenario: Third test scenario
		Given ninth step 
		When  tenth step 
		Then  eleventh step 
