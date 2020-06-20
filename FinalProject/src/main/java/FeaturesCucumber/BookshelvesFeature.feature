Feature: Getting Bookshelves
Scenario Outline: Getting bookshelves data and saving it in Excel sheeet
					Given user is on application landing page
					Then user verifies it is on application landing page 
					Then user enters the "<username>" and "<password>"
					Then user verifies sign in is successfull or not
					Then user open the bookshelves page 
					Then user selects the price range
					Then user selects the storage type as Open
					Then user clicks on the top five bookshelves 
					Then user gets the data of top five bookshelves and store it in Excel sheet
					
					
Examples: 
      | username | password |
      | ddogra90@gmail.com |  M@nju_123   | 
      | aayushijain0217@gmail.com | Urban@123 |