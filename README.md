# database-audit-spring-boot

What is Database Auditing?
The process of tracking and logging events on the Database is called Database Auditing. Auditing helps us to find out when the changes were made and who has made them. It is a way of preserving the history of records to trace user activity. Eg: Events like Inserting a new record, updating an existing record, or deleting a record.

Database Audit is very important for compliance purposes and also to analyze production issues. Database Audit is a wide area and it is usually done on the Database by the Database Administrator (DBA) who tracks the following activities

Administrative Activity: Eg: creation and deletion of new user accounts
Data Access and Modification: These are events where users view, create, or modify data
Login Failures and User Denials: Eg: User unable to login due to invalid credentials
System-wide Changes: To capture events that occur within a network

Different ways of Auditing a Database
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

What is Hibernate Envers?
Hibernate provides in-built support to audit the table data using various ways like using Interceptors, Event Listeners, and Database Triggers.

But if we wanted a very simpler approacher to audit the persistent entities, then Hibernate provides a core module called Envers which is used for auditing and versioning of persistent classes. The Envers works with many frameworks like WildFly, JBoss AS, Spring, Grails, etc.

Auditing and versioning are key components for building production-level Spring Boot Microservices. Hibernate Envers seamlessly integrates with Spring Boot (Spring Data JPA) to build the production-grade system.
