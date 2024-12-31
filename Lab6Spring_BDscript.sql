Create Database college_db;
SHOW DATABASES;
USE college_db;
SHOW TABLES;
SELECT * FROM roles;
SELECT * FROM student;
SELECT * FROM users;
SELECT * FROM users_roles;

INSERT INTO users (username, password) VALUES ('Samiksha', '$2a$12$8gzmzp1bVKrJIEtXcGkO0evDuCoZoxj0iZOQX2G9qhRhFW2XEVx2a');

INSERT INTO users (username, password) VALUES ('Sanjana', '$2a$12$gkcADrDiHn9TMljE9XAJw.ybdlcOlJUCZ5cfrTchKgM2IPVREsW8u');

INSERT INTO roles(name) VALUES ('USER'),('ADMIN');
INSERT INTO users_roles(user_id, role_id) VALUES (1,2),(2,1);


