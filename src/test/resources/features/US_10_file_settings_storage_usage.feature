@regression @smoke
Feature: As a user, I should be able to update settings.

  Scenario: Verify users update settings
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user click the "Settings" sub-module
    Then the user should be able to click any buttons

  Scenario: Verify users to see the app storage usage
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user checks the current storage usage
    And the user clicks the add icon on the top
    And user uploads file with the upload file option
    And user refresh the page
    Then the user should be able to see storage usage is increased