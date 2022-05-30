Feature: Flipkart
  @@flipkart-4
  Scenario Outline: Flipkart Scenario
    Given Flipkart login
    Then Enter Mobiles "<Enter>" in Search bar
    Then Print Mobile details
    Then Filter the amount
    Examples:
      | Enter   |
      | Mobiles |