# database-audit-spring-boot

## What is Database Auditing?
The process of tracking and logging events on the Database is called Database Auditing. Auditing helps us to find out when the changes were made and who has made them. It is a way of preserving the history of records to trace user activity. Eg: Events like Inserting a new record, updating an existing record, or deleting a record.

Database Audit is very important for compliance purposes and also to analyze production issues. Database Audit is a wide area and it is usually done on the Database by the Database Administrator (DBA) who tracks the following activities

Administrative Activity: Eg: creation and deletion of new user accounts
Data Access and Modification: These are events where users view, create, or modify data
Login Failures and User Denials: Eg: User unable to login due to invalid credentials
System-wide Changes: To capture events that occur within a network

## Different ways of Auditing a Database
There are various ways to Audit a database and I have included some of them as follows

1. Audit using DBMS traces

2. Audit using temporal capabilities

3. Audit using database transaction log files

4. Auditing over the network

5. Audit access directly on the database server

6. Hand-coded audit trails

Hand-coded audit trails
Out of the above 6 approaches, we are only interested in the Hand-Coded audit trail approach which focuses on adding audit columns to the tables and recording the audit values programmatically whenever data is changed.

The following four fields are used for audit in any database table

CreatedBy- This field is used to record the name of the user who has created the record. It can be a human or a system.
CreatedDate- This field is used to store the date on which the record was created.
LastModifiedBy- This field is used to record the name of the user that has updated the record. It can be a human or a system.
LastModifiedDate — This field is used to store the date on which the record was updated.

## What is Hibernate Envers?
Hibernate provides in-built support to audit the table data using various ways like using Interceptors, Event Listeners, and Database Triggers.

But if we wanted a very simpler approacher to audit the persistent entities, then Hibernate provides a core module called Envers which is used for auditing and versioning of persistent classes. The Envers works with many frameworks like WildFly, JBoss AS, Spring, Grails, etc.

Auditing and versioning are key components for building production-level Spring Boot Microservices. Hibernate Envers seamlessly integrates with Spring Boot (Spring Data JPA) to build the production-grade system.

## Steps 
Create Generic Auditable Class with Spring Data Annotations @CreatedBy, @CreatedDate, @LastModifiedBy, and @LastModifiedDate
Create a JPA Entity which extends Auditable Class - User.java
Auditing Author Using AuditorAware and Spring Security
Enable JPA Auditing by Using @EnableJpaAuditing 


## Let's understand important JPA Auditing annotations:

@CreatedDate - Declares a field as the one representing the date the entity containing the field was created.
@LastModifiedDate - Declares a field as the one representing the date the entity containing the field was recently modified.
@CreatedBy- Declares a field as the one representing the principal that created the entity containing the field.
@LastModifiedBy - Declares a field as the one representing the principal that recently modified the entity containing the field.
The Spring Data JPA approach abstracts working with JPA callbacks and provides us these fancy annotations to automatically save and update auditing entities.

## Using the AuditingEntityListener Class With @EntityListeners
Spring Data JPA provides a JPA entity listener class, AuditingEntityListener, which contains the callback methods (annotated with the @PrePersist and @PreUpdate annotations), which will be used to persist and update these properties when we will persist or update our entity.
JPA provides the @EntityListeners annotation to specify callback listener classes, which we use to register our AuditingEntityListener class.
However, we can also define our own callback listener classes if we want to and specify them using the @EntityListeners annotation. 


## Auditing Author Using AuditorAware and Spring Security
JPA can analyze createdDate and lastModifiedDate using the current system time, but what about the createdBy and lastModifiedBy fields? How will JPA recognize what to store in them?
To tell JPA about currently logged-in users, we will need to provide an implementation of AuditorAware and override the getCurrentAuditor() method. And inside getCurrentAuditor(), we will need to fetch a currently logged-in user.
As of now, I have provided a hard-coded user, but if you are using Spring Security, then use it to find the currently logged-in user.

## Enable JPA Auditing by Using @EnableJpaAuditing
Now, we want to enable JPA auditing by specifying @EnableJpaAuditing on one of our configuration classes, in this example, I have specified @EnableJpaAuditing on the main lass. @EnableJpaAuditing accepts one argument, auditorAwareRef, where we need to pass the name of the AuditorAware bean.
