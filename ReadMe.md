# UAlbany Enroll-Class-Helper
- Members: Yunrui Huang, Herry Qiu, Jianxiang Huang

## Description
This project is a user-friendly interface web application to help the UAlbany students enroll in their courses.
This project organize by 4 components: Frontend, middleware, database, backend(script).
All the source code store in `UAlbany-Enroll-Class-Helper/code/` folder.

**The frontend is not complete yet, so some feature will not present. Those feature will present by access backend directly.**


## Frontend
This part is the web user interface for UAlbant students to search courses, plan their schedual, and print the schedual. 

### Run/Compile Environment
### Install and execute



## Middleware
This part is the middleware of the UAlbany-Enroll-Class-Helper, which handle the comminution between the frontend (user interface webpage) to the database. It private two type of Post method to access the course data in database

### Run/Compile Environment
- ASP.NET Core 5.0
- C# 7.0 or higher
- Visual Studio 2022
### Install and execute
#### run local
- download the Visual Studio 2022 or higher version
- install C# and .net 5.0 run environment in Visual Studio installer
- using the Visual Studio open the UAlbany-Enroll-Class-Helper\code\middleware\WebAPI\WebAPI.sln file
- click the run on the top of Visual Studio and you would see a webpage jump up with ICSI210 Json data, it means run success
- note : the database address and information is hardcode in the program, the database may close later so the middleware would not getting any data.
#### run Online
please follow the tutorial of How to Publish an ASP.NET Core app to Azure with Visual Studio on Microsoft document (https://learn.microsoft.com/en-us/aspnet/core/tutorials/publish-to-azure-webapp-using-vs?view=aspnetcore-5.0)

## Database
Here are two database connector source codes used in this project. One is the java-MySQL connector used by the script, one is the .net-MySQL connector used by middleware. The database I used is the MySQL Alibaba cloud database, and the support will end in January.
### java-mysql connector
This is the java-MySQL database connector used in this project. It should be included in the script as part of the source code to connect, modify the data structure, and store it in the database.

There are two methods used by the script. One is the constructor method to create an instance of the connector. One is the send method to modify data format and store it in the database. Other methods is for algorithm implementation or code test.
### dotnet-mysql connector
This is the .net-MySQL database connector source code. It should be included in the middleware source code in order to connect to the database, search for courses, and receive course data.

There are 1 constructure method, 3 search course methods, and 1 algorithm implementation method.

## Backend(script)
This part is the backend of the UAlbany-Enroll-Class-Helper, which handle with download course data from UAlbany website (https://www.albany.edu/registrar/schedule-classes), Converge the HTML file to text file and analysis to java data type, Upload to online SQL database.

### Run/Compile Environment
- Linux environment (we use Ubuntu 20.04)
- Python 3.0
- Java 1.8
- Java MYSQL library (https://dev.mysql.com/downloads/connector/j/)
- Crontab (already install on Ubuntu 20.04)
### Install and execute
#### run directly
-  save the file in Ubuntu system
- `$cd UAlbany-Enroll-Class-Helper/code/script/`
- run the RunScript.sh by `$sudo ./RunScript.sh`
  - If not work, please try set the script as runnable `$sudo chmod o+x RunScript.sh`
- note : the MYSQL server address and information is hardcode in the Java file, it may close and java would throw the error with server not found. If you have you own MYSQL server, please check and update the **src/Connecter.java** file.

#### Run Auto 
- we has using the **Crontab** function on ubuntu to trigger this script automatically
- to do that please use `$crontab -e`
- and then input ` 0 * * * * cd /'the file local'/UAlbany-Enroll-Class-Helper/code/script/;sudo ./RunScript`


