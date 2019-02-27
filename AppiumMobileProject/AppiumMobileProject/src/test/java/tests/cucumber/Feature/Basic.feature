Feature: Amazon shopping

  Scenario: Open the application and add item to cart
    Given I have skipped Splashscreen
    Then I sign in to my account as padmashreekamal05
    And search for item
      | iphone |
    Then I select the item
    Then I add it to cart
    And I delete item from cart




