Feature: Mobile Scenario
  @flipkartmobiles
  Scenario Outline: Mobile Scenario
    Given Flipkart login
    Then Enter Mobiles "<Enter>" in Search bar
    Then Print Mobile details
    Then Filter the amount
    Examples:
      | Enter   |
      | Mobiles |