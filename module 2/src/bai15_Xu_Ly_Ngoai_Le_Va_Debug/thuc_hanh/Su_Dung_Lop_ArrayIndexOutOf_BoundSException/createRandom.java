package bai15_Xu_Ly_Ngoai_Le_Va_Debug.thuc_hanh.Su_Dung_Lop_ArrayIndexOutOf_BoundSException;
import java.util.Random;
public class createRandom {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
}
