Store Application API

Description : Store Application software tool to store its products and manage them.

project tools :
 * Glassfish 
 * Netbeans
 * Jpa
 * Spring mvc
 * spring Rest
 * Mysql

Run Project 

 ** you can deploy war to use API if you did't wont to clean and build source  war 
    path > /StoreApplicationAPI/target/StoreApplicationAPI.war   **


1- Download or Clone Project from GetHub.
2- Import DataBase Dump. 
3- Import Project on IDE (Prefered Netbeans).
4- Configure datasourse Connection Properties.
   - From src\main\webapp\WEB-INF\dataSourceConnection.properties
   - Open dataSourceConnection.properties configure your own connection.

5- Clean and Build project Then Click Run.
6- Read Store Application API to can use api. 



7- to run unit test 
 - un comment @test annotation
 - disable filter from web.xml
   // comment this lines 
   <filter>
        <filter-name>errorHandlerFilter</filter-name>
        <filter-class>com.orange.StoreApplication.ErrorHandleFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>errorHandlerFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

