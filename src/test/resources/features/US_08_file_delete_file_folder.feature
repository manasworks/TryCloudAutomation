@regression @smoke
Feature: As a user, I should be able to delete a file/folder.

  Scenario: Verify users delete a file/folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And the user clicks action-icon from any file on the page
    And user choose the "Delete" option
    When user click the "Deleted files" sub-module
    Then Verify the deleted file is displayed on the page