package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Entity.ChiTietHoaDon;

public class QuanLyChiTietHoaDon extends ChiTietHoaDon implements ControllerInterface {

    public static Scanner input = new Scanner(System.in);
    public ChiTietHoaDon[] DSCTHD;

    public QuanLyChiTietHoaDon() throws IOException {
        getListChiTietHoaDon();
    }

    public ChiTietHoaDon[] getListChiTietHoaDon() {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietHoaDon.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSCTHD = new ChiTietHoaDon[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSCTHD[i] = new ChiTietHoaDon(row[0], row[1], row[2], row[3], row[4], row[5], row[6]);
        }
        return DSCTHD;
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t +----DANH SACH CHI TIET HOA DON----+");
        String header = String.format("| %-10s | %-9s | %-9s | %-12s | %-12s | %-14s | %-14s | ", "ID Hóa Don",
                "ID Phòng", "Giá", "Ngày Vào", "Ngày Ra", "ID Khách Hàng", "ID Nhân Viên");
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");

        getListChiTietHoaDon();
        for (ChiTietHoaDon c : DSCTHD) {
            String read = String.format("| %-10s | %-9s | %-9s | %-12s | %-12s | %-14s | %-14s |", c.getID_HD(),
                    c.getID_Phong(), c.getGia(), c.getNgayvao(), c.getNgayra(), c.getID_KH(), c.getID_NV());
            System.out.println(read);
        }
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");
        waitConsole();
    }

    @Override
    public void Create() {
        System.out.println("\t\t\t\t ----NHAP THONG TIN HOA DON----");
        String chuoi = DSCTHD[DSCTHD.length - 1].getID_HD();
        String so = chuoi.substring(2);
        String ID = "HD" + (Integer.parseInt(so) + 1);
        setID_HD(ID);
        System.out.println("ID hoa don cua ban là: " + ID);
        super.nhapchitiethoadon();

        try {
            String input = getID_HD() + ";" + getID_Phong() + ";" + getGia() + ";" + getNgayvao() + ";" + getNgayra()
                    + ";" + getID_KH() + ";" + getID_NV();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietHoaDon.txt", input);
            System.out.println("Nhap chi tiet hóa don thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update() {
        System.out.print("Nhap ID chi tiet hóa don can chinh sua: ");
        String ID_ChiTietHoaDon = input.nextLine();
        ChiTietHoaDon ct_hdon = null;

        for (ChiTietHoaDon ChiTietHoaDon : DSCTHD) {
            if (ChiTietHoaDon.getID_HD().equals(ID_ChiTietHoaDon)) {
                ct_hdon = ChiTietHoaDon;
                break;
            }
        }

        if (ct_hdon == null) {
            System.out.println("Chi tiet hóa don không ton tai!");
            return;
        }

        System.out.println("\t\t\t\t +---THONG TIN CHI TIET HOA DON TRUOC KHI CHINH SUA:---+ ");
        String header = String.format("| %-10s | %-9s | %-9s | %-12s | %-12s | %-14s | %-14s |", "ID Hóa Don",
                "ID Phòng", "Giá", "Ngày Vào", "Ngày Ra", "ID Khách Hàng", "ID Nhân Viên");
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");
        String row = String.format("| %-10s | %-9s | %-9s | %-12s | %-12s | %-14s | %-14s |", ct_hdon.getID_HD(),
                ct_hdon.getID_Phong(), ct_hdon.getGia(), ct_hdon.getNgayvao(), ct_hdon.getNgayra(), ct_hdon.getID_KH(),
                ct_hdon.getID_NV());
        System.out.println(row);
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");

        String[] data = new String[DSCTHD.length];

        for (int i = 0; i < DSCTHD.length; i++) {
            if (ID_ChiTietHoaDon.equals(DSCTHD[i].getID_HD())) {
                System.out.println("Nhap thong tin chi tiet hoa don:");
                super.nhapchitiethoadon();
                DSCTHD[i].setID_Phong(getID_Phong());
                DSCTHD[i].setGia(getGia());
                DSCTHD[i].setNgayvao(getNgayvao());
                DSCTHD[i].setNgayra(getNgayra());
                DSCTHD[i].setID_KH(getID_KH());
                DSCTHD[i].setID_NV(getID_NV());

            }
            data[i] = DSCTHD[i].getID_HD() + ";" + DSCTHD[i].getID_Phong() + ";" + DSCTHD[i].getGia() + ";"
                    + DSCTHD[i].getNgayvao() + ";" + DSCTHD[i].getNgayra() + ";" + DSCTHD[i].getID_KH() + ";"
                    + DSCTHD[i].getID_NV();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietHoaDon.txt", data);
            System.out.println("Sua thông tin chi tiet hoa don thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete() {
        System.out.print("Nhap ID chi tiet hoa don can xoa: ");
        String ID_ChiTietHoaDon = input.nextLine();
        ChiTietHoaDon ct_hdon = null;

        for (ChiTietHoaDon ChiTietHoaDon : DSCTHD) {
            if (ChiTietHoaDon.getID_HD().equals(ID_ChiTietHoaDon)) {
                ct_hdon = ChiTietHoaDon;
                break;
            }
        }

        if (ct_hdon == null) {
            System.out.println("ID chi tiet hoa don khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        for (int i = 0; i < DSCTHD.length; i++) {
            if (ID_ChiTietHoaDon.equals(DSCTHD[i].getID_HD())) {
                DSCTHD = deleteChiTietHoaDon(DSCTHD, i);
                break;
            }
        }
        String[] data = new String[DSCTHD.length];
        for (int i = 0; i < DSCTHD.length; i++) {
            data[i] = DSCTHD[i].getID_HD() + ";" + DSCTHD[i].getID_Phong() + ";" + DSCTHD[i].getGia() + ";"
                    + DSCTHD[i].getNgayvao() + ";" + DSCTHD[i].getNgayra() + ";" + DSCTHD[i].getID_KH() + ";"
                    + DSCTHD[i].getID_NV();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietHoaDon.txt", data);
            System.out.println("Xoa chi tiet hoa don thanh cong");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChiTietHoaDon[] deleteChiTietHoaDon(ChiTietHoaDon[] DSCTHD, int index) {
        ChiTietHoaDon[] newDSCTHD = new ChiTietHoaDon[DSCTHD.length - 1];
        for (int i = 0, j = 0; i < DSCTHD.length; i++) {
            if (i != index) {
                newDSCTHD[j++] = DSCTHD[i];
            }
        }
        return newDSCTHD;
    }

    public ChiTietHoaDon[] addChiTietHoaDon(ChiTietHoaDon[] result, ChiTietHoaDon ChiTietHoaDon) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = ChiTietHoaDon;
        return result;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID hoa don: ");
        String ID_HoaDon = input.nextLine();
        ChiTietHoaDon hDon = null;

        for (ChiTietHoaDon ChiTietHoaDon : DSCTHD) {
            if (ChiTietHoaDon.getID_HD().equals(ID_HoaDon)) {
                hDon = ChiTietHoaDon;
                break;
            }
        }

        if (hDon == null) {
            System.out.println("ID hoa don khong ton tai. Xin vui long nhap lai!");
            return;
        }

        System.out.println("\t\t\t +---DANH SACH CHI TIET HOA DON TIM DUOC: ---+");

        String header = String.format("| %-10s | %-9s | %-9s | %-12s | %-12s | %-14s | %-14s |", "ID Hóa Don",
                "ID Phòng", "Giá", "Ngày Vào", "Ngày Ra", "ID Khách Hàng", "ID Nhân Viên");
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");
        String read = String.format("| %-10s | %-9s | %-9s | %-12s | %-12s | %-14s | %-14s |",
                hDon.getID_HD(),
                hDon.getID_Phong(),
                hDon.getGia(),
                hDon.getNgayvao(),
                hDon.getNgayra(),
                hDon.getID_KH(),
                hDon.getID_NV());

        System.out.println(read);
        System.out.format(
                "+------------+-----------+-----------+--------------+--------------+----------------+----------------+%n");

        waitConsole();

    }

    public void waitConsole() {
        System.out.println();
        System.out.println("An Enter de tiep tuc!!!");
        input.nextLine();
    }

}
