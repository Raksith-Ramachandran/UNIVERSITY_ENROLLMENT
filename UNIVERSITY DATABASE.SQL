CREATE DATABASE university; 
USE university; 
CREATE TABLE students ( 
id INT AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(255), 
age INT); 
CREATE TABLE courses ( 
id INT AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(255), 
faculty VARCHAR(255) 
); 
INSERT INTO students (name, age) VALUES ('Balaji,20); 
INSERT INTO students (name, age) VALUES ('Sarvesh',20); 
INSERT INTO courses (name, faculty) VALUES ('Mathematics', 'Dr. john'); 
INSERT INTO courses (name, faculty) VALUES ('Physics', 'Prof. Durairaj'); 