Feature: LoginFeature
  This feature deals with the login functionality of the applications

  @smoke @regression
  Scenario: Login with correct username and password
    Given I click "login" link in "Home" page
    When I enter the following for Login
      | username | password |
      | admin    | password |
    And I click "Log in" button
    Then I should see the "Employee Details" link

  @regression
  Scenario: Login with incorrect username and password
    Given I click "login" link in "Home" page
    When I enter the following for Login
      | username | password |
      | admin    | password1 |
    And I click "Log in" button
    Then I should see the "Invalid login attempt." text displayed