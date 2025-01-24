@StudentsApi
Feature: Test All Students endpoints

  Background: 
    * configure base uri

  Scenario: create new students
    Given get request specification object
    And attach "POST" request payload from students Payload json file
    When create new students using post request
    Then capture students id number from response payload
    And get the validatable response object
    And validate status code 201
    And validate status line "Created"
    And validate response time should below 5000 milliseconds
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And generate response logs
