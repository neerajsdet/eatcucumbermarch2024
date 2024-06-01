Feature: Login Functionality
  Background:
    Given Launching Website for testing

  Scenario Outline: User Verify login functionality with invalid credentials
    Given I am on login page of application
    When I enter username '<username>'
    When I enter password '<password>'
    And I click on login button
    Then I am getting error for invalid credential
    Examples:
      |username|password|
      |abc@gmai.com  |tester |
      |xyz@gmail.com  |tester|
      |123@gmail.com  |tester|
      |abc@gmai.com  |tester |
      |xyz@gmail.com  |tester|
      |123@gmail.com  |tester|