online bookstore
================



Description
---------------
CRUD operations on Books
Checkout operation for single or multiple books which will return the total payable amount.

How to run application using command

    Goto application folder and run below command in terminal

    to build application : ./gradlew build

    to run application : ./gradlew bootRun

How to run on docker :

 Goto application folder and run below command in terminal

 to create docker image : docker build -t bookmanagement:latest .

 to check docker image : docker images

 to run docker image : docker run -p 8081:8080 bookmanagement

How to use restapi
   postman collection committed in repo.


Book Type and discount  : Type(discount)



    FICTION(15)


    COMIC(0)


    JAVA(10)


    PHP(10)


    HORROR(5)


    POLITICAL(20)


    OTHERS(30)
