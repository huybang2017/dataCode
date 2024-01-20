package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.QuanLyPhongThuong;
import Controller.QuanLyPhongVip;

public class QuanLyPhongUI {

    public static Scanner input = new Scanner(System.in);

    public static void listFunctionsView() {
        System.out.println();
        System.out.println("---------Quan Ly phong---------");
        System.out.println("1.Quan Ly Phòng Thuong ");
        System.out.println("2.Quan Ly Phòng VIP ");
        System.out.println("0.Thoát Chuong Trình.");
        System.out.println("-------------------------------");
    }

    public QuanLyPhongUI() throws IOException {
        int check = 0;
        do {
            listFunctionsView();
            System.out.print("Chon Chuc Nang: ");
            check = input.nextInt();
            switch (check) {
                case 1 -> {
                    quanlyphongthuong();
                }
                case 2 -> {
                    quanlyphongvip();
                }
                case 0 -> {
                    System.out.println("\nThoát chuong trình Quan Ly phong thành công");
                }
                default -> {
                    System.out.println("\nNhap sai Chuc Nang, vui lòng nhap lai!\n");
                }
            }
        } while (check != 0);
    }

    public void quanlyphongthuong() throws IOException {
        QuanLyPhongThuong qlpt = new QuanLyPhongThuong();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("+----Danh Sach Chuc Nang:-----+");
            System.out.println("1.Xem Danh Sach Phong Thuong ");
            System.out.println("2.Them Phong Thuong ");
            System.out.println("3.Sua Phong Thuong ");
            System.out.println("4.Xóa Phong Thuong ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("-------------------------------");
            System.out.print("Moi nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qlpt.Read();
                }
                case 2 -> {
                    qlpt.Create();
                }
                case 3 -> {
                    qlpt.Update();
                }
                case 4 -> {
                    qlpt.Delete();
                }
                case 5 -> {
                    qlpt.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Phong Thuong \n");
                }
                default -> System.out.println("\nBan nhap sai chuc nang, vui lòng nhap lai \n");
            }
        } while (subCheck != 0);
    }

    public void quanlyphongvip() throws IOException {
        QuanLyPhongVip qlpv = new QuanLyPhongVip();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("+----Danh Sach Chuc Nang:-----+");
            System.out.println("1.Xem Danh Sach Phong VIP ");
            System.out.println("2.Them Phong VIP ");
            System.out.println("3.Sua Phong VIP ");
            System.out.println("4.Xóa Phong VIP ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("-------------------------------");
            System.out.print("Moi nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qlpv.Read();
                }
                case 2 -> {
                    qlpv.Create();
                }
                case 3 -> {
                    qlpv.Update();
                }
                case 4 -> {
                    qlpv.Delete();
                }
                case 5 -> {
                    qlpv.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Phong VIP \n");
                }
                default -> System.out.println("\nBan nhap sai chuc nang, vui lòng nhap lai \n");
            }
        } while (subCheck != 0);
    }
}
