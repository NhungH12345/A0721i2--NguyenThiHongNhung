package bai5_static_method.thuc_hanh.Static_Method;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
    //phương thức static để thay đổi giá trị của biến static
    static void change(){
        college = "CODEGYM";
    }
    //phương thức hiển thị giá trị
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
