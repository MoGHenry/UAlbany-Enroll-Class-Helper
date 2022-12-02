# Script 

This part is the backend of the UAlbany-Enroll-Class-Helper, which handle with download course data from UAlbany website (https://www.albany.edu/registrar/schedule-classes), Converge the HTML file to text file and analysis to java data type, Upload to online SQL database.

## Run/Compile Environment

- Linux environment (we use Ubuntu 20.04)
- Python 3.0
- Java 1.8
- Java MYSQL library (https://dev.mysql.com/downloads/connector/j/)
- Crontab (already install on Ubuntu 20.04)



## Install and execute

### run directly

-  save the file in Ubuntu system
- `$cd UAlbany-Enroll-Class-Helper/code/script/`
- run the RunScript.sh by `$sudo ./RunScript.sh`
  - If not work, please try set the script as runnable `$sudo chmod o+x RunScript.sh`
- note : the MYSQL server address and information is hardcode in the Java file, it may close and java would throw the error with server not found. If you have you own MYSQL server, please check and update the **src/Connecter.java** file.



## Run Auto 

- we has using the **Crontab** function on ubuntu to trigger this script automatically
- to do that please use `$crontab -e`
- and then input ` 0 * * * * cd /'the file local'/UAlbany-Enroll-Class-Helper/code/script/;sudo ./RunScript`