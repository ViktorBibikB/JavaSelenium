Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Background:
    Given User opens Homepage page

  Scenario: 1. Positive - Get first abstract title text.
    When User clicks News tab
    Then User checks that Header Text From First Abstract is not empty


  Scenario Outline: 2. Positive - Get Headers List Size.
    When User clicks News tab
    Then User checks that Header List size from top News block equals at least <header_list>

    Examples:
      | header_list |
      | 8           |


  Scenario Outline: 3. Positive - Check the name of the first article against a specified value.
    When User clicks News tab
    And User sends first article category name to search field
    Then User checks that first article title equals to '<category_title>'

    Examples:
      | category_title                   |
      | Europe: Strangers on My Doorstep |
