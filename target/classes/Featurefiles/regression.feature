@Regression
Feature: Regression
  Scenario: 1. Login Scenario
    Given Flipkart login

  Scenario Outline: 2. Mobile Scenario
    Given Flipkart login for mobile
    Then Enter Mobiles "<Enter>" in Search bar
    Then Print Mobile details
    Then Filter the amount
    Examples:
      | Enter   |
      | Mobiles |

  Scenario: 3. Search scenario
    Given Flipkart login for Search
    Then Search Mobiles in search bar

  Scenario Outline: 4. Wishlist Scenario
    Given Flipkart login for wishlist
    Then Enter Mobiles "<Enter>" in Search bar
    Then Print Mobile details
    Then Click first mobile in the list

    Examples:
      | Enter | Pincode |
      |Mobiles | 637017 |