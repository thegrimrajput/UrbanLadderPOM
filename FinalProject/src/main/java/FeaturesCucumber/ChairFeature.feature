Feature: Getting Chairs
Scenario Outline: Getting the chairs data and save it in Excel file 
					Given user is on application landing page
					Then user verifies it is on application landing page 
					Then user enters the "<username>" and "<password>"
					Then user verifies sign in is successfull or not
					Then user open the chairs page 
					Then user clicks on the top three chairs 
					Then user gets the data of top three chairs and store it in Excel sheet
					
					
Examples: 
      | username | password |
      | ddogra90@gmail.com |  M@nju_123   | 
      | aayushijain0217@gmail.com | Urban@123 |