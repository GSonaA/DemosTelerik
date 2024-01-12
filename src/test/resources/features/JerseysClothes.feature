@clothes
Feature: Clothes
  Background:
    Given User is in "e.shop" website
    When click login btn
    And User hover categories button
    And User clicks Clothes button
    And User clicks Jerseys clothes

  Scenario: User successful login  and click clothes categories
    Given User is in "e.shop" website
    When click login btn
    And User hover categories button
    And User clicks Clothes button
    And User clicks Jerseys clothes
    Then Jerseys clothes should be displayed on the page

  Scenario: User successful login  and click clothes categories
    Given User is in "e.shop" website
    When User hover categories button
    And User clicks Clothes button
    And User clicks Jerseys clothes
    And User clicks discount item only radio button
    Then discounted item should be displayed on the page


  Scenario Outline: Check "<Model>" radio button
    And   Clicks "<Model>" filter checkboxes
    Then   user should  see "<Model>" items on the pages
      Examples:
        | Model                       |
        | Long-Sleeve Logo Jersey     |
        | Short-Sleeve Classic Jersey |

  Scenario Outline: User want to clicks size filters
    And   Clicks "<size>" filter checkboxes
    Then   user should  see "<size>" items on the pages
    Examples:
      | size |
      | L    |
      | M    |
      | S    |
      | XL   |

  Scenario Outline: User want to clicks color filters
    And   Clicks "<color>" filter checkboxes
    Then   user should  see "<color>" items on the pages
    Examples:
      | color  |
      | Multi  |
      | Yellow |
