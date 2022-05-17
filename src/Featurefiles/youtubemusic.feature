Feature: Youtube Music
    @youtubeMusic
    Scenario Outline: music in explore section
      Given Click youtube link in google
      And Click Explore
      And Click Music Symbol
      And Click Search
      Then Enter the data "<songList>" in search
      Then Click Enter
      Then Click the particular song "<songName>"
      Examples:
        | songList            | songName                                                 |
        | justin bieber songs | Justin Bieber - Baby (Official Music Video) ft. Ludacris |


