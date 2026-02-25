@Smoke
Feature: Account access for guest user


  Scenario: Verify guest user cannot access Your Orders page
    Given user hovers on Hello
    When user selects Your Orders
    Then user should be redirected to sign in page

  Scenario: Verify guest user cannot access Your Addresses page
    Given user hovers on Hello, sign in Account & Lists
    When user selects Your Addresses
    Then user should be redirected to sign in

  Scenario: Verify guest user can access Your Lists intro screen
    Given user hovers on Hello, sign in Account
    When user selects Your Lists
    Then Your Lists intro screen should be displayed