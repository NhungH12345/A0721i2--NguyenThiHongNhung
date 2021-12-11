USE QuanLySinhVien;
-- hiển thị sinh viên có kí tự đầu là h
select * from Student
where StudentName like "h%";
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from Class
where month(StartDate) = 12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from Subject
where Credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
select * from Student;
SET SQL_SAFE_UPDATES = 0;
update student
set ClassId= 2 where StudentName='Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select * from Student;
select * from Subject;
select * from Mark;
select Student.StudentName, Subject.SubName, Mark.Mark from Student 
inner join Subject
on Mark.SubId = Subject.SubId
inner join Mark
on Student.StudentId = Mark.StudentId
order by Mark.Mark desc , Student.StudentName asc;

