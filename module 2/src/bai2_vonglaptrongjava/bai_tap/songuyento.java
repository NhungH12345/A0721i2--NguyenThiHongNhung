package bai2_vonglaptrongjava.bai_tap;


public class songuyento {
    public static void main(String[] args) {
        System.out.println(20+ "sô");
        int count = 0;
        int num = 2;
        String result = "";
        while (count < 20){
            // tìm số nguyên tố. khi nào đủ 20 số dừng lại
            boolean flag =true;
            if (num < 2){
                flag =false;
            }else {
                for (int i =2; i<num;i++){
                    if (num%i==0){
                        flag =false;
                        break;
                    }
                }
            }
            if (flag){
                result+= num+",";
                count++;
            }
            num++;
        }
        System.out.println(result);

    }
}
