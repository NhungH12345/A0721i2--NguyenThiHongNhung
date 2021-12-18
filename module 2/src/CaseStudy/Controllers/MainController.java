package CaseStudy.Controllers;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean check = true;
        while (check) {
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exits");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào

            switch (scanner.nextInt()) {
                case 1: {
                    addNewServies();
                    break;
                }
                case 2: {
                    showServices();
                }
                case 3:{
                    addNewCustomer();
                    break;
                }
                case 4:{
                }
            }
        }

    }
    public static void addNewServies() {
        boolean check = true;
        while (check) {
            System.out.println("1.Add New Villa");
            System.out.println("2.Add New House");
            System.out.println("3.Add New Room");
            System.out.println("4.Back to menu");
            System.out.println("5.Exit");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào
            switch (scanner.nextInt()) {
                case 1:
            }
        }
    }

    public static void showServices() {
        boolean check = true;
        while (check) {
            System.out.println("1.Show all Villa");
            System.out.println("2.Show all House");
            System.out.println("3.Show all Room");
            System.out.println("4.Show All Name Villa Not Duplicate");
            System.out.println("5.Show All Name House Not Duplicate");
            System.out.println("6.Show All Name Name Not Duplicate");
            System.out.println("7.Back to menu");
            System.out.println("8.Exit");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào
            switch (scanner.nextInt()) {
                case 2:

            }
        }
    }
    public static void addNewCustomer() {
        boolean check = true;
        while (check) {
            System.out.println("1.Show all Villa");
            System.out.println("2.Show all House");
            System.out.println("3.Show all Room");
            System.out.println("4.Show All Name Villa Not Duplicate");
            System.out.println("5.Show All Name House Not Duplicate");
            System.out.println("6.Show All Name Name Not Duplicate");
            System.out.println("7.Back to menu");
            System.out.println("8.Exit");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào
            switch (scanner.nextInt()) {
                case 3:
            }
        }
    }
}

