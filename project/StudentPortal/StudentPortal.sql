CREATE TABLE [dbo].[Administrator] (
    [AdminId]       INT           IDENTITY (1, 1) NOT NULL,
    [AdminName]     VARCHAR (50)  NOT NULL,
    [AdminPassword] VARCHAR (20)  NOT NULL,
    [AdminContact]  NVARCHAR (10) NOT NULL,
    PRIMARY KEY CLUSTERED ([AdminId] ASC)
);


GO

CREATE TABLE [dbo].[Register] (
    [RegisterID] INT           IDENTITY (1, 1) NOT NULL,
    [CourseName] VARCHAR (100) NOT NULL,
    [StudentId]  INT           NULL,
    PRIMARY KEY CLUSTERED ([RegisterID] ASC),
    FOREIGN KEY ([StudentId]) REFERENCES [dbo].[Student] ([StudentId])
);


GO

CREATE TABLE [dbo].[Student] (
    [StudentId]       INT           IDENTITY (1, 1) NOT NULL,
    [StudentName]     VARCHAR (50)  NOT NULL,
    [StudentAddress]  VARCHAR (100) NOT NULL,
    [StudentEmail]    VARCHAR (50)  NOT NULL,
    [StudentPassword] VARCHAR (20)  NOT NULL,
    PRIMARY KEY CLUSTERED ([StudentId] ASC)
);


GO


CREATE PROCEDURE spViewStudents
AS
BEGIN
SELECT * FROM Student
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

GO

