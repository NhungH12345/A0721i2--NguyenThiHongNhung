package bai4_lop_va_doi_tuong_trong_java.bai_tap.Xay_dung_Lop_QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a");
        double a = scanner.nextDouble();
        System.out.print("Nhập b");
        double b = scanner.nextDouble();
        System.out.print("Nhập c");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if(quadraticEquation.getDiscriminant()<0){
            System.out.println("Phương trình không có nghiệm : ");
        } else if(quadraticEquation.getDiscriminant()==0){
            System.out.println("Phương trình có một nghiệm: "+quadraticEquation.getRoot1());
        } else {
            System.out.println("Phương trình có hai nghiệm: "+quadraticEquation.getRoot1()+"và" +quadraticEquation.getRoot2());
        }




    }

    }

