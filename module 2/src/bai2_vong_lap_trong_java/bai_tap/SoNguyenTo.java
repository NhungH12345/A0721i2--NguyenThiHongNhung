package bai2_vong_lap_trong_java.bai_tap;

public class SoNguyenTo {
    public static boolean checkPrimeNumber(int num) {
        if (num < 2) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        while (count <= 20) {
            if (checkPrimeNumber(i)) {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}