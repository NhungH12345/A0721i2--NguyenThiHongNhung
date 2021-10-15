package bai2_vong_lap_trong_java.bai_tap;

public class SoNguyenToNhoHon100 {
    public static boolean CheckPrimeNumber(int num) {
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
        System.out.println("số nguyên tố nhỏ hơn 100");
        int i = 2;
        while (i <= 100) {
            if (CheckPrimeNumber(i)) {
                System.out.println(i);
            }
            i++;
        }
    }
}
