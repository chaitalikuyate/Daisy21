Feature: This feature verify the homepage for all negative and positive scenario

Scenario: Check the title of homepage
Given verify the title of homepage is "IJmeet"
And The url of application is also launched
Then verify the title of homepage {string}
