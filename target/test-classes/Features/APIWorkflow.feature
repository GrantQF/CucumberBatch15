Feature: API workflow for HRMS
  Background:
    Given a JWT is generated

    @apiTest
  Scenario: create an employee using API call
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
      Then the employee contains key "Message" and value "Employee Created"
      Then the employee id "Employee.employee_id" is stored as a global variable to be viewed

      @apijsonworkflow
      Scenario: retrieve an employee using API call
        Given a request is prepared to get create an employee
        When a GET call is made to get the employee
        Then the status code for this employee is 200
        Then the employee data we get having id "employee.employee_id" must match with global store employee id
        Then the retrieved data at "employee" object matches with the data of created employee
        |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
        |Tony         |Anthonyson  |Tony           |Male      |2022-02-02  |Retired   |HR           |

        @apipayloadmoredynamic
        Scenario: create an employee using API call
          Given a request is prepared to create an employee with dynamic data "Tony" , "Anthonyson" , "Anthony" , "M" , "2022-02-02" , "Retired" , "HR"
          When a POST call is made to create an employee
          Then the status code for creating an employee is 201
          Then the employee contains key "Message" and value "Employee Created"
          Then the employee id "Employee.employee_id" is stored as a global variable to be viewed

          @updateEmployee
          Scenario: updating an employee using API call
            Given a request is prepared to update an employee
            ##Given a request is prepared to update an employee "Tony" , "Anthonyson" , "Anthony" , "M" , "2002-02-02" , "Confirmed" , "QATester"
            When a PUT call is made to update an employee
            Then the status code for creating an employee is 200