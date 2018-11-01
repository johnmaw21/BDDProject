@allinfeature
Feature: The Login Page should allow someone to login
  
  As a returning customer
  I want to login to the application
  So that I can view my account balance

  Background: Run Common Steps acroos all Scenarios in feature
    Given the user is on the login page

  @ignore
  Scenario: The user should be able to login with valid credentials
    When the user enters valid login credentials
    Then the user should be able to view their account balance

  @ignore
  Scenario: The user should not be able to login with invalid credentials
    When the user enters invalid login credentials
    Then the user should be able to login
    And the user should get an invalid login message

  @ignore
  Scenario: The user should be able to login
    When user enters username as "tim@testemail.com"
    And user enters password as "trpass"
    And user clicks on login
    Then the user should be able to view their account balance

  @ignore
  Scenario Outline: the users should be able to login
    When the user enters "<username>" and "<password>"
    Then the user should be able to view their account balance

  #   Examples:
  #     | username            | password |
  #     | tim@testemail.com   | trpass   |
  #     | lisa @testemail.com | lpass    |
  
  @ignore
  Scenario: after a failed attempt, the user should be able to log in again
    When the user enters set of username and password
      | username            | password |
      | lisa @testemail.com | lpass    |
      | tim@testemail.com   | trpass   |
    Then the user should be able to view their account balance

  Scenario Outline: the user should be able to log in using datatable
    When the user enters login details as table
      | <username> |
      | <password> |
    Then the user should be able to view their account balance

    Examples: 
      | username          | password |
      | tim@testemail.com | trpass   |
