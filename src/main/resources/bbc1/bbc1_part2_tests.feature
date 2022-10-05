Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Background:
    Given User opens Homepage page
    And User clicks Contact Us button into page footer
    And User clicks Question Tab
    And User clicks How Can I Contact Link
    And User clicks Get More Help Button
    And User clicks I Want To List variant in list
    And User clicks I Want Information About in list
    And User clicks Continue Button

  Scenario Outline: 1. Negative - Send Question To BBC Without Title.
    When User sends Text '<required_text>' To Enquiry Text area
    When User clicks button Continue in Get More Help Form
    Then The error message '<error_message>' should to be appeared

    Examples:
      | required_text | error_message                                       |
      | Some text     | There’s an error to correct before you can continue |


  Scenario Outline: 2. Negative - Send Question To BBC Without TextBox.
    When User sends Text '<required_text>' To Enquiry Title Input Field
    When User clicks button Continue in Get More Help Form
    Then The error message '<error_message>' should to be appeared

    Examples:
      | required_text                     | error_message                                       |
      | Some text to be sent to input box | There’s an error to correct before you can continue |


  Scenario Outline: 3. Negative - Send Question To BBC Without Any Text.
    When User clicks button Continue in Get More Help Form
    Then The error message '<error_message>' should to be appeared

    Examples:
      | error_message                                       |
      | There’s an error to correct before you can continue |
