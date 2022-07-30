Feature: Login Functionality for Librarian and Students


	@B26G23-72 @LibraryCT
	Scenario Outline: As a librarian, I should be able to login to LibraryCT
	AC#1

		Given user is on the loginPage
		Then verify that the title is "Login - Library"
		When librarian enters valid "<email>" and "<Password>"
		And user click sign in button
		Then verify that there are 3 models on the page
		Examples:
			| email              | Password |
			| librarian1@library | qU9mrvur |
			| librarian2@library | uYrhHmmj |
			| librarian3@library | DFvU4b1i |
			| librarian4@library | 3lwxJ1Kk |


	@B26G23-74 @LibraryCT
	Scenario Outline: As a student, I should be able to login and see 2 models
		Given user is on the loginPage
		Then verify that the URL is “https://library2.cydeo.com/login.html”
		When student enters valid "<email>" address and "<password>"
		And user click sign in button
		Then verify that there are 2 models on the page

		Examples:

			| email            | password |
			| student1@library | d5fv9BtX |
			| student2@library | zyxa10vg |
			| student3@library | rPjgZ86a |
			| student4@library | pG3V6qaL |

	@B26G23-76
	Scenario: student login with invalid  data
		Given user is on the loginPage
		When user enters invalid "email" address or "password"
		And user click sign in button
		Then verify the error message "Sorry, Wrong Email or Password"