@regression @smoke
Feature: US_11 As a user, I should be able to access to Talks module

  Scenario: verify users to access to Talks module
    Given user on the dashboard page
    When the user clicks the "Talk" module
    Then verify the page title is "Talk - Trycloud QA"

  Scenario: verify users to send a message
    Given user on the dashboard page
    When the user clicks the "Talk" module
    And user search "User19" user from the search box
    And user write a "Hey test hi from 109" to the message
    And user clicks to submit button
    Then the user should be able to see the "Hey test hi from 109" message is displayed on the conversation log