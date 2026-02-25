@Smoke

Feature: Testing login functionality

  Scenario: Verify that user cannot log in with valid but not registered email

    Given user click on Signup OR Login
    When user enter valid Email
    And user press on continue
    Then verify a message Looks like you're new to Amazon appears
