package thuc_hanh;
import java.util.Scanner;

public class sudungtoantu {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);// Khai báo đối tượng scanner

        System.out.printf("Enter width: ");
        width = scanner.nextFloat();// nhập chìu rộng

        System.out.println("Enter height: ");
        height = scanner.nextFloat();// nhập chìu dài
        float area = width * height;

        System.out.println("Area is: " + area);

        }
}
