package View;

import java.io.IOException;
import java.util.Scanner;

import Controller.QuanLyHoaDon;
import Controller.QuanLyPhieuBaoCao;
import Controller.QuanLyPhieuThue;

public class QuanLyPhieuUI {
    public static Scanner input = new Scanner(System.in);

    public static void listFunctionsView() {
        System.out.println();
        System.out.println("--------- Quan Ly Giay To ---------");
        System.out.println("1.Quan Ly Hoa Don ");
        System.out.println("2.Quan Ly Phieu Thue ");
        System.out.println("3.Quan Ly Phieu Bao Cao ");
        System.out.println("0.Dang Xuat.");
        System.out.println("-----------------------------------");
    }

    public static void quanlyhoadon() throws IOException {
        QuanLyHoaDon qlhd = new QuanLyHoaDon();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("+-----Danh Sach Chuc Nang:-----+");
            System.out.println("1.Xem Danh Sach Phieu Hoa Don ");
            System.out.println("2.Thêm Phieu Hoa Don  ");
            System.out.println("3.Sua Phieu Hoa Don ");
            System.out.println("4.Xóa Phieu Hoa Don ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("--------------------------------");
            System.out.print("Moi nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> qlhd.Read();
                case 2 -> qlhd.Create();
                case 3 -> qlhd.Update();
                case 4 -> qlhd.Delete();
                case 5 -> qlhd.Search_byCategory();
                case 0 -> System.out.println("Thoát Quan Ly Phieu Hoa Don ");
                default -> System.out.println("\nBan nhap sai chuc nang. Vui long nhap lai!! \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlyphieuthue() throws IOException {
        QuanLyPhieuThue qlpt = new QuanLyPhieuThue();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("+-----Danh Sach Chuc Nang:-----+");
            System.out.println("1.Xem Danh Sach Phieu Thue ");
            System.out.println("2.Thêm Phieu Thue ");
            System.out.println("3.Sua Phieu Thue ");
            System.out.println("4.Xóa Phieu Thue ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("--------------------------------");
            System.out.print("Moi nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> qlpt.Read();
                case 2 -> qlpt.Create();
                case 3 -> qlpt.Update();
                case 4 -> qlpt.Delete();
                case 5 -> qlpt.Search_byCategory();
                case 0 -> System.out.println("Thoát Quan Ly Phieu Thue ");
                default -> System.out.println("\nBan nhap sai chuc nang. Vui long nhap lai!! \n");
            }
        } while (subCheck != 0);
    }

    public static void quanlyphieubaocao() throws IOException {
        QuanLyPhieuBaoCao qlpbc = new QuanLyPhieuBaoCao();
        int subCheck = 0;
        do {
            System.out.println();
            System.out.println("+-----Danh Sach Chuc Nang:-----+");
            System.out.println("1.Xem Danh Sach Phieu Bao Cao ");
            System.out.println("2.Thêm Phieu Bao Cao ");
            System.out.println("3.Sua Phieu Bao Cao ");
            System.out.println("4.Xóa Phieu Bao Cao ");
            System.out.println("5.Tìm Kiem");
            System.out.println("0.Thoát");
            System.out.println("--------------------------------");
            System.out.print("Moi nhap: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> qlpbc.Read();
                case 2 -> qlpbc.Create();
                case 3 -> qlpbc.Update();
                case 4 -> qlpbc.Delete();
                case 5 -> qlpbc.Search_byCategory();
                case 0 -> System.out.println("Thoát Quan Ly Phieu Bao Cao ");
                default -> System.out.println("\nBan nhap sai chuc nang. Vui long nhap lai!! \n");
            }
        } while (subCheck != 0);
    }

    public QuanLyPhieuUI() throws IOException {
        int function = 0;
        do {
            listFunctionsView();
            System.out.print("Chọn Chuc Nang: ");
            function = input.nextInt();
            switch (function) {
                case 1 -> {
                    quanlyhoadon();
                }
                case 2 -> {
                    quanlyphieuthue();
                }
                case 3 -> {
                    quanlyphieubaocao();
                }
                case 0 -> {
                    break;
                }
                default -> {
                    System.out.println("\nNhap sai chuc nang. Vui long nhap lai!!!\n");
                }
            }
        } while (function != 0);
    }
}
