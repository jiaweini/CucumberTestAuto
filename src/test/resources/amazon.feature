Feature: Amazon

  Scenario: Checking out after adding a new product to shopping cart
    Given I am on a Amazon product page
    When I press "Add to cart"
    Then the product should exist in my shopping cart
    And the checkout button exists
    
  Scenario: Sending email with image attached to an address
    Given I am on a new email page 
    When I add an email address under “To”
    And I drag an image into the page
    And I press “Send”
    Then the email is sent
    