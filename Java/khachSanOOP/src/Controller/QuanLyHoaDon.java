package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.PhieuHoaDon;

public class QuanLyHoaDon extends PhieuHoaDon implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public PhieuHoaDon[] DSHD;

    public QuanLyHoaDon() throws IOException {
        super();
        getHD();
    }

    public PhieuHoaDon[] getHD() throws IOException {
        String[] result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuHoaDon.txt");
        DSHD = new PhieuHoaDon[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSHD[i] = new PhieuHoaDon(row[0], row[1], row[2], row[3], row[4], row[5]);
        }
        return DSHD;
    }

    public void waitConsole() {
        System.out.println("\t\t\t\t\t\t -An Enter de tiep tuc");
        input.nextLine();
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t\t\t +----DANH SACH HOA DON----+");
        String header = String.format("| %-10s | %-20s | %-20s | %-20s  | %-14s | %-14s |", "ID Hoa Don",
                "Tong Hoa Don", "Ngay Lap", "Phuong Thuc TT", "ID Khach Hang", "ID Nhan Vien");
        System.out.format(
                "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format(
                "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");

        try {
            getHD();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < DSHD.length; i++) {
            String read = String.format("| %-10s | %-20s | %-20s | %-20s  | %-14s | %-14s |",
                    DSHD[i].getID_HD(), DSHD[i].getTongHD(), DSHD[i].getNgayLap(), DSHD[i].getPhuongThucTT(),
                    DSHD[i].getID_NV(),
                    DSHD[i].getID_KH());
            System.out.println(read);
        }

        System.out.format(
                "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");

        waitConsole();
    }

    @Override
    public void Create() {
        String chuoi = DSHD[DSHD.length - 1].getID_HD();
        String so = chuoi.substring(2);
        String ID = "HD" + (Integer.parseInt(so) + 1);
        setID_HD(ID);
        System.out.println("ID hoa don cua ban là: " + ID);
        super.nhaphoadon();
        LocalDate date = java.time.LocalDate.now();
        setNgayLap(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        PhieuHoaDon newPhieuHoaDon = new PhieuHoaDon(getID_HD(), getTongHD(), getNgayLap(), getPhuongThucTT(),
                getID_NV(),
                getID_KH());

        try {
            String inputString = newPhieuHoaDon.getID_HD() + ";" + newPhieuHoaDon.getTongHD() + ";" +
                    newPhieuHoaDon.getNgayLap() + ";" + newPhieuHoaDon.getPhuongThucTT() + ";" +
                    newPhieuHoaDon.getID_NV() + ";" + newPhieuHoaDon.getID_KH();

            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuHoaDon.txt", inputString);
            System.out.println("Nhap hóa đơn thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }

        waitConsole();
    }

    @Override
    public void Update() {
        try {
            System.out.println("\t\t +----CẬP NHẬT LẠI THÔNG TIN HOA DON----+");
            System.out.print("- Moi nhap ID hoa don can chinh sua: ");
            String ID_Product = input.nextLine();
            PhieuHoaDon s_pham = null;

            for (PhieuHoaDon sanpham : DSHD) {
                if (sanpham.getID_HD().equals(ID_Product)) {
                    s_pham = sanpham;
                    break;
                }
            }

            if (s_pham == null) {
                System.out.println("\t\t\t\t\t -MA HOA DON KHONG TON TAI!");
                return;
            }

            System.out.println("\t\t\t\t\t\t +----THÔNG TIN HOA DON TRUOC KHI CHINH SUA----+");
            String header = String.format("| %-10s | %-20s | %-20s | %-20s  | %-14s | %-14s |", "ID Hoa Don",
                    "Tong Hoa Don", "Ngay Lap", "Phuong Thuc TT", "ID Khach Hang", "ID Nhan Vien");
            System.out.format(
                    "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");
            System.out.println(header);
            System.out.format(
                    "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");

            String read = String.format("| %-10s | %-20s | %-20s | %-20s  | %-14s | %-14s |",
                    s_pham.getID_HD(), s_pham.getTongHD(), s_pham.getNgayLap(), s_pham.getPhuongThucTT(),
                    s_pham.getID_NV(), s_pham.getID_KH());

            System.out.println(read);
            System.out.format(
                    "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");

            String[] data = new String[DSHD.length];

            for (int i = 0; i < DSHD.length; i++) {
                if (DSHD[i].getID_HD().equals(ID_Product)) {
                    System.out.println("Nhap thông tin hoa don:");
                    super.nhaphoadon();

                    DSHD[i].setID_HD(getID_HD());
                    DSHD[i].setTongHD(getTongHD());
                    DSHD[i].setNgayLap(getNgayLap());
                    DSHD[i].setPhuongThucTT(getPhuongThucTT());
                    DSHD[i].setID_NV(getID_NV());
                    DSHD[i].setID_KH(getID_KH());
                }
                data[i] = DSHD[i].getID_HD() + ";" + DSHD[i].getTongHD() + ";" + DSHD[i].getNgayLap() + ";"
                        + DSHD[i].getPhuongThucTT() + ";" + DSHD[i].getID_NV() + ";" + DSHD[i].getID_KH();
            }

            // Cập nhật lại cả danh sách vào file
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuHoaDon.txt", data);
                System.out.println("\t\t\t\t\t+----SUA THÔNG TIN HOA DON THÀNH CÔNG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Delete() {
        try {
            System.out.println("\t\t\t\t\t +----XÓA THÔNG TIN HOA DON----+");
            System.out.print("-Nhap ID hoa don can xóa: ");
            String ID_Product = input.nextLine();

            PhieuHoaDon cur_product = null;
            for (PhieuHoaDon sanpham : DSHD) {
                if (sanpham.getID_HD().equals(ID_Product)) {
                    cur_product = sanpham;
                    break;
                }
            }

            if (cur_product == null) {
                System.out.println("\t\t\t\t\t - MA HOA DON KHONG TON TAI!");
                return;
            }

            for (int i = 0; i < DSHD.length; i++) {
                if (ID_Product.equals(DSHD[i].getID_HD())) {
                    DSHD = deleteSanPham(DSHD, i);
                    break;
                }
            }
            String[] data = new String[DSHD.length];
            for (int i = 0; i < DSHD.length; i++) {
                data[i] = DSHD[i].getID_HD() + ";" + DSHD[i].getTongHD() + ";" + DSHD[i].getNgayLap() + ";"
                        + DSHD[i].getPhuongThucTT() + ";" + DSHD[i].getID_NV() + ";" + DSHD[i].getID_KH();
            }

            // Add lại nguyên danh sách đã xóa dòng dữ liệu
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuHoaDon.txt", data);
                System.out.println("\t\t\t\t\t +----XÓA THÔNG TIN HOA DON THÀNH CÔNG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PhieuHoaDon[] deleteSanPham(PhieuHoaDon[] DSSP, int index) {
        PhieuHoaDon[] newCs = new PhieuHoaDon[DSSP.length - 1];
        for (int i = 0, j = 0; i < DSSP.length; i++) {
            if (i != index) {
                newCs[j++] = DSSP[i];
            }
        }
        return newCs;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID hoa don : ");
        String ID_HoaDon = input.nextLine();
        PhieuHoaDon hdon = null;

        for (PhieuHoaDon HoaDon : DSHD) {
            if (HoaDon.getID_HD().equals(ID_HoaDon)) {
                hdon = HoaDon;
                break;
            }
        }

        if (hdon == null) {
            System.out.println("ID hoa don khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        System.out.println("\t\t\t\t\tTHONG TIN HOA DON TIM DUOC:");
        String header = String.format("| %-10s | %-20s | %-20s | %-20s  | %-14s | %-14s |", "ID Hoa Don",
                "Tong Hoa Don", "Ngay Lap", "Phuong Thuc TT", "ID Khach Hang", "ID Nhan Vien");
        System.out.format(
                "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format(
                "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");
        String read = String.format("| %-10s | %-20s | %-20s | %-20s  | %-14s | %-14s |",
                hdon.getID_HD(), hdon.getTongHD(), hdon.getNgayLap(), hdon.getPhuongThucTT(), hdon.getID_NV(),
                hdon.getID_KH());
        System.out.println(read);
        System.out.format(
                "+------------+----------------------+----------------------+-----------------------+----------------+----------------+%n");
        waitConsole();
    }
}
