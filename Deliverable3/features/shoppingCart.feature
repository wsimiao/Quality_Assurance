Feature: As a user, I need to be able of add items into cart, update quantity and remove items

    Scenario: check items in shopping cart
    Given I am at the page of one item
    When I click add to cart button
    Then I should see the text you just added the item to your cart

    Scenario: Update shopping cart with positive quantity
    Given 1 item is in the shopping cart and I am in the cart page
    When change the quantity with a positive number
    Then the quantity of items in the cart changes and total price changes

    Scenario: Update shopping cart with negtive quantity
    Given 1 item is in the shopping cart and I am in the cart page
    When change the quantity with a negative number
    Then the cart is empty and I should see the text error

    Scenario: empty shopping cart
    Given 1 item is in the shopping cart and I am in the cart page
    When I click remove button
    Then the cart is empty and I should see the text 0 item

    Scenario: Add the same item in the cart again
    Given 1 item is in the shopping cart and I am in the cart page
    When I add the same item again
    Then I should see the quantity of this item is 2


