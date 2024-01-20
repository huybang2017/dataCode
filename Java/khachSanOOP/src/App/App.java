package App;

import java.io.IOException;
import java.util.Scanner;

import View.QuanLyKhachHangUI;
import View.QuanLyNhanVienUI;
import View.QuanLyPhieuUI;
import View.QuanLyPhongUI;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("WELCOME TO HOTEL MANAGEMENT SYSTEM: ");
        System.out.println("Vui long chon doi tuong quan ly :");
        System.out.println("1.Quan Ly Nhan Vien ");
        System.out.println("2.Quan Ly Khách Hàng");
        System.out.println("3.Quan Ly Giay To");
        System.out.println("4.Quan Ly Phong");
        System.out.println("----------------------------------");
        System.out.print("Chon Chuc Nang:  ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                new QuanLyNhanVienUI();
                break;

            case 2:
                new QuanLyKhachHangUI();
                break;

            case 3:
                new QuanLyPhieuUI();
                break;

            case 4:
                new QuanLyPhongUI();
                break;

            default:
                System.out.println("vui long chi chon tu 1 -> 4 !!!");
                break;
        }
    }
}
