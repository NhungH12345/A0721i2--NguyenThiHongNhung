package bai7_Abstract_Class_Interface.bai_tap.Trien_Khai_Interface_Colorable;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}
