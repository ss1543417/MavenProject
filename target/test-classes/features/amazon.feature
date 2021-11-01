Feature: To check Ajax/Mouse over action on amazon site


Scenario Outline: To check mouse over action on Sign In tab
Given Initialize the browser with chrome
And Navigate to "https://www.amazon.in/" site
When User moves mouse over Sign In tab
Then System triggers Sign tab pop-up 
And Other features as well
