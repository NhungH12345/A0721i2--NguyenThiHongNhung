USE QuanLySinhVien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select subject.SubId, subject.SubName , subject.status, max(Credit) from Subject;
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select Subject.SubId, Subject.SubName ,max(Mark) from Subject join Mark
on Subject.SubId = Mark.SubId;
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select Student.StudentId, Student.StudentName, avg(Mark) from Student 
join Mark on Student.StudentId = Mark.StudentId
group by Student.StudentId
order by avg(Mark) desc;