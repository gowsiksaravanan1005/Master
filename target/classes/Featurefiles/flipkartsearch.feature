Feature: Search scenario
  @flipkartsearch
  Scenario Outline: Search scenario
    Given Flipkart login for Search
    Then Search Mobiles in search bar
    Examples:
      | feature        |
      | flipkartsearch |


    