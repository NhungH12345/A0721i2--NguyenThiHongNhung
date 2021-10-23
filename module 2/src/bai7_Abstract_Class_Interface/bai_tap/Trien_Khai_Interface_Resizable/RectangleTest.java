package bai7_Abstract_Class_Interface.bai_tap.Trien_Khai_Interface_Resizable;

import java.util.Random;

public class RectangleTest {
    public static void main(String[] args) {
        // Rectangle rectangle = new Rectangle();
        // System.out.println(rectangle);

        //rectangle = new Rectangle(2.3, 5.8);
        //System.out.println(rectangle);

        //rectangle = new Rectangle(2.5, 3.8, "orange", true);
        //System.out.println(rectangle);
        Random random = new Random();
        Circle[] circles = new Circle[20];
        int length = circles.length;
        // init array circle
        for (int i = 0; i < length; i++) {
            circles[i] = new Circle(10, "blue", true);
        }
        // resize
        for (int i = 0; i < length; i++) {
            System.out.println("=======================================================");
            System.out.println("Shape " + (i + 1) + " :");
            System.out.println("Area before resize: " + circles[i].getArea());
            int percent = (int) (random.nextDouble() * 100);
            System.out.println("Percent: " + percent);
            circles[i].resize(percent);
            System.out.println("Area after resize: " + circles[i].getArea());
        }
    }
}
