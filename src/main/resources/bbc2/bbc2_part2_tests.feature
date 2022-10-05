Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Background:
    Given User opens Homepage page
    And User clicks Score And Fixtures in Sport tab

  Scenario Outline: 1. Positive - Receive game score.
    And User send Scottish League name to the Search field
    And User selects Scottish Championship
    When User clicks required '<month>'
    And User clicks team name '<team_name>'
    Then should appear '<teams_score>' in new page.

    Examples:
      | month | team_name           | teams_score                                            |
      | DEC   | Dunfermline         | Dunfermline\n0\nArbroath\n3                            |
      | NOV   | Queen of the South  | Queen of the South\n1\nInverness Caledonian Thistle\n2 |
      | OCT   | Greenock Morton     | Greenock Morton\n0\nPartick Thistle\n0                 |
      | JAN   | Hamilton Academical | Queen of the South\n0\nHamilton Academical\n3          |