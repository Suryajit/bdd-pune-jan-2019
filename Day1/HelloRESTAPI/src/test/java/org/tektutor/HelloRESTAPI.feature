Feature: Develop a simple Hello REST API

	Scenario: Invoke Hello REST API - Positive use case
		Given the Hello REST API is alive
		When I invoke the Hello REST API endpoint "http://localhost:8080/tektutor-hellorest-api-1.0.0/rest/hello/sayhello"
		Then I expect "Hello REST API" response message
