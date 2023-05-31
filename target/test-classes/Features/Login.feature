Feature: Login Functionalities
  @testLogin
  Scenario: Valid Admin Login
    #Given open the browser and launch HRMS - Handled by HOOKS
    When user enters valid email "admin" and valid password "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And Close the browser - Handled by HOOKS

  @scenarioOutline
  Scenario Outline: data provided via scenario outline
       #Given open the browser and launch HRMS - Handled by HOOKS
    When user enters valid email "<username>" and valid password "<password>"
    And click on login button
    Then user is logged in successfully
    #And Close the browser - Handled by HOOKS
  Examples:
    | username | password |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |

    @dataTable
    Scenario: data provided via data table
      When user enters username and pasword and verifies login
        | username | password |
        | admin    | Hum@nhrm123 |
        | ADMIN    | Hum@nhrm123 |
        | Jason    | Hum@nhrm123 |
