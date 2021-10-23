package bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Trien_Khai_Interface_Comparator_De_So_Sanh_Cac_Lop_Hinh_Hoc;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
    }
}

