DROP
DATABASE
springbootdb;
--creating database
CREATE
DATABASE
springbootdb;

--change to newly created database;
\
connect
springbootdb;

DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS organization;

--users to roles is many to many
--so needs user_role in between
CREATE TABLE roles
(
  role_id   SERIAL,
  role_name varchar(255) NOT NULL,
  role_desc varchar(255) NOT NULL,
  primary key (role_id)
);

--create 3 users , admin ,user, and dev account
INSERT INTO roles (role_id, role_name, role_desc)
VALUES ('1', 'ROLE_DEV', 'super user,gets all privileges');
INSERT INTO roles (role_id, role_name, role_desc)
VALUES ('2', 'ROLE_ADMIN', 'admin , have privileges to modify all user data');
INSERT INTO roles (role_id, role_name, role_desc)
VALUES ('3', 'ROLE_USER', 'site user,basic privileges');

CREATE TABLE users
(
  user_id   SERIAL,
  username  text         NOT NULL UNIQUE,
  password  varchar(255) NOT NULL,
  fname     text         NOT NULL,
  lname     text         NOT NULL,
  status    varchar(255) NOT NULL,
  primary key (user_id),
  create_at TIME,
  update_at TIME
);

CREATE TABLE user_role
(
  user_id int NOT NULL,
  role_id int NOT NULL,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  FOREIGN KEY (role_id) REFERENCES roles (role_id)
);


--hashed password
--gets from EncodePassword.java
--dev@gmail.com  devpass
--admin@gmail.com adminpass
--user@gmail.com  password
INSERT INTO users(user_id, username, password, fname, lname, status)
VALUES ('0', 'dev@gmail.com', '$2a$10$QBbNLRTWEel/fSWqw8KBe.B9luEp6eJCX9Ur3Rp5zqdxJH5ppCGD.', 'jun', 'chen', 'active');

INSERT INTO users(user_id, username, password, fname, lname, status)
VALUES ('1', 'admin@gmail.com', '$2a$10$b0n2EHBhlXf5XIA.MHQ6T.HbjuEaVdPp6lwWZqsoc.TK0vKBXocvO', 'admin', 'admin',
        'active');

INSERT INTO users(user_id, username, password, fname, lname, status)
VALUES ('2', 'user@gmail.com', '$2a$10$wCPNE6hknd8q87RYvQoJNediTftlQml4vJR9XjjFk9ohoOciQxVD6', 'user', 'user',
        'active');

--set accounts roles
INSERT INTO user_role(user_id, role_id)
VALUES ('0', '1');
INSERT INTO user_role(user_id, role_id)
VALUES ('0', '2');
INSERT INTO user_role(user_id, role_id)
VALUES ('1', '2');
INSERT INTO user_role(user_id, role_id)
VALUES ('2', '3');

--/dt list all tables,showing current accounts

SELECT *
FROM user_role
       INNER JOIN users ON user_role.user_id = users.user_id
       INNER JOIN roles ON user_role.role_id = roles.role_id
;

SELECT users.user_id,
       user_role.role_id,
       password,
       fname,
       lname,
       username,
       role_name,
       status,
       create_at,
       update_at
FROM user_role
       INNER JOIN users ON user_role.user_id = users.user_id
       INNER JOIN roles ON user_role.role_id = roles.role_id
;

SELECT
  username,
  role_name
FROM user_role
       INNER JOIN users ON user_role.user_id = users.user_id
       INNER JOIN roles ON user_role.role_id = roles.role_id
where username = 'dev@gmail.com'
;



CREATE TABLE shift
(
  id          SERIAL,
  employee_id SERIAL,
  shift_name  TEXT,
  start_at    TIME NOT NULL,
  end_at      TIME NOT NULL,
  work_day    TEXT,
  work_date   DATE
);



INSERT INTO shift(id, employee_id, shift_name, start_at, end_at, work_day, work_date)
VALUES ('3', '3', 'night', '9:00', '9:00', 'monday', '2019-09-30');

SELECT *
FROM shift;
----------created user and given it's priviliege

/*
-- user create a organization/company profile
CREATE TABLE organization
(
  organization_id SERIAL,
  organization_name varchar(255) NOT NULL,
  organization_desc varchar(255) NOT NULL,
  organization_size INTEGER,
  primary key (organization_id)
);

--create 3 organization: brooklyn college,City College and Baruch College.
INSERT INTO organization(organization_name, organization_desc,organization_size)
VALUES ('Brooklyn College','CUNY_Brooklyn College',16235);
INSERT INTO organization(organization_name, organization_desc,organization_size)
VALUES ('City College','CUNY_City College',5833);
INSERT INTO organization(organization_name, organization_desc,organization_size)
VALUES ('Baruch College','CUNY_Baruch College',23423);

SELECT * FROM organization;

DROP TABLE IF EXISTS facility;
DROP TABLE IF EXISTS organization;
DROP TABLE IF EXISTS location;

DROP TABLE IF EXISTS  department;
DROP TABLE IF EXISTS  employee;
DROP TABLE IF EXISTS information;
DROP TABLE IF EXISTS schedule;


CREATE TABLE organization
(
  organization_id SERIAL,
  organization_name TEXT NOT NULL,
  organization_desc TEXT,
  owner TEXT NOT NULL,
  business_type TEXT NOT NULL,
  employee_size INT,
  create_date DATE,
  PRIMARY KEY (organization_id)
);



----------------------trying to create schedule---------------------



CREATE TABLE employee
(
  employee_id INT,
  department_id INT,
  department_name TEXT,
  user_id INT,
  job_tittle TEXT,
  hire_date DATE NOT NULL,
  leave_date DATE,
  work_email TEXT,
  phone_extension INT
);



INSERT INTO shift(employee_id, shift_name,start_at,end_at,work_day,work_date) VALUES ('0','Day shift','09:00','05:00','Friday','2019-08-30');
INSERT INTO shift(employee_id, shift_name,start_at,end_at,work_day,work_date) VALUES ('0','Day shift','09:00','05:00','Monday','2019-09-02');
INSERT INTO shift(employee_id, shift_name,start_at,end_at,work_day,work_date) VALUES ('1','Day shift','09:00','05:00','Monday','2019-09-02');
INSERT INTO shift(employee_id, shift_name,start_at,end_at,work_day,work_date) VALUES ('2','Day shift','09:00','05:00','Monday','2019-09-02');

  -- facility_id INT,

--need to change the hours to a time to another
--phone is stored as TEXT for readability
CREATE TABLE facility
(
  facility_id SERIAL,
  facility_name varchar(30),
  facility_location SERIAL,
  phone TEXT,
  fax int,
  hour TEXT,
    PRIMARY KEY (facility_id),
    FOREIGN KEY (facility_id) REFERENCES organization(facility_id)
);

--location of the failicty
CREATE TABLE location
(
  location_id SERIAL,
  street TEXT,
  city TEXT,
  state TEXT ,
  zipcode INT,
  location_start DATE NOT NULL,
  location_close DATE,
  last_modified DATE,
    PRIMARY KEY (location_id)
);

INSERT INTO organization(organization_name, organization_desc, facility_id,
            employee_size,owner,business_type ,phone ,email ,entry_type)
VALUES ('Baruch College','CUNY-mostly major in accountant','1','1',
    'Bernard Baruch','school','646-312-1000','admissions@baruch.cuny.edu',current_timestamp);
INSERT INTO organization(organization_name, organization_desc, facility_id,
            employee_size,owner,business_type ,phone ,email ,entry_type)
VALUES ('Brooklyn College','CUNY-mostly major in child study','2','1',
    'Bernie Sander','school','718-951-5000','admissions@brooklyn.cuny.edu',current_timestamp);
INSERT INTO organization(organization_name, organization_desc, facility_id,
            employee_size,owner,business_type ,phone ,email ,entry_type)
VALUES ('City College','CUNY-mostly major in engineering','3','1',
    'Townsend Harris','school','212-650-6977','admissions@city.cuny.edu',current_timestamp);

INSERT INTO facility(facility_name, facility_location, phone, hour)
VALUES ('Baruch College','1','646-312-1000','6:00AM - 10:30PM');
INSERT INTO facility(facility_name, facility_location, phone, hour)
VALUES ('Ingersoll Hall','2','718-951-5000','7:00AM - 11:00PM');
INSERT INTO facility(facility_name, facility_location, phone, hour)
VALUES ('Boylan Hall','2','718-951-5000','7:00AM - 11:00PM');
INSERT INTO facility(facility_name, facility_location, phone, hour)
VALUES ('City College','3','212-650-6977','6:30AM - 10:00PM');


INSERT INTO location(location_id,street, city, state,zipcode, location_start, last_modified)
VALUES ('1','55 Lexington Ave at 24th St','New York','NY','10010',current_timestamp,current_timestamp);
INSERT INTO location(location_id,street, city, state,zipcode, location_start, last_modified)
VALUES ('2','2900 Bedford Avenue','Brooklyn','NY','11210',current_timestamp,current_timestamp);
INSERT INTO location(location_id,street, city, state,zipcode, location_start, last_modified)
VALUES ('4','2900 Bedford Avenue','Brooklyn','NY','11210',current_timestamp,current_timestamp);
INSERT INTO location(location_id,street, city, state,zipcode, location_start, last_modified)
VALUES ('3','160 Convent Avenue','New York','NY','10031',current_timestamp,current_timestamp);


SELECT * FROM organization;
SELECT * FROM facility;
SELECT * FROM location;


SELECT  organization_name, facility_name, street ,city ,state  ,zipcode ,location_start ,facility.phone,hour
FROM organization
INNER JOIN facility ON facility.facility_id = organization.facility_id
INNER JOIN location ON facility.facility_location = location.location_id
WHERE organization_name = 'Brooklyn College';

CREATE TABLE department
(
  department_id INT,
  department_name TEXT,
  department_desc TEXT,
  department_size INT
);


CREATE TABLE information
(
  employee_id INT,
  Fname TEXT,
  Lname TEXT,
  street TEXT,
  city TEXT,
  zipcode INT,
  email TEXT,
  SSN TEXT,
  DOB TEXT,
  phone_number TEXT
);

CREATE TABLE schedule
(
  employee_id INT ,
  work_from  TEXT,
  work_to TEXT,
  work_date DATE
);
*/
