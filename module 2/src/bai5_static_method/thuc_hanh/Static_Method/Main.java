package bai5_static_method.thuc_hanh.Static_Method;

public class Main {
    public static void main(String[] args) {
        Student.change(); //gọi phuong thức thay đổi

        //tạo đối tượng
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        //gọi phương thức hiển thị
        s1.display();
        s2.display();
        s3.display();
    }
}

