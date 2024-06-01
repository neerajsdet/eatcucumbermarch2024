Feature: Login Functionality
  Background:
    Given Launching Website for testing

  Scenario: User Verify the login functionality with valid credentials
    Given I am on login page of application
    When I enter valid user name and password
    And I click on login button
    Then I am landing on home page successfully

  Scenario: User Verify login functionality with invalid credentials
    Given I am on login page of application
    When I enter invalid user name and password
    And I click on login button
    Then I am getting error for invalid credential

  Scenario: User Verify login functionality with invalid credentials
    Given I am on login page of application
    When I enter username "Tester"
    When I enter password "admin"
    And I click on login button
    Then I am getting error for invalid credential