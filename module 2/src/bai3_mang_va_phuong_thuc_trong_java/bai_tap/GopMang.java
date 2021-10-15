package bai3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int[] arr1 = {1, 2, 3, 4,7};
        int[] arr2 = {5, 6, 7, 8,9};
        int a = arr1.length;

        int b = arr2.length;

        int[] arr3 = new int[a + b];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = arr1.length, j = 0; i < arr2.length; i++, j++) {

            arr3[i] = arr2[j];
        }
        //goopj mangr dungf arraycopy

        System.arraycopy(arr1, 0, arr3, 0, a);

        System.arraycopy(arr2, 0, arr3, a, b);

        System.out.println(Arrays.toString(arr3));

    }
}
