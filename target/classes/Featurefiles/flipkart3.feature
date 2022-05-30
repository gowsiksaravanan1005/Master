Feature: Flipkart
  @@flipkart-3
  Scenario Outline: Flipkart Scenario
    Given Flipkart login
    Then Enter Mobiles "<Enter>" in Search bar
    Then Print Mobile details
    Then Filter the amount
    And Filter the brand "<BrandName>"
    Then Click first mobile in the list
    Then Check "<Pincode>" to estimate delivery
    Then Print Rate of the product
    Examples:
      | Enter   |  | BrandName |  | Pincode |
      | Mobiles |  | Samsung   |  | 637017  |