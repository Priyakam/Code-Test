Feature: Application Login
Scenario: Home page default login
Given User is on landing page
When User enters username and password
Then Home Page appears
And Credit cards are displayed
