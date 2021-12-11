USE QuanLySinhVien;
-- Hiển thị số lượng sinh viên ở từng nơi
select Address, count(StudentId) as 'Số lượng học viên'
from Student
group by Address;
-- Tính điểm trung bình các môn học của mỗi học viên
select Student.StudentId, Student.StudentName,Subject.SubName, avg(Mark) from Student 
inner join Mark on Student.StudentId = Mark.StudentId
inner join Subject on Mark.SubId = Subject.SubId
group by Student.StudentId, Student.StudentName, Subject.SubName;
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select S.StudentId,S.StudentName, avg(Mark)
from Student S join Mark M on S.StudentId = M.StudentId
group by S.StudentId, S.StudentName
having avg(Mark) > 15;
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select S.StudentId, S.StudentName, avg(Mark)
from Student S join Mark M on S.StudentId = M.StudentId
group by S.StudentId, S.StudentName
having avg(Mark) >= all (select avg(Mark) from Mark group by Mark.StudentId);
