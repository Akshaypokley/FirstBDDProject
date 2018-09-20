@LoginProfile
Feature: Login Profile
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Background: User navigates to Company home page
    Given I am on the page on URL


  Scenario: Successful login
    When I fill in "txtUN" with "architect"
    And I fill in "txtPW" with "Autodcr@123"
   And I click on the button

  Scenario Outline: Failed login using wrong credentials
    When I fill in "txtUN" with "<username>"
    And I fill in "txtPW" with "<password>"
    And I click on the button
    Then I should see "<warning>" message
    Examples:
      | username    | password   | warning                           |
      | Tset        | 123        | Incorrect credentials. Try again! |
