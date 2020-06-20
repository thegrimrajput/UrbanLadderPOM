Feature: Login Feature Test
Scenario Outline: Logging in with valid credentials 
					Given user is on application landing page
					Then user verifies it is on application landing page 
					Then user enters the "<username>" and "<password>"
					Then user verifies sign in is successfull or not
					
					
Examples: 
      | username | password |
      | ddogra90@gmail.com |  M@nju_123   | 
      | aayushijain0217@gmail.com | Urban@123 |


Scenario Outline: Loggin in with invalid credentials 
					Given user is on application landing page
					Then user verifies it is on application landing page 
					Then user enters the "<username>" and "<password>"
					Then user verifies sign in is successfull or not 
					
Examples: 
      | username | password |
      | ddogra@gmail.com |  M@nju_123   | 
      | aayushijain@gmail.com | Urban@123 |