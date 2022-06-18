Feature: Dice  job search

  As a user, I should be able to search for jobs, using a keyword and zipcode, then see
  results in total

  @dice
  Scenario: User searches for a job
    Given user is on the dice homepage
    When user enters keyword and zipcode
    Then user should see search results