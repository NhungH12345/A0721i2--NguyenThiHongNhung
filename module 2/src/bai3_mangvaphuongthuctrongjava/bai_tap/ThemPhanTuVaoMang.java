package bai3_mangvaphuongthuctrongjava.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] arr;
        System.out.print("Enter a size");
        size = scanner.nextInt();
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + "\t");
        }

        System.out.print("Add element to array");
        int input_name = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            if (arr[i] == input_name) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                i++;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}
