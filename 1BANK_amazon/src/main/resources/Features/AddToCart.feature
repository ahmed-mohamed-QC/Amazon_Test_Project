@Smoke

Feature: add Items to cart

  Scenario: Verify that Items are added to cart correctly

    Given user click on Todays deals
    When user Clicks on secondnd category
    And Click on firstst product in this category
    And Click on second item in this product
    And Select Quantity two
    And Click on add to cart
    Then go to cart
    Then Verify correct items are added to the cart (name, price, qty and subtotal is correct)
