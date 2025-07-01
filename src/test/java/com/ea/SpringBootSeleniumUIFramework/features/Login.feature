Feature: LoginFeature
  This feature deals with the login functionality of the applications

  Background: user is logged in
    Given I click "login" link in "Home" page
    When I enter the following for Login
      | username | password |
      | admin    | password |
    And I click "Log in" button

  @smoke
  Scenario: Login with correct username and password
    Then I should see the "Employee Details" link

  @regression
  Scenario: Login with correct username and password
    Then I should see the "Employee Details" link
