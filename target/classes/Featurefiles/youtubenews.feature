Feature: Youtube Music
  @youtubeNews
  Scenario Outline: New in explore section
    Given Click youtube link in google
    And Click Explore
    And Click News Symbol
    Then Click Channels in news section
    Then Click the subdivision news "<subdivisionnews>"
   # Then Click PlayAll symbol
    Examples:
      | subdivisionnews |
      | Technology News |

