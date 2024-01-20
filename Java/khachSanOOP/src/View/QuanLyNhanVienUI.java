package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.QuanLyThuNgan;
import Controller.QuanLyKeToan;
import Controller.QuanLyTapVu;
import Controller.QuanLyLeTan;

public class QuanLyNhanVienUI {
    public static Scanner input = new Scanner(System.in);

    public static void listFunctionsView() {
        System.out.println();
        System.out.println("---------Quan Ly Nhan Vien ---------");
        System.out.println("1.Quan Ly Thu Ngan");
        System.out.println("2.Quan Ly Le Tan");
        System.out.println("3.Quan Ly Tap Vu");
        System.out.println("4.Quan Ly Ke Toán");
        System.out.println("0.Thoát Chuong Trinh.");
        System.out.println("-------------------------------------");
    }

    public QuanLyNhanVienUI() throws IOException {
        int check = 0;
        do {
            listFunctionsView();
            System.out.print("Chon Chuc Nang: ");
            check = input.nextInt();
            switch (check) {
                case 1 -> {
                    quanlythungan();
                }
                case 2 -> {
                    quanlyletan();
                }
                case 3 -> {
                    quanlytapvu();
                }
                case 4 -> {
                    quanlyketoan();
                }
                case 0 -> {
                    System.out.println("\nThoát chuong trình Quan Ly Nhan Vien thành công");
                }
                default -> {
                    System.out.println("\nNhap sai chuc nang, vui lòng nhap lai!\n");
                }
            }
        } while (check != 0);
    }

    public static void quanlythungan() throws IOException {
        QuanLyThuNgan qltn = new QuanLyThuNgan();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sach Thu Ngân: ");
            System.out.println("2.Thêm Thu Ngân: ");
            System.out.println("3.Sua Thu Ngân: ");
            System.out.println("4.Xóa Thu Ngân: ");
            System.out.println("5.Tìm Kiem : ");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qltn.Read();
                }
                case 2 -> {
                    qltn.Create();
                }
                case 3 -> {
                    qltn.Update();
                }
                case 4 -> {
                    qltn.Delete();
                }
                case 5 -> {
                    qltn.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Thu Ngân\n");
                }
                default -> System.out.println("\nBan nhap sai chuc nang, vui lòng nhap lai \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlyletan() throws IOException {
        QuanLyLeTan qllt = new QuanLyLeTan();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sách Lê Tân: ");
            System.out.println("2.Thêm Lê Tân: ");
            System.out.println("3.Sua Lê Tân: ");
            System.out.println("4.Xóa Lê Tân: ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qllt.Read();
                }
                case 2 -> {
                    qllt.Create();
                }
                case 3 -> {
                    qllt.Update();
                }
                case 4 -> {
                    qllt.Delete();
                }
                case 5 -> {
                    qllt.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Lê Tân: \n");
                }
                default -> System.out.println("\nBan Nhap sai chuc nang, vui lòng Nhap lai \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlytapvu() throws IOException {
        QuanLyTapVu qltv = new QuanLyTapVu();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sach Tap Vu: ");
            System.out.println("2.Thêm Tap Vu: ");
            System.out.println("3.Sua Tap Vu: ");
            System.out.println("4.Xóa Tap Vu: ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qltv.Read();
                }
                case 2 -> {
                    qltv.Create();
                }
                case 3 -> {
                    qltv.Update();
                }
                case 4 -> {
                    qltv.Delete();
                }
                case 5 -> {
                    qltv.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Tap Vu \n");
                }
                default -> System.out.println("\nBan Nhap sai chuc nang, vui lòng Nhap lai \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlyketoan() throws IOException {
        QuanLyKeToan qlkt = new QuanLyKeToan();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sach Ke Toán: ");
            System.out.println("2.Thêm Ke Toán: ");
            System.out.println("3.Sua Ke Toán: ");
            System.out.println("4.Xóa Ke Toán: ");
            System.out.println("5.Tìm Kiem: ");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qlkt.Read();
                }
                case 2 -> {
                    qlkt.Create();
                }
                case 3 -> {
                    qlkt.Update();
                }
                case 4 -> {
                    qlkt.Delete();
                }
                case 5 -> {
                    qlkt.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Chi Tiet Ke Toán:\n");
                }
                default -> System.out.println("\nBan nhap sai chuc nang, vui lòng nhap lai \n");
            }
        } while (subCheck != 0);
    }
}