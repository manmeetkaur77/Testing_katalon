
Feature: Login Functionality
  As a user of Varuna Marine Application
  I want to be able to login to the system
  So that I can access the dashboard and manage vessels

  Background:
    Given the user is on the Varuna Marine login page

  # ─────────────────────────────────────────
  # ✅ SCENARIO 1: Valid Login
  # ─────────────────────────────────────────
  Scenario: Login with valid credentials
    When the user enters username "manmeet@varuna.com"
    And the user enters password "Test@1234"
    And the user clicks the Login button
    Then the user should be redirected to the Dashboard
    And the welcome message should be displayed

  # ─────────────────────────────────────────
  # ❌ SCENARIO 2: Invalid Login
  # ─────────────────────────────────────────
  Scenario: Login with invalid credentials
    When the user enters username "wrong@varuna.com"
    And the user enters password "WrongPass"
    And the user clicks the Login button
    Then an error message "Invalid credentials" should be displayed
    And the user should remain on the login page
