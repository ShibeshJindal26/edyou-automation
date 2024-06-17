Feature: verify chatbot functionality

  Scenario: User should be able to maximize chat screen after clicking on maximizer.
    When Click on maximizer
    Then Minimizer should be displayed

  Scenario: User should be able to minimize chat screen after clicking on maximizer.
    When Click on maximizer
    And Click on minimizer
    Then Maximizer should be displayed

  Scenario: Avatar video should be displayed
    Then Avatar video is displayed

  @sanity
  Scenario: Hide hannah
    When Click on hide hannah button
    Then Show hannah button should be displayed
