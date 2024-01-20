package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.QuanLyChiTietHoaDon;
import Controller.QuanLyChiTietPhieuThue;
import Controller.QuanLyDichVu;
import Controller.QuanLyKhachHang;

public class QuanLyKhachHangUI {
    public static Scanner input = new Scanner(System.in);

    public static void listFunctionsView() {
        System.out.println();
        System.out.println("---------Quan Ly Khách Hàng ---------");
        System.out.println("1.Quan Ly Khách Hàng");
        System.out.println("2.Quan Ly Dich Vu");
        System.out.println("3.Quan Ly Chi Tiet Hoa Don");
        System.out.println("4.Quan Ly Chi Tiet Phieu Thue");
        System.out.println("0.Thoát Chuong Trinh.");
        System.out.println("-------------------------------------");
    }

    public QuanLyKhachHangUI() throws IOException {
        int check = 0;
        do {
            listFunctionsView();
            System.out.print("Chon Chuc Nang: ");
            check = input.nextInt();
            switch (check) {
                case 1 -> {
                    quanlykhachhang();
                }
                case 2 -> {
                    quanlydichvu();
                }
                case 3 -> {
                    quanlychitiethoadon();
                }
                case 4 -> {
                    quanlychitietphieuthue();
                }
                case 0 -> {
                    System.out.println("\nThoát chuong trình Quan Ly Khách Hàng thành công");
                }
                default -> {
                    System.out.println("\nNhap sai chuc nang, vui lòng nhap lai!\n");
                }
            }
        } while (check != 0);
    }

    public static void quanlykhachhang() throws IOException {
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sach Khách Hàng : ");
            System.out.println("2.Thêm Khách Hàng : ");
            System.out.println("3.Sua Khách Hàng : ");
            System.out.println("4.Xóa Khách Hàng : ");
            System.out.println("5.Tìm Kiem : ");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qlkh.Read();
                }
                case 2 -> {
                    qlkh.Create();
                }
                case 3 -> {
                    qlkh.Update();
                }
                case 4 -> {
                    qlkh.Delete();
                }
                case 5 -> {
                    qlkh.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Khách Hàng\n");
                }
                default -> System.out.println("\nBan nhap sai chuc nang, vui lòng nhap lai \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlydichvu() throws IOException {
        QuanLyDichVu qldv = new QuanLyDichVu();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sach Dich Vu ");
            System.out.println("2.Thêm Dich Vu ");
            System.out.println("3.Sua Dich Vu ");
            System.out.println("4.Xóa Dich Vu ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qldv.Read();
                }
                case 2 -> {
                    qldv.Create();
                }
                case 3 -> {
                    qldv.Update();
                }
                case 4 -> {
                    qldv.Delete();
                }
                case 5 -> {
                    qldv.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Dich Vu \n");
                }
                default -> System.out.println("\nBan Nhap sai chuc nang, vui lòng Nhap lai \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlychitiethoadon() throws IOException {
        QuanLyChiTietHoaDon qlcthd = new QuanLyChiTietHoaDon();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sach Hóa Don");
            System.out.println("2.Thêm Hóa Don");
            System.out.println("3.Sua Hóa Don");
            System.out.println("4.Xóa Hóa Don");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qlcthd.Read();
                }
                case 2 -> {
                    qlcthd.Create();
                }
                case 3 -> {
                    qlcthd.Update();
                }
                case 4 -> {
                    qlcthd.Delete();
                }
                case 5 -> {
                    qlcthd.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Chi Tiet Hoa Don \n");
                }
                default -> System.out.println("\nBan Nhap sai chuc nang, vui lòng Nhap lai \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlychitietphieuthue() throws IOException {
        QuanLyChiTietPhieuThue qlctph = new QuanLyChiTietPhieuThue();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("--------Danh Sach Chuc Nang:--------");
            System.out.println("1.Xem Danh Sach Phieu Thue ");
            System.out.println("2.Thêm Phieu Thue ");
            System.out.println("3.Sua Phieu Thue ");
            System.out.println("4.Xóa Phieu Thue");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("------------------------------------");
            System.out.print("Moi Nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                    qlctph.Read();
                }
                case 2 -> {
                    qlctph.Create();
                }
                case 3 -> {
                    qlctph.Update();
                }
                case 4 -> {
                    qlctph.Delete();
                }
                case 5 -> {
                    qlctph.Search_byCategory();
                }
                case 0 -> {
                    System.out.println("\nThoát Quan Ly Chi Tiet Phieu Thue\n");
                }
                default -> System.out.println("\nBan nhap sai chuc nang, vui lòng nhap lai \n");
            }
        } while (subCheck != 0);
    }

}
