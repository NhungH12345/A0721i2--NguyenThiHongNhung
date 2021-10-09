package bai3_mangvaphuongthuctrongjava.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập size");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử thứ: " + i + ": ");
            arr[i] = scanner.nextInt();
            if (arr[i] == 0)
                break;
        }
        System.out.print("Nhập số cần chèn :");
        int X = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn : ");
        int index = scanner.nextInt();
        if (index <= 1 || index >= arr.length - 1) {
            System.out.println("không chèn được phần tử vào mảng");
        } else {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = X;

            System.out.println("Mảng sau khi thêm là");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }

    }
    }
}
