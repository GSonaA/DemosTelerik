Feature: MountainBikes
  Background:
    Given User is in "e.shop" website
    When click login btn
    And User hover categories button
    And User clicks Bikes button
    And User clicks Mountain Bikes button
@dct
  Scenario: Checking discounted item in Mountain Bikes categories
    Given User is in "e.shop" website
    And   Clicks Discounted items only
    Then  discounted item should be displayed on the page

  @mountainbikes
    Scenario Outline: Check model filter "<Model>"
    And   Clicks "<Model>" "model" filter checkbox
   Then   user should  see "<Model>" items on the page
   Examples:
     | Model                                  |
     | mountain-100&mountain-200&mountain-300 |
     | mountain-200                           |
     | mountain-300                           |
     | mountain-400-W                         |
     | mountain-500                           |

  @size
  Scenario Outline: Check  size filter "<size>"
        And  Clicks "<size>" "size" filter checkbox
        Then user should  see "<size>" items on the page
        Examples:
          | size |
          | 38   |
          | 40   |
          | 42   |
          | 44   |
          | 46   |
          | 48   |
          | 52   |


  @color
    Scenario Outline: Check color filter "<color>"
      And  Clicks "<Color>" "color" filter checkbox
      Then user should  see "<Color>" items on the page
      Examples:
        | Color  |
        | black  |
        | silver |

  @rating
        Scenario Outline: Check rating stars radio button
          Given  User want to see rating
          And  User Clicks "<Rating>" radio button
          Then user should see  "<Rating>"  stars bikes on the page
          Examples:
            | Rating |
            | 5      |
            | 4      |
            | 3      |
            | 2      |
            | 1      |
@price
  Scenario Outline: Check  Price radio button
    When  User choose price interval from "<from>" "<to>"
    Then   user should  see "<from>" "<to>" items on the page
    Examples:
      | from  | to    |
      | 0     | 500   |
      | 500   | 1,000 |
      | 1,000 | 1,500 |
      | 1,500 | 2,000 |
      | 2,000 | 2,500 |
      | 2,500 | 3,000 |
      | 3,000 | 3,500 |
      | 3,500 | 4,000 |
