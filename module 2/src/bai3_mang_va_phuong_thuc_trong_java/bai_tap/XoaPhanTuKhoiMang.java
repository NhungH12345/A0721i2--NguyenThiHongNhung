package bai3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
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

        System.out.print("Enter delete element: ");
        int num = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            //System.out.println("Position of the students in the list");
            if (arr[i] == num) {
               // System.out.printf("num+ đã có trong danh sach");
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                i--;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
