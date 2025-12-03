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
-- Xác định bảng dữ liệu gốc: Account
SELECT a.DepartmentID, d.DepartmentName, count(*) Amount FROM account  a
INNER JOIN department d ON a.DepartmentID = d.DepartmentID
GROUP BY DepartmentID
HAVING count(*)  >=3;

SELECT * FROM account;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
-- Question, Exam, examquestion
-- Bảng dữ liệu gốc: examquestion
WITH cte_amount_question AS (
	SELECT count(*) amount FROM examquestion
	GROUP BY QuestionID
)
SELECT ex.QuestionID, q.Content, Count(*) FROM examquestion ex
INNER JOIN question q  ON q.QuestionID = ex.QuestionID
GROUP BY ex.QuestionID
HAVING COUNT(*) = (SELECT max(amount) FROM cte_amount_question) ;


-- Tìm hiểu VIEW trong MySQL
SELECT a.AccountID, a.Email, a.Username,a.FullName, d.DepartmentName FROM account a 
INNER JOIN department d ON a.DepartmentID = d.DepartmentID;

-- Tạo 1 lần
CREATE OR REPLACE VIEW vw_AccountList AS 
	SELECT a.AccountID, a.Email, a.Username,a.FullName, d.DepartmentName FROM account a 
	INNER JOIN department d ON a.DepartmentID = d.DepartmentID;

SELECT * FROM vw_AccountList;
DROP VIEW vw_AccountList;
-- Hạn chế truy cập vào những bảng dữ liệu chính

create or replace view  VW as 
SELECT a.*, d.* FROM account a
inner JOIN department d ON a.DepartmentID = d.DepartmentID;


CREATE OR REPLACE VIEW vw_AccoutList_Sale AS 
	SELECT a.AccountID ,a.Username ,a.FullName ,a.DepartmentID , d.DepartmentName FROM account a
    INNER JOIN department d ON a.departmentID = d.departmentID 
    Where departmentName = 'Sale';
    
SELECT * FROM vw_AccoutList_Sale ;


CREATE OR REPLACE VIEW vw_group_max_mem AS 
WITH cte_maxAccount AS(
SELECT count(*) ma FROM GroupAccount
GROUP BY GroupID
)
SELECT a.*,ga.GroupID, count(*) FROM Account a
JOIN GroupAccount ga ON ga.AccountID=a.AccountID
GROUP BY GroupID
HAVING count(*) = (SELECT max(ma) FROM cte_maxAccount);

CREATE OR REPLACE VIEW vw_groupAccount AS
WITH cte_maxAccount AS(
SELECT count(*) AS Amount FROM groupaccount ga
GROUP BY ga.AccountID
)
SELECT ga.AccountID, a.FullName, COUNT(*) Amount FROM groupaccount ga
INNER JOIN account a ON a.AccountID = ga.AccountID
GROUP BY ga.AccountID
HAVING COUNT(*) = (SELECT max(Amount) FROM cte_maxAccount);

SELECT * FROM groupaccount;

-- Nhóm: groupID: Group có bao nhiêu account tham gia
-- Nhóm: accountID: account tham gia vào những group nào
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW vw_content_300 AS
SELECT * FROM question
WHERE length(Content)>300;

DROP VIEW vw_content_300;

-- Stored Procedure
-- Tạo 1 sp lấy danh sách account
SELECT * FROM account;

DROP PROCEDURE IF EXISTS sp_getListAccount;

DELIMITER $$
CREATE PROCEDURE sp_getListAccount()
	BEGIN
		SELECT * FROM account;
	END$$
DELIMITER ;

CALL sp_getListAccount();

-- Tạo 1 sp lấy account có id =2

DROP PROCEDURE IF EXISTS sp_getAccountByAccountID;
DELIMITER $$
CREATE PROCEDURE sp_getAccountByAccountID(IN in_AccountID TINYINT)
	BEGIN
		SELECT * FROM account WHERE AccountID =  in_AccountID;
	END$$
DELIMITER ;

CALL sp_getAccountByAccountID(5);

-- Viết SP để Insert dữ liệu vào bảng Account với thông tin đầu vào qua các tham số
DROP PROCEDURE IF EXISTS sp_insertAccount;
DELIMITER $$
CREATE PROCEDURE sp_insertAccount(
    IN p_Email VARCHAR(50),
    IN p_Username VARCHAR(50),
    IN p_FullName VARCHAR(100),
    IN p_DepartmentID TINYINT UNSIGNED,
    IN p_PositionID TINYINT UNSIGNED
)
BEGIN
    INSERT INTO Account (Email, Username, FullName, DepartmentID, PositionID)
    VALUES (p_Email, p_Username, p_FullName, p_DepartmentID, p_PositionID);
END$$
DELIMITER ;
CALL sp_insertAccount(
    'nguyenvana@gmail.com',
    'nguyenvana',
    'Nguyễn Văn Á Á À',
    2,   
    1    
);

CALL sp_insertAccount(
    'nguyenvana_1@gmail.com',
    'nguyenvana_1',
    'Nguyễn Văn Á Á À_1',
    2,   
    1    
);
SELECT * FROM account;

-- Xóa tài khoản người dùng theo ID
DROP PROCEDURE IF EXISTS sp_DeleteAccountByID;
DELIMITER $$
CREATE PROCEDURE sp_DeleteAccountByID(
    IN p_AccountID TINYINT UNSIGNED
)
BEGIN
    DELETE FROM account WHERE AccountID =p_AccountID;
END$$
DELIMITER ;
CALL sp_DeleteAccountByID(1);
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
-- Lấy ra fullname của account theo accountId nhập vào
DROP PROCEDURE IF EXISTS sp_getFullnameByAccountId;
DELIMITER $$
CREATE PROCEDURE sp_getFullnameByAccountId(IN in_accountId TINYINT, OUT out_fullname VARCHAR(50))
BEGIN
    SELECT FullName INTO out_fullname FROM account WHERE AccountID= in_accountId;
END$$
DELIMITER ;

-- CALL sp_getFullnameByAccountId(4);
-- CALL sp_getFullNameByAccountId(4,out_fullname );
-- Khai báo ra biến để lưu trữ dữ liệu đầu ra 
SET @v_fullname = " ";

CALL sp_getFullNameByAccountId(6,@v_fullname);

SELECT @v_fullname;

-- Khai báo biến, phạm vi sử dụng
-- Sử dụng SET-- Khai báo biến theo Session
SET @myName = "daonq";
SELECT @myName;
SET @myName = "Nguyễn Quang Đạo";
SELECT @myName;
-- 
SELECT FullName INTO @myName FROM account WHERE AccountID = 1;
SELECT @myName;

-- Khai báo biến theo Local 

DROP PROCEDURE IF EXISTS sp_testVariable;
DELIMITER $$
CREATE PROCEDURE sp_testVariable()
BEGIN
    -- khai báo biến ở đây, trong sp==> phạm vi Local
    DECLARE number1 INT;
    DECLARE number2 INT DEFAULT 10;  -- number = 10
    
    -- Thay đổi giá trị của biến
    SET number1 = 20;  -- number =20
    SELECT 50 INTO number2;  
    
    SELECT number1, number2;
END$$
DELIMITER ;

CALL sp_testVariable();

 -- SELECT number1, number2;
 
 -- Hệ thống
 SELECT @@version;

-- Function- Hàm

SELECT count(*) FROM account WHERE length(fullname) >6;
-- Xây dựng 1 function dùng để tính tổng

SET GLOBAL log_bin_trust_function_creators = 1;  -- Cho tao Function 
SELECT @@log_bin_trust_function_creators;  -- 0  --> Không cho phép tạo các function

DROP FUNCTION IF EXISTS f_sum;
DELIMITER $$   
CREATE FUNCTION f_sum(number1 INT, number2 INT) RETURNS INT  -- 1 giá trị
BEGIN   
	DECLARE v_result INT;
	SET v_result = number1 + number2;
	RETURN v_result;  
END $$  


SELECT f_sum(1,2) as Sum_Result;

-- Viết hàm để lấy ra username từ email
-- f_getUsernameFromEmail('daonq@vti.com.vn')   ==> username: daonq

DROP FUNCTION IF EXISTS f_getUsernameFromEmail ;
DELIMITER $$   
CREATE FUNCTION f_getUsernameFromEmail (p_Email VARCHAR(50)) RETURNS VARCHAR(50)
BEGIN   
	DECLARE v_username VARCHAR(50) ;
    SELECT SUBSTRING_INDEX(p_Email,'@', 1) INTO v_username;  -- lấy được username
    
	RETURN v_username;  
END $$  
SELECT f_getUsernamefromEmail ("daonq@vti.com.vn") AS Username ;
SELECT f_getUsernamefromEmail ("huyht@gmail.com.vn") AS Username ;

-- Viết hàm tính xem Account đã được tạo bao nhiêu ngày
Select * From Account;

DROP FUNCTION IF EXISTS f_account_days;
DELIMITER $$   
CREATE FUNCTION f_account_days(p_accountId TINYINT) RETURNS INT
BEGIN   
	DECLARE v_days INT;
    SELECT DATEDIFF(NOW(), CreateDate ) INTO v_days FROM Account WHERE AccountID= p_accountId;  -- lấy được username
	RETURN v_days;  
END $$  

SELECT f_account_days(1);


-- Question 4: Tạo store Procedure để trả ra id của type question có nhiều câu hỏi nhất
SELECT * FROM testing_system.typequestion;
SELECT * FROM testing_system.question;

WITH cte_amount_TypeQuestion AS (
	SELECT count(*) as amount FROM question q GROUP BY q.TypeID
)
SELECT q.TypeID, tq.TypeName, count(*) Amount FROM question q
INNER JOIN typequestion tq ON q.TypeID = tq.TypeID
GROUP BY q.TypeID
HAVING count(*) = (SELECT max(amount) FROM cte_amount_TypeQuestion);



DROP PROCEDURE IF EXISTS sp_getMaxTypeQuestion;
DELIMITER $$
CREATE PROCEDURE sp_getMaxTypeQuestion()
BEGIN
	  WITH cte_amount_TypeQuestion AS (
		SELECT count(*) as amount FROM question q GROUP BY q.TypeID
	)
	SELECT q.TypeID, tq.TypeName, count(*) Amount FROM question q
	INNER JOIN typequestion tq ON q.TypeID = tq.TypeID
	GROUP BY q.TypeID
	HAVING count(*) = (SELECT max(amount) FROM cte_amount_TypeQuestion);
END$$
DELIMITER ;

CALL sp_getMaxTypeQuestion();

-- Mở rộng: đưa 1 ngày nào đó 1/11/2025 (IN)
-- Sau khi có KQ ==> Đầu ra: Id của TypeQuesstion và Số lượng câu hỏi (OUT)

-- Trigger MySQL  --
SELECT * FROM account;
INSERT INTO `testing_system`.`account` (`Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`) 
VALUES ('Test@gmail.com', 'Test', 'Test', '10', '1', '2020-04-09 00:00:00');
-- ==> trigger
DROP TRIGGER IF EXISTS trg_bf_Insert_Account;
DELIMITER $$
	CREATE TRIGGER trg_bf_Insert_Account
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN		
		-- Đếm số lượng bản ghi có trong bảng Account hiện tại
		DECLARE v_count_Acccount SMALLINT DEFAULT 0;
		SELECT COUNT(*) INTO v_count_Acccount FROM account;
		IF (v_count_Acccount >= 8) THEN 
			-- Dừng chương trình
            SIGNAL SQLSTATE '45000'
            -- Thông báo
            SET MESSAGE_TEXT = 'Cant add more Account';            
        END IF;
    END$$
DELIMITER ;

SHOW TRIGGERS;

-- Viết trigger không cho phép xóa bản ghi có username là admin ở bảng Account
DELETE FROM account WHERE Username = "Admin";

DROP TRIGGER IF EXISTS trg_bf_Delete_Account;
DELIMITER $$
	CREATE TRIGGER trg_bf_Delete_Account
    BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN	
		IF (OLD.Username = 'Admin') THEN 
			-- Dừng chương trình
            SIGNAL SQLSTATE '45000'
            -- Thông báo
            SET MESSAGE_TEXT = 'Cant delete this Record';            
        END IF;
    END$$
DELIMITER ;

SHOW TRIGGERS;

-- Viết trigger cho phép khi nhân viên chuyển phòng ban, thì lưu thông tin phòng ban trước đó vào 1 bảng dữ liệu khác
-- 2
DROP TABLE IF EXISTS `log_Dep_Change_Account`;
CREATE TABLE `log_Dep_Change_Account`(
	Id 						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	AccountID				TINYINT UNSIGNED,
    Username				VARCHAR(50) NOT NULL,
    OldDepartmentName		NVARCHAR(50) NOT NULL,
	NewDepartmentName		NVARCHAR(50) NOT NULL,
    ChangeDate				DATETIME DEFAULT NOW()
);

UPDATE `account` SET `DepartmentID` = '4' WHERE (`AccountID` = '8');

DROP TRIGGER IF EXISTS trg_af_Update_Account;
DELIMITER $$
	CREATE TRIGGER trg_af_Update_Account
    AFTER UPDATE ON `account`
    FOR EACH ROW
    BEGIN	
	DECLARE v_DepartmentName VARCHAR(50);
    DECLARE v_New_DepartmentName VARCHAR(50);
    
    
    
    SELECT DepartmentName INTO v_DepartmentName FROM department WHERE DepartmentID  = OLD.DepartmentID;
    SELECT DepartmentName INTO v_New_DepartmentName FROM department WHERE DepartmentID  = NEW.DepartmentID;

		-- Lấy thông tin phòng ban cũ, lưu lại vào bảng log
        INSERT INTO `log_dep_change_account` (`AccountID`, `Username`, `OldDepartmentName`,`NewDepartmentName`, `ChangeDate`) 
        VALUES (OLD.AccountID, OLD.Username, v_DepartmentName,v_New_DepartmentName , now());
    END$$
DELIMITER ;

SHOW TRIGGERS;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 account
-- Tạo trigger trước khi insert vào bảng GroupAccount
-- Lấy ra tổng số groupid trong groupaccount 
-- Điều kiện >5

SELECT * FROM groupaccount;
INSERT INTO `groupaccount` (`GroupID`, `AccountID`,		 `JoinDate`) 
VALUES						 ('3', 		'5', 		'2025-04-08 00:00:00');


DROP TRIGGER IF EXISTS trg_bf_Insert_GroupAccount;
DELIMITER $$
	CREATE TRIGGER trg_bf_Insert_GroupAccount
    BEFORE INSERT ON `groupaccount`
    FOR EACH ROW
    BEGIN	
		-- Đếm số lượng Account đang có trong Group mà cần thêm dữ liệu
        DECLARE v_count_acount_inGroup  MEDIUMINT DEFAULT 0;
        SELECT count(*) INTO v_count_acount_inGroup FROM groupaccount WHERE GroupID = NEW.GroupID;  -- 1
		IF (v_count_acount_inGroup >=5) THEN 
				-- Dừng chương trình
				SIGNAL SQLSTATE '45000'
				-- Thông báo
				SET MESSAGE_TEXT = 'Cant add this Record';            
		END IF;
    END$$
DELIMITER ;


-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
SELECT * FROM examquestion;
-- Gen 10 câu lệnh Insert vào bảng examquestion có cấu trúc như hình
	-- Thông tin bảng exam và question như hình
    -- ExamId , QuestionID là Primary key của bảng examquestion

INSERT INTO examquestion (ExamID, QuestionID) VALUES (1, 1);
INSERT INTO examquestion (ExamID, QuestionID) VALUES (1, 2);
INSERT INTO examquestion (ExamID, QuestionID) VALUES (2, 3);

INSERT INTO examquestion (ExamID, QuestionID) VALUES (3, 5);
INSERT INTO examquestion (ExamID, QuestionID) VALUES (4, 6);

INSERT INTO examquestion (ExamID, QuestionID) VALUES (6, 8);
INSERT INTO examquestion (ExamID, QuestionID) VALUES (7, 9);
INSERT INTO examquestion (ExamID, QuestionID) VALUES (9, 1);

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
SELECT * FROM `group`;
INSERT INTO `group` (`GroupName`, `CreatorID`, `CreateDate`	) 
VALUES 				('Mentor', 		'9', 		'2024-12-02 00:00:00');

SELECT date_sub('2023-01-01 00:00:00',INTERVAL 2 MONTH) ;   -- 
SELECT datediff(now(),'2023-01-01 00:00:00');

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"


-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

DROP TRIGGER IF EXISTS Trg_CheckBefDelExam;
DELIMITER $$
CREATE TRIGGER Trg_CheckBefDelExam
BEFORE DELETE ON exam
FOR EACH ROW
BEGIN
    DECLARE v_TwoDaysAgo DATETIME;
    
    -- Tính thời điểm 2 ngày trước
    SET v_TwoDaysAgo = DATE_SUB(NOW(), INTERVAL 2 DAY);
    
    -- Kiểm tra nếu exam được tạo trong vòng 2 ngày gần đây
    IF (OLD.CreateDate > v_TwoDaysAgo) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Không thể xóa exam mới tạo trong 2 ngày gần đây';
    END IF;
END$$
DELIMITER ;



















