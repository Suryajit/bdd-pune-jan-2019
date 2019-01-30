Feature: Develop a REST API that supports training CRUD operations 

	Scenario: Should be able to add a new training record
		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		And the training field details are as below
			| id | name                 | duration |
		        | 1  | Machine Learning     | 5 Days   |
		When I invoke the REST API as POST method 
		Then I expect a status code "200"

	Scenario: Should be able to get all trainings

		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		When I invoke the REST API as GET method
		Then I expect a status code "200"
		And I expect the record count as non-zero 
		And I expect all the existing training records as response

	Scenario: Should be able to retrieve a single training based on its id

		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		When I invoke the REST API with id "1" as GET method
		Then I expect a status code "200"
		And I expect a single training record that matches id "1" as response

	Scenario: Check for non-existing training record

		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		When I invoke the REST API with id "4" as GET method
		Then I expect a status code "204"

	Scenario: Should be able to modify an existing training record

		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		And the training field details are as below
			| id | name | duration |
		        | 1  | "BDD"   | "3 days" |
		When I invoke the REST API as PUT method
		Then I expect a status code "200"


	Scenario: Should be able to delete an existing training record

		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		When I invoke the REST API with id "1" as DELETE method
		Then I expect a status code "200"
