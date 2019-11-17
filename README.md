# GAMents

A fullstack application with a RESTful api connected to a React front end and microservice back end.

## Tools

* Postman
* LucidChart
* Docker
* Maven

## General Approach 

We first reviewed the technical requirements, necessary deliverables and sketched a wireframe to achieve our project tasks. We reached a consensus that it was important to continousluy clarify our project goals throughout the week to ensure that our project work remained aligned with the initial premise. On Day 1, we listed the model we would need, their end points, and the relationship the tables would have to each other. First, we created a table for Users and UserProfiles where we would establish a one-to-one relationship. Next, we generated a Post and Comment table to allow users to have access to create, delete, and read their comments. We also added functionality to allow users to create and delete their own comments. Most importantly, we designed our project to add security features to provide both authorizationa and authentication to our application.  We created a task list on Trello to visualize what we needed to do at stage of the process. Using the task list, we estimated the time it would take to acccomplish each task to prepare for unforeseen problems in our creative process. Below is a timeline of how we planned our project.


| Day         | 1       | 2       | 3       | 4       | 5       | 6       | 
|------------ |-------- |-------- |-------- |-------- |---------|---------|
|Morning Task |Separated workout flow by working on separate branches to avoid merge conflicts |Added necessary fields to the User, UserProfile, Post, and Comment models |Organize tasks to complete for the day and reviewed the code from the previous day|Organize tasks to complete for the day and reviewed the code from the previous day|Organize tasks to complete for the day and reviewed the code from the previous day|Organize tasks to complete for the day and reviewed the code from the previous day |
|Afternoon Task |Sketched out the tables, relational mapping, endpoints, and ERD diagram |Created User, Comment, and Post tables. Added hiberate dialect in pom.xml|set security to give all users the role USER, created and logged in a user and returned a token |Added endpoints to Post and Comment controllers |Completed unit tests using mocks and stubs/Handled exceptions |Refactored all the domains on the front-end and reach full functionality of the website |
|Evening Task |Launched Spring and created packages for models, repositories, and services. Also, added dependencies to our database |Added Repository interfaces, Controller classes, and jwt token security config |Tested and Refactored endpoints for Users(Signup, Login, List All Users) |Refactored code and tested endpoints |Refactored code and tested endpoints/Began to update routes to connect to our front-end | Update ReadMe(Major Hurdles, User Storie) and begin to redesign front-end |


## Major Hurdles
* Connecting the frontend to the backend due to Cross-origin resource sharing(CORS) issue.
* Fetching the the api from the backend
* Understanding the basic concepts on state and props(passing props). 
* Microservices with Docker : Experienced errors with EntityFactoryManager when Eureka was added to my API


## User Stories
* As a user, I can create an account
* As a user, I can view a feed of posts created by other users that is related to tech and design
* As a user, I can find a mentor online based on skills that I need help with
* As a Mentor, I can support the development of others
