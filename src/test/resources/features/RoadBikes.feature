@roadbikes
Feature: RoadBikes
  Background:
    Given User is in "e.shop" website
    When click login btn
    And User hover categories button
    And User clicks Bikes button
    And User clicks road bikes button

  Scenario: Checking discounted item in Road Bikes categories
    Given User is in "e.shop" website
    When click login btn
    And User hover categories button
    And User clicks Bikes button
    And User clicks road bikes button
    And Clicks Discounted items only
    Then discounted road bikes item should be displayed on the page

@road150
    Scenario: Check road radio button road bikes categories
    Given User is in "e.shop" website
    When click login btn
    And User hover categories button
    And User clicks Bikes button
    And User clicks road bikes button
    And User clicks road150 radio button
    Then road-150 bikes should be displayed on the page

@road250
Scenario: Check road radio button road bikes categories
  Given User is in "e.shop" website
  When click login btn
  And User hover categories button
  And User clicks Bikes button
  And User clicks road bikes button
  And User clicks road twofivezero radio button
  Then road twofivezero bikes should be displayed on the page

