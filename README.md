**_MICROSERVICE REQUIREMENTS:_**
- IntelliJ IDE
- Gradle Dependency 
- H2 Database
- Search Engine such as Chrome, Microsoft Edge, Internet Explorer or FireFox.
- Junit Dependency
- JDK 1.8

**_DEVELOPMENT PLAN_**
1. Make sure all microservice requirements are on hand, in order to begin development.
2. Generate project in Spring Initializer, adding all dependencies needed for the SpringBoot project such as ThymeLeaf. 
3. Import project into IntelliJ, as that is the IDE being used to develop the microservice. 
4. Create packages and classes needed for the microservice, such as the Entity (InputVariables), Controller (InputVariablesController), Repository (InputVariablesRepository), Service (InputVariablesService) and Service Implementation (InputVariablesServiceImpl).
5. Create HTML templates needed to display webpages, such as "form.html" which provides the HTML and CSS for the mapping ("/form") which is the first webpage in which the user can input the needed information to calculate their Blood Alcohol Content (Gender, weight, the number of standard drinks consumed and hours since drinking commenced). "result.html" is the template created with the mapping of "/result" that contains the HTML and CSS required for the webpage to display the result of the user's Blood Alcohol Content, as well as the remaining hours left until their BAC reaches zero. Another html template needed is 'info.html' which displays information on standard drink amounts in different alcohol beverages (beer, wine, spirits etc.) so users have more of an understanding of how many standard drinks they consumed and what to input within the calculator.
6. Initialise variables needed in order to perform methods and will be stored within the H2 Database. These variables include:
- Long id 
- String gender
- double weight 
- double standardDrinks
- double hoursDrinking
7. Create methods that allow the data that is submitted by the user through the webpage to be stored within the H2 Database. These methods include: 
- getAllInputVariables()
- getInputVariablesById()
- saveOrUpdate()
- delete()
8. Create a method within 'inputVariablesServiceImpl' that calculates the user's Blood Alcohol Content based on the information they have submitted in the mapping "/form". This method is called 'getBloodAlcoholContent' and uses Widmark's BAC formula. 
9. Create a variable called 'hoursUntilZero' that divides the user's Blood Alcohol Content by 0.015 in order to calculate how many hours remain until the user's BAC will reach zero.
10. Implement String Formatting to both double variables 'getBloodAlcoholContent' and 'hoursUntilZero' so that the decimals are rounded to a reasonable amount of decimal points instead of 10. 
11. Develop three Junit tests in order to ensure the microservice is working correctly. 

![img.png](img.png)

_**STATEMENT OF PURPOSE**_

**What the application will do:**

This microservice will work as a BAC (Blood Alcohol Content) calculator in which it will take input from the user through a webpage - including their gender, weight in kilograms, how many standard drinks they have consumed and the amount of hours it has been since commencement of drinking. This data will be stored within the H2 database. The microservice will then calculate the person's current Blood Alcohol Content, using Widmark's BAC formula, based on the information the user has submitted. It will also calculate the amount of hours until their Blood Alcohol Content will reach back to zero, and display both results on the webpage to the user, as well as the legal blood alcohol limit to drive. The microservice also displays a webpage with information on the amount of standard drinks in different alcohol beverages and therefore gives users a better insight into how much alcohol they are consuming.

**What business problem it addresses:**

After consuming alcohol, it is important to know if enough time has passed for one's BAC to be within the legal limit to drive. This application assists in the prevention of drink-driving as it notifies the user if their Blood Alcohol Content is still too high to legally drive, in which the user will know they need to find another way home. It will also tell the user the amount of hours until their BAC will reach 0, allowing them to recognize the amount of time until they can drive legally. 

**The target audience:**

The target audience for this application includes those who have consumed alcohol recently and drive, and must know if their BAC is within legal limit to use their vehicle. Therefore, the target audience also for users over the age of 18 as that is the legal age limit to drink in Australia.

**_MICROSERVICE FEATURES:_**

- Display's the title of the microservice 'Blood Alcohol Content Calculator'.
- Allows the user to input needed information such as gender, weight, number of standard drinks consumed and the number of hours since they first started drinking - in order to calculate their Blood Alcohol Content. 
- Provides a link to a separate made webpage that displays information on Standard Drinks and how many is in most alcoholic beverages in order to give the user a better understanding on how many Standard Drinks they might have consumed. 
- Allows the user to then submit their input or reset it to type it in again.
- Stores the submitted data within the H2 database.
- Perform calculations using Widmark's Blood Alcohol Content formula, based on input by the user, in order to calculate their BAC.
- Displays the user's current Blood Alcohol Content.
- Displays the number of hours remaining until the user's Blood Alcohol Content will return to zero.
- Displays the legal blood alcohol limit to drive for both Learner and Provisional License holders, in order for the user to know whether they can legally drive, or how much longer until they can.
- Allows the user to make a new submission into the Blood Alcohol Content calculator. 

**_IMPLEMENTATION PLAN:_**

**Monday:**
1. First I created a new GitHub Repository with the name of 'capstone-project2'.
2. Next, I set up a new Gradle SpringBoot project using the Spring Initializer ensuring it had the dependencies I needed such as ThymeLeaf and Junit. 
3. I then imported the created project in IntelliJ, the chosen IDE for this microservice. 
4. Further, I created the needed packages and classes for my project, such as: 
- The Entity (InputVariables) - This class contains the main variables I need, that will be controlled in 'InputVariablesController' and accessed through 'form.html' in order to display the usage of them on the webpage. 
- Controller (InputVariablesController) - This class controls the mapping of the webpages and returns the html template linked to that mapping. 
- Repository (InputVariablesRepository) - This interface allows for the storing of data within the H2 Database.
- Service (InputVariablesService) - This interface calls the methods implemented in 'InputVariablesServiceImpl'.
- Service Implementation (InputVariablesServiceImpl) - This class contains the methods needed to get the id's for the stored variables, update and save the data, and delete the data from the H2 Database.
5. Next I created my variables within 'InputVariables', such as:
- Long id
- String gender (The user's gender)
- double weight (The user's weight in kilograms)
- double standardDrinks (The amount of standard drinks the user has consumed)
- double hoursDrinking (The number of hours since the user started drinking)

and generated my getters and setters for those variables. The variables 'gender', 'weight', 'hoursDrinking' and 'standardDrinks' are needed as they are variables used within the formula to calculate one's Blood Alcohol Content. 'ID' is solely used for generating an ID within the H2 Database to store the submissions from users on the webpage.


**Tuesday:**
6. I then set up the H2 database by putting in the required application.properties to access the database.
7. Furthermore, I created the following methods within InputVariablesServiceImplements:
- getAllInputVariables() - This method retrieves the variables created in my entity class and stores them within the database.
- getInputVariablesById() - This method generates an ID for the data being stored within the H2 Database once it is submitted by a user via the webpage.
- saveOrUpdate() - This method allows data submitted by a user through the webpage to be saved or updated within the H2 Database.
- delete() - This method allows data submitted to the database to be deleted.

8. Then, I called the methods within InputVariablesServiceImpl in InputVariablesService so that I could then call the methods in the controller by autowiring the service interface within InputVariablesController. 
9. Next, I created another method in InputVariableServiceImpl that utilises Widmark's BAC formula in order to calculate the user's Blood Alcohol Content based on the data the user has submitted. This method was called 'getBloodAlcoholContent'. I then called this method within the controller in order to map it so it could be displayed on the result webpage for the user through html from the 'result.html' template.
10. I created a new variable called 'hoursUntilZero' within the Controller to calculate how many hours until the user's BAC will reach zero by dividing the user's Blood Alcohol Content by 0.015. By putting it in the controller, the method can easily be accessed by the 'result.html' template in order to display the remaining hours until the user's BAC will reach zero again on the webpage.


**Wednesday:**
11. I implemented BootStrap and CSS within Thymeleaf html files 'form.html' and 'result.html' in order to make the webpage’s layout much more presentable. This included centering the content, changing the font colour of the headings, as well as buttons in order to create a simplistic yet sleek theme for my webservice. I also linked the templates to the controller in order to use the variables and methods created, and therefore be able to produce a Blood Alcohol Content calculation and display the results. 
12. I then String formatted the two doubles 'getBloodAlcoholContent' and 'hoursUntilZero' to round the decimal places to three. This makes the result easier to read for the user, rather than having a double that is rounded to 10 decimal places, as it was originally. This process resulted in the variable names that were used in the 'result.html' template to be changed to 'newBloodAlcoholContent' and 'newHoursUntilZero', in order to display the formatted result.


**Thursday:**
13. Further, I inserted another if-and-else statement within my method 'getBloodAlcoholContent' that makes sure that if the user inputs '0' for any of the variables: 'weight', 'standardDrinks' or 'hoursDrinking', on the results form "0.0" will be displayed rather than 'NaN' which is what the equation produced originally.
14. Next, I created my first Junit test called 'getInputVariablesById'. This test is needed as it asserts that each of the InputVariables (weight, standardDrinks, gender and hoursDrinking) can be stored within the H2 Database with an ID that is not null, in which the data can also be found via it's existing ID. This tests that the database is working efficiently in correctly storing and identifying the InputVariables.
15. Following that, I created my second test that asserts that if the user inputs their weight as '0.0' on the webpage, the correct result will be displayed on '/result'. This test is essential as if it passes, it means there is error handling for when a user does not input a proper weight, and ensures the calculations are working correctly. 

**Friday:**
16. Finally, I created my last test called 'statusAndSubmissionOfController'. This test checks that the status is 'OK', and also that the controller successfully returns 'form.html' to the webpage with the mapping '/form'. Additionally, it tests that the attribute set in the model of the controller 'inputVariables' is not null. Lastly, this test also makes sure that the attribute set in the model of the controller as 'genderList' contains the values 'Male' and 'Female', as expected.
17. I also created another html template linked to a separate webpage called 'info.html', which is linked to a newly added button in 'form.html' and '/form' that displays information on standard drinks and how much each alcoholic beverage has. This gives users a better understanding of how many standard drinks they have consumed, resulting in more accurate Blood Alcohol Content calculations. On this new page, there is also a button that links back to "/form", so once the user better understands how many drinks they have had, they can then input their information in the BAC calculator. 
18. I then created a mapping for '/info' within the controller in order to access the newly created webpage. 
19. Scan over all code and tests to make sure the microservice is running correctly without bugs and errors, data is successfully stored to H2 Database, and that all tests pass.
20. Extract project into a zip file that also includes PowerPoint Presentation, ready for submission on Monday after presenting. 
