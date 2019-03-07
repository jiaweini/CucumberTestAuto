Feature: Amazon

  Scenario: Checking out after adding a new product to shopping cart
    Given I am on a Amazon product page
    When I press "Add to cart"
    Then the product should exist in my shopping cart
    And the checkout button exists

  Scenario: Checking out after adding an existing product to shopping cart
    Given I am on a Amazon product page
    And I have the same product that already exists in my shopping cart
    When I press "Add to cart"
    Then the product should exist in my shopping cart
    And the quantity of the product should be equal to two
    And the checkout button exists

  Scenario: Checking out after removing an existing product from shopping cart
    Given I am on my current shopping cart
    And I have a product that exists in my shopping cart
    When I press "Delete"
    Then the product should no longer exist in my shopping cart
    And the checkout button does not exist

  Scenario: Checking out with an empty shopping cart
    Given I am on my current shopping cart
    And my shopping cart is empty
    Then there is nothing to delete from the shopping cart
    And the checkout button does not exist