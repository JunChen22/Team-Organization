# CISC 4900 project
[![Build Status](https://travis-ci.com/JunChen22/4900-alter.svg?branch=master)](https://travis-ci.com/JunChen22/4900-alter)

Jun Hao Chen <br />
Jia Ying Chen

Requirement:
Java 1.8<br />
React 16.0  <br />
PostgreSQL 10.7 <br />
Maven 3.6.0 or later version  <br />
Node package management 6.7 or later

<br />The spec sheet:
https://docs.google.com/document/d/1RnhMbKqBzHtNMnRVJeR-RHDnzEv0AFpr0F2BJrZpz0U/edit


To start:<br />

Database<br />
```
$ psql -U postgres -d springbootdb -f Init.sql
```
Default user is :postgres.
Change postgres to different user needs to <br />
change user and password in application.properties<br />

Server side<br />
```
$ mvn spring-boot::run
```

Client side<br />
```
$ cd view
$ nmp install
$ npm start
```
