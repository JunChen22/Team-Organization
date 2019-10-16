INSERT INTO roles (role_id, role_name, role_desc)
VALUES ('1', 'ROLE_DEV', 'super user,gets all privileges');
INSERT INTO roles (role_id, role_name, role_desc)
VALUES ('2', 'ROLE_ADMIN', 'admin , have privileges to modify all user data');
INSERT INTO roles (role_id, role_name, role_desc)
VALUES ('3', 'ROLE_USER', 'site user,basic privileges');

--hashed password
--gets from EncodePassword.java
--dev@gmail.com  devpass
--admin@gmail.com adminpass
--user@gmail.com  password
INSERT INTO users(user_id, username, password, fname, lname, status)
VALUES ('10', 'dev@gmail.com', '$2a$10$QBbNLRTWEel/fSWqw8KBe.B9luEp6eJCX9Ur3Rp5zqdxJH5ppCGD.', 'jun', 'chen', 'active');

INSERT INTO users(user_id, username, password, fname, lname, status)
VALUES ('11', 'admin@gmail.com', '$2a$10$b0n2EHBhlXf5XIA.MHQ6T.HbjuEaVdPp6lwWZqsoc.TK0vKBXocvO', 'admin', 'admin',
        'active');

INSERT INTO users(user_id, username, password, fname, lname, status)
VALUES ('12', 'user@gmail.com', '$2a$10$wCPNE6hknd8q87RYvQoJNediTftlQml4vJR9XjjFk9ohoOciQxVD6', 'user', 'user',
        'active');

INSERT INTO user_role(user_id, role_id)
VALUES ('10', '1');
INSERT INTO user_role(user_id, role_id)
VALUES ('10', '2');
INSERT INTO user_role(user_id, role_id)
VALUES ('11', '2');
INSERT INTO user_role(user_id, role_id)
VALUES ('12', '3');





