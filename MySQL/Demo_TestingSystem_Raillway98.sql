/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/
DROP DATABASE IF EXISTS Testing_System;
CREATE DATABASE Testing_System;
USE Testing_System;

/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/

-- create table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL
);

-- create table 2: Posittion
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','Scrum Master','PM') NOT NULL
);

-- create table 3: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED ,
    PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID) ON DELETE CASCADE,
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID) ON DELETE CASCADE
);

-- create table 4: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId) ON DELETE CASCADE
);

-- create table 5: GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY(GroupID) 		REFERENCES `Group`(GroupID) ON DELETE CASCADE
);

-- create table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 		ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE KEY
);

-- create table 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID) ON DELETE CASCADE,
    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId) ON DELETE CASCADE 
);

-- create table 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    AnswerID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE
);

-- create table 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`					CHAR(10) NOT NULL,
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId) ON DELETE CASCADE
);

-- create table 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
    ExamID				TINYINT UNSIGNED NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE,
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID) ON DELETE CASCADE,
    PRIMARY KEY (ExamID,QuestionID)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName) 
VALUES
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);
    
-- Add data position
INSERT INTO Position	(PositionName	) 
VALUES 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			); 


-- Add data Account
INSERT INTO `Account`(Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUES 				('Email1@gmail.com'				, 'Username1'		,'Fullname1'				,   '5'			,   '1'		,'2020-03-05'),
					('Email2@gmail.com'				, 'Username2'		,'Fullname2'				,   '1'			,   '2'		,'2020-03-05'),
                    ('Email3@gmail.com'				, 'Username3'		,'Fullname3'				,   '2'			,   '2'		,'2020-03-07'),
                    ('Email4@gmail.com'				, 'Username4'		,'Fullname4'				,   '3'			,   '4'		,'2020-03-08'),
                    ('Email5@gmail.com'				, 'Username5'		,'Fullname5'				,   '4'			,   '4'		,'2020-03-10'),
                    ('Email6@gmail.com'				, 'Username6'		,'Fullname6'				,   '6'			,   '3'		,'2020-04-05'),
                    ('Email7@gmail.com'				, 'Username7'		,'Fullname7'				,   '2'			,   '2'		, NULL		),
                    ('Email8@gmail.com'				, 'Username8'		,'Fullname8'				,   '8'			,   '1'		,'2020-04-07'),
                    ('Email9@gmail.com'				, 'Username9'		,'Fullname9'				,   '2'			,   '2'		,'2020-04-07'),
                    ('Email10@gmail.com'			, 'Username10'		,'Fullname10'				,   '10'		,   '1'		,'2020-04-09');

-- Add data Group
INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
VALUES 				(N'Testing System'		,   5			,'2019-03-05'),
					(N'Development'			,   1			,'2020-03-07'),
                    (N'VTI Sale 01'			,   2			,'2020-03-09'),
                    (N'VTI Sale 02'			,   3			,'2020-03-10'),
                    (N'VTI Sale 03'			,   4			,'2020-03-28'),
                    (N'VTI Creator'			,   6			,'2020-04-06'),
                    (N'VTI Marketing 01'	,   7			,'2020-04-07'),
                    (N'Management'			,   8			,'2020-04-08'),
                    (N'Chat with love'		,   9			,'2020-04-09'),
                    (N'Vi Ti Ai'			,   10			,'2020-04-10');

-- Add data GroupAccount
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    1		,'2019-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	1		,    3		,'2020-04-06'),
							(	1		,    7		,'2020-04-07'),
							(	8		,    3		,'2020-04-08'),
							(	1		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');


-- Add data TypeQuestion
INSERT INTO TypeQuestion	(TypeName			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	); 


-- Add data CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);
													
-- Add data Question
INSERT INTO Question	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					(N'Câu hỏi về Java'	,	1		,   '1'			,   '2'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'			,   '2'		,'2020-04-05'),
						(N'Hỏi về C#'		,	9		,   '2'			,   '3'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'			,   '4'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	5		,   '1'			,   '5'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'			,   '6'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'			,   '7'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'			,   '8'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'			,   '9'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'			,   '10'	,'2020-04-07');

-- Add data Answers
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   1			,	1		),
                    (N'Trả lời 03'	,   1			,	0		),
                    (N'Trả lời 04'	,   1			,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   9			,	1		),
                    (N'Trả lời 10'	,   10			,	1		);
	
-- Add data Exam
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('VTIQ001'		, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	10			,	60		,   '2'			,'2019-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
                    ('VTIQ009'		, N'Đề thi ADO.NET'		,	4			,	90		,   '9'			,'2020-04-07'),
                    ('VTIQ010'		, N'Đề thi ASP.NET'		,	7			,	90		,   '10'		,'2020-04-08');
                    
                    
-- Add data ExamQuestion
INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	1	,		5		),
						(	2	,		10		), 
						(	3	,		4		), 
						(	4	,		3		), 
						(	5	,		7		), 
						(	6	,		10		), 
						(	7	,		2		), 
						(	8	,		10		), 
						(	9	,		9		), 
						(	10	,		8		); 
                        
-- Lấy dữ liệu để sử dụng:
-- Lấy ra tất cả danh sách Account đang có trên hệ thống
SELECT * FROM Account;
SELECT * FROM Department;
SELECT * FROM Position;
-- Lấy ra tất cả danh sách Account hiển thị thông tin AccountID, Email, Fullname

SELECT AccountID, Email, FullName FROM Account;
SELECT DISTINCT(Fullname) FROM Account;

-- Lấy ra tất cả Account mà thuộc phòng ban số 1(DepartentID =1)  ==> Điều kiện DepartentID =1
SELECT * FROM Account WHERE DepartmentID=6;

SELECT * FROM Account WHERE DepartmentID = 2 AND PositionID= 3;  -- Và
SELECT * FROM Account WHERE DepartmentID = 2 OR PositionID= 3; -- Hoặc

-- Lấy ra tất cả Account mà có DepartmentID =2 ,3,7
SELECT * FROM Account WHERE DepartmentID = 2 OR DepartmentID = 3 OR DepartmentID = 7;
SELECT * FROM Account WHERE DepartmentID IN (2,3,7); -- Trong tập
SELECT * FROM Account WHERE DepartmentID NOT IN (2,3,7);  -- NOT: phủ định

SELECT * FROM Account WHERE DepartmentID IN (1,2,3,4,5,6);  -- Dãy số liên tiếp 1 -6
SELECT * FROM Account WHERE DepartmentID BETWEEN 1 AND 20;

SELECT * FROM Account WHERE CreateDate IS NULL;  -- null: Trống rỗng, không có dữ liệu
SELECT * FROM Account WHERE CreateDate IS NOT NULL ; 

SELECT * FROM Account WHERE CreateDate > '2020-01-01 00:00:00'; 

-- Lấy ra tất cả các bản ghi trong bảng Account, mà có fullname bắt đầu bằng chữ N
SELECT * FROM Account WHERE FullName Like N'N%';
SELECT * FROM Account WHERE FullName LIKE  'N%'; -- Like: Sử dụng để so sánh gần đúng.

-- Lấy ra tất cả các bản ghi trong bảng Account, mà fullname có chữ thứ 2 là u  -- Full
SELECT * FROM Account WHERE FullName LIKE  '_u%';
-- Like
-- Wildcard  
-- %: thay thế cho nhiều ký tự
-- _T: thay thế cho 1 ký tự

-- Hãy đếm số bản ghi trong bảng Account
SELECT * FROM Account;
SELECT COUNT(*) FROM Account;  -- Hàm- Function  count()-- Đếm số bản ghi trong kết quả đầu ra
SELECT COUNT(1) FROM Account;

SELECT *,(1) FROM Account;

SELECT COUNT(CreateDate) FROM Account;

SELECT length(Fullname) FROM Account;  -- 9 ký tự

SELECT UPPER('NguyenQuanDAO');
SELECT NOW();
SELECT curdate();
SELECT curtime();

DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student`(
     Id		                    TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	 Student_Name				VARCHAR(50) NOT NULL,
     Subject_Name		      	VARCHAR(50) NOT NULL,
     Point_Student				TINYINT
);
SELECT * FROM Student;
INSERT INTO Student (Student_Name, Subject_Name, Point_Student)
VALUES				('Name1',	'Sql', 		'7'),
					('Name2',	'Java', 	'8'),
                    ('Name3',	'Java', 	'9'),
                    ('Name4',	'Sql', 		'5'),
                    ('Name5',	'Java', 	'4'),
                    ('Name6',	'Spring', 	'5'),
                    ('Name7',	'Java', 	'8'),
                    ('Name8',	'Spring', 	'8'),
					('Name9',	'Sql', 	'5'),
                    ('Name10',	'Spring', 	'4'),
                    ('Name11',	'Sql', 	'5'),
                    ('Name12',	'Spring', 	'8'),
                    ('Name13',	'Sql', 	'8')
                    ;

SELECT * FROM Student;
-- Tỉnh tổng điểm của các bạn học viên
SELECT SUM(Point_Student) FROM Student;

-- Tìm điểm số lớn nhất và nhỏ nhất, điểm số trung bình trong bảng điểm
SELECT Max(Point_Student) FROM Student;
SELECT MIN(Point_Student) FROM Student;
SELECT AVG(Point_Student) FROM Student;

-- Đánh Alias cho trường dữ liệu, hoặc cho bảng dữ liệu
SELECT s.Student_Name, s.Subject_Name FROM student s;

-- Tìm điểm số lớn nhất của môn sql
SELECT Subject_Name, MAX(Point_Student) AS Sql_Score FROM Student  WHERE Subject_Name = 'Sql';
-- Tìm điểm số lớn nhất của môn java
SELECT Subject_Name, MAX(Point_Student) AS Java_Score FROM Student WHERE Subject_Name = 'Java';
-- Tìm điểm số lớn nhất của môn spring
SELECT Subject_Name, MAX(Point_Student) Spring_Score FROM Student WHERE Subject_Name = 'Spring';

-- 
SELECT 'Sql' AS Subject_Name, MAX(Point_Student) AS Sql_Point FROM Student WHERE Subject_Name = 'Sql'
UNION 
SELECT 'Java' AS Subject_Name, MAX(Point_Student) AS Java_Point FROM Student WHERE Subject_Name = 'Java'
UNION 
SELECT 'Spring' AS Subject_Name, MAX(Point_Student) AS Spring_Point FROM Student WHERE Subject_Name = 'Spring';

SELECT * FROM Student;

--
SELECT Subject_Name, max(Point_Student) FROM student 
GROUP BY Subject_Name;

-- Đếm số lượng học viên trong mỗi môn học, Chỉ hiển thị những môn học có ít nhất 4 bạn học viên >=4
SELECT Subject_Name,count(*) AS Amount FROM student  
GROUP BY Subject_Name
HAVING count(*) >= 4;

-- ORDER BY
-- ASC: Tăng dần- Mặc định
-- DESC: Giảm dần
SELECT * FROM student ORDER BY Subject_Name DESC;
SELECT * FROM student ORDER BY Point_Student ASC;

SELECT * FROM student LIMIT 5;

SELECT * FROM student LIMIT 5, 5;

SELECT * FROM student
LIMIT 5 OFFSET 5;

-- Update: Cập nhật dữ liệu
UPDATE student SET Point_Student=10 WHERE Id = 2;
-- Cập nhật điểm của môn Sql = 8
UPDATE student SET point_student = 8 WHERE Subject_Name = 'Sql';
UPDATE Student SET Point_Student = 8 WHERE Subject_Name = 'Sql'
  AND Id > 0;
SELECT * FROM student WHERE Subject_Name = 'sql';

update student set point_Student = 8 where Subject_name = n'sql';
-- DELETE Xóa dữ liệu

DELETE FROM student WHERE id = 1;
DELETE FROM student WHERE Point_Student = 8;

SELECT * FROM student;

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT max(length(FullName)) FROM account;   -- 12
-- SELECT * FROM Account ORDER BY LENGTH(FullName) DESC LIMIT 1;
-- SELECT length('Nguyen Hai Lam') FROM Dual;


-- SubQuery
SELECT FullName, length(FullName)  Fullname_LENGTH  FROM account 
WHERE length(FullName) = (SELECT max(length(FullName)) FROM account);


WITH cte_MaxLengthFullname AS(
	SELECT max(length(FullName)) Max_Fullname FROM account
--     SELECT max(length(FullName)) Max_Fullname FROM account
--     SELECT max(length(FullName)) Max_Fullname FROM account
--     SELECT max(length(FullName)) Max_Fullname FROM account
--     SELECT max(length(FullName)) Max_Fullname FROM account
--     SELECT max(length(FullName)) Max_Fullname FROM account
)
SELECT *  FROM account 
WHERE length(FullName) = (SELECT Max_Fullname FROM cte_MaxLengthFullname);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3


-- INNER JOIN?
SELECT a.AccountID, a.Email, a.FullName, d.DepartmentName FROM `account` a
INNER JOIN department d ON a.DepartmentID = d.DepartmentID;

SELECT * FROM `account` a
INNER JOIN department d ON a.DepartmentID = d.DepartmentID;

SELECT * FROM account;  -- DepartmentID null

-- LEFT JOIN
SELECT * FROM `account` a
LEFT JOIN department d ON a.DepartmentID = d.DepartmentID;
-- <==>
SELECT * FROM `department` d
RIGHT JOIN account a ON a.DepartmentID = d.DepartmentID;

-- RIGHT JOIN
SELECT * FROM `account` a
RIGHT JOIN department d ON a.DepartmentID = d.DepartmentID;
-- <==>
SELECT * FROM department a
LEFT JOIN account d ON a.DepartmentID = d.DepartmentID;

SELECT * FROM department;

-- LEFT EXCLUDING JOIN
SELECT * FROM `account` a
LEFT JOIN department d ON a.DepartmentID = d.DepartmentID
WHERE d.DepartmentID IS NULL;


-- RIGHT EXCLUDING JOIN
SELECT * FROM `account` a
RIGHT JOIN department d ON a.DepartmentID = d.DepartmentID
WHERE a.DepartmentID IS NULL;


SELECT *  FROM account a
INNER JOIN department d ON a.DepartmentID = d.DepartmentID
UNION
SELECT *  FROM account a
RIGHT JOIN department d ON a.DepartmentID = d.DepartmentID
UNION
SELECT *  FROM account a
LEFT JOIN department d ON a.DepartmentID = d.DepartmentID;

SELECT * FROM account a
LEFT JOIN department d ON a.DepartmentID = d.DepartmentID
UNION
SELECT * FROM account a
RIGHT JOIN department d ON a.DepartmentID = d.DepartmentID;

SELECT * FROM account 
RIGHT JOIN department ON account.AccountID=department.DepartmentID
UNION 
SELECT * FROM account 
LEFT JOIN department ON account.AccountID=department.DepartmentID;

SELECT * FROM Account  A
Left JOIN Department D  ON A.DepartmentID = D.DepartmentID
UNION 
SELECT * FROM Account  A
RIGHT JOIN Department D ON A.DepartmentID = D.DepartmentID
WHERE A.DepartmentID IS NULL;


-- Chữa bài tập
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >=3 nhân viên
-- Xác định ra các bảng dữ liệu liên quan: Account, Deartment

SELECT DepartmentID, count(*) FROM account 
GROUP BY DepartmentID
HAVING count(*)  >=3;






