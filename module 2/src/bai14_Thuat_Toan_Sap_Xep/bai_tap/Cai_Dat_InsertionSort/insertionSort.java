package bai14_Thuat_Toan_Sap_Xep.bai_tap.Cai_Dat_InsertionSort;

public class insertionSort {
    public static void insertionSort(int[] list){
            int pos, x;
            for(int i = 1; i < list.length; i++){
                x = list[i];
                pos = i;
                while(pos > 0 && x < list[pos-1]){
                    list[pos] = list[pos-1]; // đổi chỗ
                    pos--;
                }
                list[pos] = x;
            }
        }
    public static void main(String[] args) {
        int[] arr = {2,3,2,5,6,1,-2,3,14,12};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    }