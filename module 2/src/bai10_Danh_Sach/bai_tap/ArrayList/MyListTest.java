package bai10_Danh_Sach.bai_tap.ArrayList;

import bai10_Danh_Sach.thuc_hanh.Lop_List_Don_Gian.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("bạn");
        list.add("có");
        list.add("khỏe");
        list.add("không");
        System.out.println("Danh sach da nhap la: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}