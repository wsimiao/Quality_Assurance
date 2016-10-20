Feature: As a user, if I search for something the website has, it should return me a list of items. Otherwise, nothing returned

    Scenario: Test search function with existing items
    Given Open firefox and open the website
    When I enter iphone in the search bar
    Then iphone is returned in the resulte list

    Scenario: Test search function with unexisiting items
    Given Open firefox and open the website
    When I enter cream in the search bar
    Then There is no result list returned and it shows nothing matches
