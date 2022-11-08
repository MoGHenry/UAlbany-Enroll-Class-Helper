There are three source code inside,  the only one important is the Connecter.java. The Tester.Java can be used to do unit test. test.java is a empty java file can use to do any small test.
The Connecter.java used mysql connector jar, and ClassDatatype.java. The Path to these two file is needed. If it is not build after download, you need to build the path.
There are 3 methods in Connecter.java. sent( ClassDatatype course) is used to sent data into the database. It will sent a message discribe if the transmission is success or not. 
The showDatabase() method print all the data store in the 3 table inside the database. It can be use to check and monitor the database.
closeConnecter() method close the connecter and release resourses.
