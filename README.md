# Project Title: 

Student Management System.

# Getting Started: 

Setting up and installing this software is easy by just installing Java 14 and MySQL.

# Prerequisites:

**Softwares needed:**
1.	Java 14 (JDK 14).
2.	MySQL.

**Installation links of the required softwares:**
1.	JDK 14: <https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html>
2.	MySQL: <https://dev.mysql.com/downloads/>

# Installing required softwares:

**For Windows users:**
Download JDK 14 and MySQL from the above given download links and install them.

**For Ubuntu/Debian users:**
1.	Install JDK 14 from the above download link for your specific Linux distribution and install it.
2.	To install MySQL, run the following command in the terminal:

        sudo apt-get install mysql-server

**Following the above installation steps for required softwares will set up an environment to run the Student Management System without any hassles.**

# Running the software:

**For Windows users:**
1.  Create a database named as 'demo' in MySQL.
2.  Setup your MySQL credentials in the 'hibernate.cfg.xml' file by changing the 'connection.username' and 'connection.password' fields.
3.  Open your command prompt and navigate to the project's directory and run the following command to compile the Java files:

        javac -cp "hibernate-jars/*";"jfreechart-jars/*" *.java
4.  Run the following command to run the application:

        java -cp "hibernate-jars/*";"jfreechart-jars/*";. MainWindow

**For Ubuntu/Debian users:**
1.  Create a database named as 'demo' in MySQL.
2.  Setup your MySQL credentials in the 'hibernate.cfg.xml' file by changing the 'connection.username' and 'connection.password' fields.
3.  Open your terminal and navigate to the project's directory and run the following command to compile the Java files:

        javac -cp "hibernate-jars/*":"jfreechart-jars/*" *.java
4.  Run the following command to run the application:

        java -cp "hibernate-jars/*":"jfreechart-jars/*":. MainWindow

# Built with:
1.    Java 14 - GUI for the software.
2.    MySQL - Database Management System.

# Author:

    Siddhesh Kudtarkar
