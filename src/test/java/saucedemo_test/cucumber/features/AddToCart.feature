Feature: Add to cart
  Scenario: Add item to cart
    Given :User login
    When :User Click title of item
    And :User click Add to cart button
    Then : Cart Filled