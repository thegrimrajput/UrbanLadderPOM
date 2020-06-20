Feature: Getting top five bookshelves and top three chairs  
Scenario Outline: Getting bookshelves data and study chairs data then saving it in Excel sheeet
					Given user is on application landing page
					Then user verifies it is on application landing page 
					Then user enters the "<username>" and "<password>"
					Then user verifies sign in is successfull or not
					Then user open the bookshelves page 
					Then user selects the price range
					Then user selects the storage type as Open
					Then user clicks on the top five bookshelves 
					Then user gets the data of top five bookshelves and store it in Excel sheet
					Then user goes back to the homeoage
					Then user open the chairs page 
					Then user clicks on the top three chairs 
					Then user gets the data of top three chairs and store it in Excel sheet
					
					
Examples: 
      | username | password |
      | ddogra90@gmail.com |  M@nju_123   | 
      | aayushijain0217@gmail.com | Urban@123 |