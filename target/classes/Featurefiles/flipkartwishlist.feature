Feature: Wishlist Scenario
  @flipkartwishlist
  Scenario Outline: Wishlist Scenario

    Given Flipkart login
    Then Enter Mobiles "<Enter>" in Search bar
    Then Print Mobile details
    Then Filter the amount
    Then Click first mobile in the list

    Examples:
      | Enter | Pincode |
    |Mobiles | 637017 |