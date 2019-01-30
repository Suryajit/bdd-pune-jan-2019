Feature: Develop a REST API that supports training CRUD operations 

	Scenario: Should be able to get all trainings

		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		When I invoke the REST API
		Then I expect a status code "200"
		And I expect all the existing training records as response

	Scenario: Should be able to retrieve a single training based on its id

		Given the Training REST API is hosted at endpoint "http://localhost:8080/tektutor-training-api-1.0.0/rest/training"
		When I invoke the REST API with id "1"
		Then I expect a status code "200"
		And I expect a single training record that matches id "1" as response
