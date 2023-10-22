Feature: Checkout Item

  Scenario Outline: Checkout Item
    Given User Login With Username and Password
    And User add item to cart
    And User Click the Icon Cart
    And User Click Checkout Button
    Then User redirect to Checkout : Your Information Page