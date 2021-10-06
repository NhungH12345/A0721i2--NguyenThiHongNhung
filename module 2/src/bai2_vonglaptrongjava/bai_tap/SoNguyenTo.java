package bai2_vonglaptrongjava.bai_tap;

public class SoNguyenTo {
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
        int count = 0;
        int i = 2;
        while (count <= 20) {
            if (CheckPrimeNumber(i) == true) {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}