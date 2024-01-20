package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.PhieuThue;

public class QuanLyPhieuThue extends PhieuThue implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public PhieuThue[] DSPT;

    public QuanLyPhieuThue() throws IOException {
        super();
        getPT();
    }

    public PhieuThue[] getPT() throws IOException {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuThue.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSPT = new PhieuThue[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSPT[i] = new PhieuThue(row[0], row[1], row[2], row[3], row[4]);
        }
        return DSPT;
    }

    public void waitConsole() {
        System.out.println("\t\t\t\t\t\t\t\t -An Enter de tiep tuc");
        input.nextLine();
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t\t +----DANH SACH PHIEU THUE----+");
        String header = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", "ID Phieu Thue", "Gia", "Ngay Lap",
                "ID Nhan Vien", "ID Khach Hang");
        System.out.format(
                "+---------------------+------------------+----------------------+-----------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+---------------------+------------------+----------------------+-----------------+-----------------+%n");

        try {
            getPT();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < DSPT.length; i++) {
            String read = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", DSPT[i].getID_PT(),
                    DSPT[i].getGia(),
                    DSPT[i].getNgayLap(), DSPT[i].getID_NV(), DSPT[i].getID_KH());
            System.out.println(read);
        }
        System.out.format(
                "+---------------------+------------------+----------------------+-----------------+-----------------+%n");

        waitConsole();
    }

    @Override
    public void Create() {
        String chuoi = DSPT[DSPT.length - 1].getID_PT();
        String so = chuoi.substring(2);
        String ma = "PT" + (Integer.parseInt(so) + 1);
        setID_PT(ma);
        System.out.println("ID phieu thue cua ban là: " + ma);
        LocalDate date = java.time.LocalDate.now();
        setNgayLap(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        super.nhapphieuthue();
        try {
            String inputString = getID_PT() + ";" + getGia() + ";" + getNgayLap() + ";" + getID_NV() + ";" + getID_KH();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuThue.txt", inputString);
            System.out.println("Nhap phieu thue thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }

        waitConsole();
    }

    @Override
    public void Update() {
        try {
            System.out.println("\t\t\t\t\t +----CAP NHAT LAI THONG TIN PHIEU THUE----+");
            System.out.print("- Moi nhap ID phieu thue can chinh sua: ");
            String ID_PhieuThue = input.nextLine();
            PhieuThue pthue = null;

            for (PhieuThue PhieuThue : DSPT) {
                if (PhieuThue.getID_PT().equals(ID_PhieuThue)) {
                    pthue = PhieuThue;
                    break;
                }
            }

            if (pthue == null) {
                System.out.println("\t\t\t\t\t -ID PHIEU THUE KHONG TON TAI!");
                return;
            }
            System.out.println("\t\t\t\t\t +----THONG TIN PHIEU THUE TRƯỚC KHI CHINH SUA----+");
            String header = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", "ID Phieu Thue", "Gia",
                    "Ngay Lap", "ID Nhan Vien", "ID Khach Hang");
            System.out.format(
                    "+---------------------+------------------+----------------------+-----------------+-----------------+%n");
            System.out.println(header);
            System.out.format(
                    "+---------------------+------------------+----------------------+-----------------+-----------------+%n");

            String read = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", pthue.getID_PT(), pthue.getGia(),
                    pthue.getNgayLap(), pthue.getID_NV(), pthue.getID_KH());

            System.out.println(read);
            System.out.format(
                    "+-----------------+------------+---------------------------+-----------+------------------+--------------+------------+%n");

            String[] data = new String[DSPT.length];

            for (int i = 0; i < DSPT.length; i++) {
                if (DSPT[i].getID_PT().equals(ID_PhieuThue)) {
                    System.out.println("Nhap thông tin phieu thue:");
                    super.nhapphieuthue();
                    DSPT[i].setID_PT(getID_PT());
                    DSPT[i].setGia(getGia());
                    DSPT[i].setNgayLap(getNgayLap());
                    DSPT[i].setID_NV(getID_NV());
                    DSPT[i].setID_KH(getID_KH());
                }
                data[i] = DSPT[i].getID_PT() + ";" + DSPT[i].getGia() + ";" + DSPT[i].getNgayLap() + ";"
                        + DSPT[i].getID_NV() + ";"
                        + DSPT[i].getID_KH();
            }
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuThue.txt", data);
                System.out.println("\t\t\t\t\t+----SUA THONG TIN PHIEU THUE THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t Gia tri khong hop le. Vui long nhap lai!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Delete() {
        try {
            System.out.println("\t\t\t\t\t +----XOA THONG TIN PHIEU THUE----+");
            System.out.print("-Nhap ID phieu thue can xóa: ");
            String ID_PhieuThue = input.nextLine();

            PhieuThue cur_product = null;
            for (PhieuThue PhieuThue : DSPT) {
                if (PhieuThue.getID_PT().equals(ID_PhieuThue)) {
                    cur_product = PhieuThue;
                    break;
                }
            }

            if (cur_product == null) {
                System.out.println("\t\t\t\t\t - ID PHIEU THUE KHONG TON TAI!");
                return;
            }

            for (int i = 0; i < DSPT.length; i++) {
                if (ID_PhieuThue.equals(DSPT[i].getID_PT())) {
                    DSPT = deletePhieuThue(DSPT, i);
                    break;
                }
            }
            String[] data = new String[DSPT.length];
            for (int i = 0; i < DSPT.length; i++) {
                data[i] = DSPT[i].getID_PT() + ";" + DSPT[i].getGia() + ";" + DSPT[i].getNgayLap() + ";"
                        + DSPT[i].getID_NV() + ";"
                        + DSPT[i].getID_KH();
            }
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuThue.txt", data);
                System.out.println("\t\t\t\t\t +----XOA THONG TIN PHIEU THUE THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t Gia tri khong hop le. Vui long nhap lai!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PhieuThue[] deletePhieuThue(PhieuThue[] DSSP, int index) {
        PhieuThue[] newCs = new PhieuThue[DSSP.length - 1];
        for (int i = 0, j = 0; i < DSSP.length; i++) {
            if (i != index) {
                newCs[j++] = DSSP[i];
            }
        }
        return newCs;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID phieu thue : ");
        String ID_PhieuThue = input.nextLine();
        PhieuThue pthue = null;

        for (PhieuThue PhieuThue : DSPT) {
            if (PhieuThue.getID_PT().equals(ID_PhieuThue)) {
                pthue = PhieuThue;
                break;
            }
        }

        if (pthue == null) {
            System.out.println("ID phieu thue khong ton tai. Xin vui long nhap lai!");
            return;
        }

        System.out.println("THONG TIN PHIEU THUE TIM DUOC:");
        String header = String.format("| %-15s | %-15s | %-15s | %-15s | %-15s |", "ID Phieu Thue", "Gia",
                "Ngay Lap", "ID Nhan Vien", "ID Khach Hang");
        System.out.format(
                "+---------------------+------------------+----------------------+-----------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+---------------------+------------------+----------------------+-----------------+-----------------+%n");

        String read = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", pthue.getID_PT(), pthue.getGia(),
                pthue.getNgayLap(), pthue.getID_NV(), pthue.getID_KH());
        System.out.println(read);
        System.out.format(
                "+---------------------+------------------+----------------------+-----------------+-----------------+%n");

        waitConsole();
    }
}
