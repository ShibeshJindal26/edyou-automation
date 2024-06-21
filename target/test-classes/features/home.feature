Feature: verify chatbot functionality

  @test
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

  
  Scenario: Check for greeting messages response
    When Click on maximizer
    And Type a greeting message
    And Click on send button
    Then Response message should be as expected

   @sanity
  Scenario: Audio should be working
    When Click on maximizer
    And Click on unmute button
    Then Audio waves should be displayed

 
  Scenario: Mic button should be working
    When Click on mic button
    Then Mic button should be enable

  
  Scenario: Check openai functionality
    When Click on maximizer
    And type a query for openai
    And Click on send button
    Then Response should be generate
    
     
     @sanity
   Scenario: Check safety dropdown functionality
   When Hover on safety dropdown
   And Select physical safety
   Then Physical safety page should be open
   
    @sanity
   Scenario: Request access form functionality
   When Click on investor area
   And Fill all required field
   And Click on request access button
   Then Validate success message
   
    
