Feature: verify chatbot functionality

  @sanity
  Scenario: User should be able to maximize chat screen after clicking on maximizer.
    When Click on maximizer
    Then Minimizer should be displayed

  @sanity
  Scenario: User should be able to minimize chat screen after clicking on maximizer.
    When Click on maximizer
    And Click on minimizer
    Then Maximizer should be displayed

  @sanity
  Scenario: Avatar video should be displayed
    Then Avatar video is displayed

  @sanity
  Scenario: Hide hannah
    When Click on hide hannah button
    Then Show hannah button should be displayed

  @sanity
  Scenario: Show hannah
    When Click on hide hannah button
    And Click on show hannah button
    Then Hide hannah button should be displayed

  @sanity
  Scenario: Check for greeting messages response
    When Click on maximizer
    And Type a greeting message
    And Click on send button
    Then Response message should be as expected

  @sanity
  Scenario: Audio should be working
    When Click on maximizer
    And Click on unmute button
    Then Audio waves shoudl be displayed
    
    @sanity
    Scenario: Mic button should be working
      When Click on mic button
      Then Mic button should be enable
    
    
