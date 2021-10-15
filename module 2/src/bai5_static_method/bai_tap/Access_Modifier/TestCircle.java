package bai5_static_method.bai_tap.Access_Modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println("Radius of the circle: "+circle.getRadius());
        System.out.println("Area of the circle: "+circle.getArea());

    }
}
