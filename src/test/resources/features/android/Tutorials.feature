@MOBILE-APP-ANDROID
Feature: Driver completes the Assigned Route tutorial

  Background: Driver opens the application
    #1. Driver logins the app.
    Given User opens the application

  @mobile-android @test
  Scenario Outline: Driver starts the Assigned Route tutorial
    # 1.1 Driver login and should see home page.
    When User logins the application with user: "<username>" and pass: "<password>"
    # 2. He opens the Profile screen and taps on the Tutorials
    And  User clicks to Profile tab
    And  User clicks to item Tutorials
    # 3. He sees 3 sections: Assigned Route, Direct Booking, Ticket Booking
    Then User should sees the following sections:
      | Assigned Route  |
      | Direct Booking  |
      | Ticket Booking  |
    # 4. He taps on Assigned Route
    When User taps on item Assigned Route


    Examples:
      | username    | password  |
      | auto_244332 | Testing1! |
