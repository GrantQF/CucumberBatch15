Feature: Searching the employee

  Background:
   #Given open the browser and launch HRMS - Handled by HOOKS
    When user enters valid email "admin" and valid password "Hum@nhrm123"
    And click on login button
    When user clicks on PIM option

  @empSearchId
  Scenario: Search Employee by Id
    #Given open the browser and launch HRMS - Handled by HOOKS
    #When user enters valid email "admin" and valid password "Hum@nhrm123" - Handled by Background
    #And click on login button - Handled by Background
    #When user clicks on PIM option - Handled by Background
    When user enters valid employee id "19741158"
    And Clicks on search button
    And user see employee information is displayed
    #And Close the browser - Handled by HOOKS

@empSearchJob
  Scenario: Search Employee by Job Title
   #Given open the browser and launch HRMS - Handled by HOOKS
    #When user enters valid email "admin" and valid password "Hum@nhrm123" - Handled by Background
    #And click on login button - Handled by Background
    #When user clicks on PIM option - Handled by Background
    When user enters valid Job title "Singer"
    And Clicks on search button
    And user see employee information is displayed
    #And Close the browser - Handled by HOOKS

