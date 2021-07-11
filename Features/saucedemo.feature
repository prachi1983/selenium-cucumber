Feature: SauceDemo Application

  @Login
  Scenario: Test to validate Login functionality of -saucedemo.com-
    Given Open chrome and navigate to Login page
    When Valid username and passed is entered
    Then User should be logged in successfully and verify url contains "inventory.html"

  @AddCart
  Scenario: Test to validate Add cart functionality
    When select filter "Price (low to high)" Click on "ADD TO CART" button.
    Then Under "YOUR CART" order should get entered and "ADD TO CART" button should get change to "REMOVE"

  @RemoveCart
  Scenario: Test to validate Remove cart functionality
    When Click on "REMOVE" button.
    Then Under "YOUR CART" order should get removed and "REMOVE" button should get change to "ADD TO CART"
