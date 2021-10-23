package bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Trien_Khai_Interface_Comparator_De_So_Sanh_Cac_Lop_Hinh_Hoc;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
    }
}
