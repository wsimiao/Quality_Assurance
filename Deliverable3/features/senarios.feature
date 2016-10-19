Feature: Test Store.demoqa login

    Scenario: Test login with valid credentials
    Given Open firefox and start application
    When I enter valid username and valid password
    Then user should be able to login successfully

    Scenario: Test login with invalid credentials
    Given Open firefox and start application
    When I enter invalid username or invalid password
    Then User cannot login
