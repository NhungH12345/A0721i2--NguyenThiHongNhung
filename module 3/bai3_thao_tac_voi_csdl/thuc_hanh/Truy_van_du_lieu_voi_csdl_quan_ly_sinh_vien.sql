USE QuanLySinhVien;
-- Hiển thị danh sách tất cả các học viên
select * from Student;
-- Hiển thị danh sách các học viên đang theo học.
select * from Student where Status = true;
-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from `Subject` where Credit < 10;
-- Hiển thị danh sách học viên lớp A1
select S.StudentId, S.StudentName, C.ClassName
from Student S join Class C on S.ClassId = C.ClassID
where C.ClassName = 'A1';
-- Hiển thị điểm môn CF của các học viên.
select S.StudentId, S.StudentName, Sub.SubName, M.Mark
from Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
where Sub.SubName = 'CF';