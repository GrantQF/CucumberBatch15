Feature: Employee
  Background:
    When user enters valid email "admin" and valid password "Hum@nhrm123"
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button

  @empAdd
  Scenario: Adding a new Employee
    #Given open the browser and launch HRMS - Handled by HOOKS
    And user enters firstname "Sleepy" , middlename "Joe" , and lastname "Biden"
    And user clicks on save button
    #And Close the browser - Handled by HOOKS

  @database
  Scenario: adding the employee from front end and verifying it from back end
    And user enters 'john' and 'jones' and 'johnson'
    And user captures the employee id
    And user clicks on save button
    And query the information on the backend
    Then verify the results from front end and back end
