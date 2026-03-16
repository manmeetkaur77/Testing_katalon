
Feature: Dashboard Functionality
  As a logged-in user
  I want to view the dashboard
  So that I can see the vessel overview

  Scenario: Verify dashboard loads after login
    Given the user is logged in as "manmeet@varuna.com"
    When the user navigates to the Dashboard
    Then the vessel summary should be visible
    And the navigation menu should be displayed
