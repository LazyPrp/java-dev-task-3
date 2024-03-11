Project Structure:
		
		Survey System
		          |
	         	     Main.java
	 	          |	
	                    UserSurvey.java
		          |
  	         |------------------------------------|
  UserLoginSurvey1.java(Guest)		(User)Login.java(creator/Admin) Or Signup.java
	         |		          	          |
	   Guest.java		   MainPage.java

All of these are connected using database and SQLManage.java class
this project uses 3 main jar for connection and execution 
1. Sqlconnector jar
2. activation jar
3. Mail.jar 

Project Structure:
Main : initializes the project
Login: Handles user authentication and provides access to the system.
SignUp: Allows new users to register for the system.
MainPage: After logging in, users can create or view surveys using the main interface.
MainPage: Manages the main interface of the application, including survey creation and viewing panels.	       
Survey Creation: Users can add questions and options to create a new survey.
Survey Viewing: Users can view existing surveys, navigate through the questions, and delete surveys if needed.

SQLManage: Manages interactions with the MySQL database, including user authentication and survey management operations.
Usage:

LoginSurvey : Lets Guest to start the survey
Login: Handles user authentication and provides access to the system.
Guest : handles all survey questions


Overview:
The Survey System is a Java application designed to manage surveys, allowing users to create, view, and delete surveys and their corresponding questions. 
The system includes features for user authentication, survey creation, and survey viewing.
 It uses a MySQL database to store survey data and user information. The project is divided into two parts: user and guest.

Key Features:

1)User Features:

User Authentication: Users can log in with their username and password, authenticated against a MySQL database.
Survey Creation: Users can create surveys by entering questions and four options for each question, with surveys assigned a unique code.
Survey Viewing: Users can view existing surveys and their questions, with navigation through the questions provided.
Survey Deletion: Users can delete surveys, removing them from the system along with their associated questions.

2)Guest Features:

Login: Guests can log in using their name and email.
Email Verification: After entering guest credentials, an email is sent to the guest containing a survey code.
Authentication: Guests enter the code received in the email to verify and access the survey.
Survey: After code validation, guests can take the survey.

Technical Details:
> Language: Java
> Database: MySQL
> GUI Framework: Swing
> Mail: mailapi
> Build Management: None (Manual compilation and execution)


Conclusion:
The Survey System provides a user-friendly interface for managing surveys. It allows users to create, view, and delete surveys, making it a versatile tool for survey management. 
With its simple design and intuitive features, the system is suitable for various survey-related applications.