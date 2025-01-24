@PersonalsApi
Feature: Test All Personals endpoints

  Background: 
    * configure base uri

  Scenario: create new personals
    Given get request specification object
    And attach "POST" request payload from personals Payload json file
    When create new personals using post request
    Then capture personals id number from response payload
    And get the validatable response object
    And validate status code 201
    And validate status line "Created"
    And validate response time should below 5000 milliseconds
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And generate response logs
