@regression @smoke
Feature: As a user, I should be able to search any item/ users from the homepage.

  Scenario: Verify users can search any files/folder/users from the search box.
    Given user on the dashboard page
    When the user clicks the magnifier icon on the right top
    And users search any existing "t19.txt" file_folder_user name
    Then verify the app displays "t19.txt" the expected result option