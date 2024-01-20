package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Entity.KhachHang;

public class QuanLyKhachHang extends KhachHang implements ControllerInterface {

    public static Scanner input = new Scanner(System.in);
    public KhachHang[] DSKH;

    public QuanLyKhachHang() throws IOException {
        super();
        getListKhachHang();
    }

    public KhachHang[] getListKhachHang() {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KhachHang.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSKH = new KhachHang[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSKH[i] = new KhachHang(row[0], row[1], Integer.parseInt(row[2]), row[3], (row[4]), row[5], row[6]);
        }
        return DSKH;
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t\t\t\t +----DANH SACH KHACH HANG----+");
        String header = String.format("| %-14s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", "ID Khách Hàng",
                "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "Sô Dien Thoai");
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");

        getListKhachHang();
        for (KhachHang c : DSKH) {
            String read = String.format("| %-14s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", c.getID_KH(),
                    c.getHoten(), c.getTuoi(), c.getGioiTinh(), c.getDiachi(), c.getEmail(), c.getSdt());
            System.out.println(read);
        }
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");
        waitConsole();
    }

    @Override
    public void Create() {
        System.out.println("\t\t\t ----NHAP THONG TIN KHACH HANG----");
        String chuoi = DSKH[DSKH.length - 1].getID_KH();
        String so = chuoi.substring(2);
        String ma = "KH" + (Integer.parseInt(so) + 1);
        setID_KH(ma);
        System.out.println("ID khach hang cua ban là: " + ma);
        super.AddThongTin();

        try {
            String input = getID_KH() + ";" + getHoten() + ";" + getTuoi() + ";" + getGioiTinh() + ";" + getDiachi()
                    + ";" + getEmail() + ";" + getSdt();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KhachHang.txt", input);
            System.out.println("Nhap khách hàng thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update() {
        System.out.println();
        System.out.print("Nhap ID khách hàng can chinh sua: ");
        String ID_KhachHang = input.nextLine();
        KhachHang k_hang = null;

        for (KhachHang KhachHang : DSKH) {
            if (KhachHang.getID_KH().equals(ID_KhachHang)) {
                k_hang = KhachHang;
                break;
            }
        }

        if (k_hang == null) {
            System.out.println("ID khách hàng khong ton tai!");
            return;
        }

        System.out.println("\t\t\t\t\t\t +----THONG TIN KHACH HANG TRUOC KHI CHINH SUA: ----+");
        String header = String.format("| %-14s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", "ID Khách Hàng",
                "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "Sô Dien Thoai",
                "Tuổi", "Giới Tính", "Địa chỉ", "Email", "Số điện thoại");
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");
        String row = String.format("| %-14s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", k_hang.getID_KH(),
                k_hang.getHoten(), k_hang.getTuoi(), k_hang.getGioiTinh(),
                k_hang.getDiachi(), k_hang.getEmail(), k_hang.getSdt());
        System.out.println(row);
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");

        String[] data = new String[DSKH.length];

        for (int i = 0; i < DSKH.length; i++) {
            if (ID_KhachHang.equals(DSKH[i].getID_KH())) {
                System.out.println();
                System.out.println("Nhap thông tin khách hàng:");
                super.AddThongTin();
                DSKH[i].setHoten(getHoten());
                DSKH[i].setGioiTinh(getGioiTinh());
                DSKH[i].setDiachi(getDiachi());
                DSKH[i].setEmail(getEmail());
                DSKH[i].setTuoi(getTuoi());
                DSKH[i].setSdt(getSdt());
            }
            data[i] = DSKH[i].getID_KH() + ";" + DSKH[i].getHoten() + ";" + DSKH[i].getTuoi() + ";"
                    + DSKH[i].getGioiTinh() + ";"
                    + DSKH[i].getDiachi() + ";" + DSKH[i].getEmail() + ";" + DSKH[i].getSdt();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KhachHang.txt", data);
            System.out.println("Sua thông tin khách hàng thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete() {
        System.out.println();
        System.out.print("Nhap ID khách hàng can xóa: ");
        String ID_KhachHang = input.nextLine();
        KhachHang k_hang = null;

        for (KhachHang KhachHang : DSKH) {
            if (KhachHang.getID_KH().equals(ID_KhachHang)) {
                k_hang = KhachHang;
                break;
            }
        }

        if (k_hang == null) {
            System.out.println("ID khách hàng khong ton tai. Xin vui lòng Nhap lại!");
            return;
        }

        for (int i = 0; i < DSKH.length; i++) {
            if (ID_KhachHang.equals(DSKH[i].getID_KH())) {
                DSKH = deleteKhachHang(DSKH, i);
                break;
            }
        }
        String[] data = new String[DSKH.length];
        for (int i = 0; i < DSKH.length; i++) {
            data[i] = DSKH[i].getID_KH() + ";" + DSKH[i].getHoten() + ";" + DSKH[i].getTuoi() + ";"
                    + DSKH[i].getGioiTinh() + ";"
                    + DSKH[i].getDiachi() + ";" + DSKH[i].getEmail() + ";" + DSKH[i].getSdt();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KhachHang.txt", data);
            System.out.println("Xóa khách hàng thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public KhachHang[] deleteKhachHang(KhachHang[] DSKH, int index) {
        KhachHang[] newDSKH = new KhachHang[DSKH.length - 1];
        for (int i = 0, j = 0; i < DSKH.length; i++) {
            if (i != index) {
                newDSKH[j++] = DSKH[i];
            }
        }
        return newDSKH;
    }

    public KhachHang[] addKhachHang(KhachHang[] result, KhachHang KhachHang) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = KhachHang;
        return result;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID khách hàng : ");
        String ID_KhachHang = input.nextLine();
        KhachHang k_hang = null;

        for (KhachHang KhachHang : DSKH) {
            if (KhachHang.getID_KH().equals(ID_KhachHang)) {
                k_hang = KhachHang;
                break;
            }
        }

        if (k_hang == null) {
            System.out.println("ID phieu thue khong ton tai. Xin vui long nhap lai!");
            return;
        }

        System.out.println("\t\t\t\t\t\t+---DANH SACH KHACH HANG TIM DUOC:---+");
        String header = String.format("| %-14s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", "ID Khách Hàng",
                "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "Sô Dien Thoai");
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");
        String read = String.format("| %-14s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |",
                k_hang.getID_KH(), k_hang.getHoten(), k_hang.getTuoi(), k_hang.getGioiTinh(),
                k_hang.getDiachi(), k_hang.getEmail(), k_hang.getSdt());
        System.out.println(read);
        System.out.format(
                "+----------------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+%n");
        waitConsole();
    }

    public void waitConsole() {
        System.out.println();
        System.out.println("An Enter de tiep tuc!!!");
        input.nextLine();
    }

}
