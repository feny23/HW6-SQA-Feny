Feature: Login Page saucedemo
  @Positive
  Scenario: Success Login
    Given  accesses saucedemo login page
    When  input username
    And input password
    And click login button
    Then User redirect to dashboard page

  @negative
  Scenario: Failed Login
    Given  accesses saucedemo login page
    When  input wrong username
    And input wrong password
    And click login button
    Then User get alert failed login