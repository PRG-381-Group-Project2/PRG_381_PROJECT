USE MASTER
GO
IF EXISTS (SELECT* FROM sysdatabases WHERE NAME = 'StudentPortalDB')
	DROP DATABASE StudentPortalDB
GO

CREATE DATABASE StudentPortalDB
ON (
NAME = StudentPortal,
FILENAME = 'C:\Users\Public\Documents\StudentPortal.mdf',
SIZE = 50MB, 
MAXSIZE = 10GB,
FILEGROWTH = 1%)
GO
CREATE LOGIN Theodorus
WITH PASSWORD = 'theopassword'
GO
CREATE USER Theo FOR LOGIN Theodorus
EXEC sp_addrolemember N'db_owner',Theo
GO

Use [StudentPortalDB]
GO

CREATE TABLE Student(
StudentId int PRIMARY KEY identity(1,1),
StudentName varchar(50) not null,
StudentAddress varchar(100) not null,
StudentEmail varchar(50) not null,
StudentPassword varchar(20) not null,
)
GO

INSERT INTO Student(StudentName, StudentAddress, StudentEmail, StudentPassword)VALUES('Karabo','6 Landroes Mare','karabo@gmail.com','karabopassword')
INSERT INTO Student(StudentName, StudentAddress, StudentEmail, StudentPassword)VALUES('Kingsley','345 Hatfield','kingsley@gmail.com','Kingsleypassword')
INSERT INTO Student(StudentName, StudentAddress, StudentEmail, StudentPassword)VALUES('Armand','44 Heatherdale Akasia','Armand@gmail.com','Armandpassword')
INSERT INTO Student(StudentName, StudentAddress, StudentEmail, StudentPassword)VALUES('Omphemetse','4 Jane Furse','Omphemetse@gmail.com','Omphemetsepassword')
INSERT INTO Student(StudentName, StudentAddress, StudentEmail, StudentPassword)VALUES('Josias','18 Parktown','Josias@gmail.com','josiaspassword')

GO

CREATE TABLE Register(
RegisterID int PRIMARY KEY identity(1,1),
CourseName varchar(100) not null,
StudentId int FOREIGN KEY REFERENCES Student(StudentId)
)

GO

INSERT INTO Register(CourseName,StudentId)VALUES('Diploma',1)
INSERT INTO Register(CourseName,StudentId)VALUES('Bachelor Of Information Technology',2)
INSERT INTO Register(CourseName,StudentId)VALUES('Diploma',3)
INSERT INTO Register(CourseName,StudentId)VALUES('Bachelor Of Computing',4)
INSERT INTO Register(CourseName,StudentId)VALUES('Bachelor Of Information Technology',5)

GO

CREATE TABLE Administrator(
AdminId int PRIMARY KEY identity(1,1),
AdminName varchar(50) not null,
AdminPassword varchar(20) not null,
AdminContact nvarchar(10) not null,
)

GO 

INSERT INTO Administrator(AdminName,AdminPassword,AdminContact)VALUES('Theodorus','theopassword','0712345678')

GO

CREATE PROCEDURE spViewStudents
AS
BEGIN
SELECT * FROM Student
END

GO

CREATE PROCEDURE spAddStudent
(
@StudentName varchar(50),
@StudentAddress varchar(100),
@StudentEmail varchar(50),
@StudentPassword varchar(20)
)
AS
BEGIN
INSERT INTO Student(StudentName,StudentAddress,StudentEmail,StudentPassword)
VALUES(@StudentName,@StudentAddress,@StudentEmail,@StudentPassword)
END

GO

CREATE PROCEDURE spRemoveStudent
(
@StudentId INT
)
AS
BEGIN
DELETE FROM Student
WHERE StudentId = @StudentId
END

GO

CREATE PROCEDURE spUpdateStudent
(
@StudentId int,
@StudentName varchar(50),
@StudentAddress nvarchar(100),
@StudentEmail varchar(50),
@StudentPassword varchar(20)
)
AS
BEGIN
UPDATE Student
SET StudentName = @StudentName, StudentAddress = @StudentAddress, StudentEmail = @StudentEmail, StudentPassword = @StudentPassword
WHERE StudentId = @StudentId
END