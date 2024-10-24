Feature: Adding new device

 Scenario: Successfully added new device
 	When  adding a new device with name "Apple Max Pro 1TB", year 2023, price 7999.99, CPU model "Apple ARM A7", and hard disk size "1 TB" 
 	Then response should contain creation date and valid ID
 	And added device details should match the information given