package bai4_lop_va_doi_tuong_trong_java.bai_tap.Xay_Dung_Lop_StopWatch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100000);
        }
        Arrays.sort(numbers);
        stopWatch.stop();
        System.out.println("milisecond: " + stopWatch.getElapsedTime());
    }
}


