package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Entity.ChiTietPhieuThue;

public class QuanLyChiTietPhieuThue extends ChiTietPhieuThue implements ControllerInterface {

    public static Scanner input = new Scanner(System.in);
    public ChiTietPhieuThue[] DSCTPT;

    public QuanLyChiTietPhieuThue() throws IOException {
        getListChiTietPhieuThue();
    }

    public ChiTietPhieuThue[] getListChiTietPhieuThue() {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietPhieuThue.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSCTPT = new ChiTietPhieuThue[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSCTPT[i] = new ChiTietPhieuThue(row[0], row[1], row[2], row[3], Integer.parseInt(row[4]));
        }
        return DSCTPT;
    }

    @Override
    public void Read() {
        System.out.println("\t\t +----DANH SACH CHI TIET PHIEU THUE----+");
        String header = String.format("| %-13s | %-9s | %-9s | %-14s | %-14s | ", "ID Phieu Thue", "ID Phòng", "Giá",
                "ID Dich Vu", "So Luong Phieu");
        System.out.format(
                "+---------------+-----------+-----------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format(
                "+---------------+-----------+-----------+----------------+----------------+%n");

        getListChiTietPhieuThue();
        for (ChiTietPhieuThue c : DSCTPT) {
            // if (DSCTPT[0].getID_PT().contains("kh")) {
            String read = String.format("| %-13s | %-9s | %-9s | %-14s | %-14s |", c.getID_PT(), c.getID_Phong(),
                    c.getGia(), c.getID_DV(), c.getSoLuong());
            System.out.println(read);
            // }
        }
        System.out.format(
                "+---------------+-----------+-----------+----------------+----------------+%n");
        waitConsole();
    }

    @Override
    public void Create() {
        System.out.println("\t\t\t\t ----NHAP THONG TIN PHIEU THUE----");
        String chuoi = DSCTPT[DSCTPT.length - 1].getID_PT();
        String so = chuoi.substring(2);
        String ID = "PT" + (Integer.parseInt(so) + 1);
        setID_PT(ID);
        System.out.println("ID phieu thue cua ban là: " + ID);
        super.nhapchitietPhieuThue();

        try {
            String input = getID_PT() + ";" + getID_Phong() + ";" + getGia() + ";" + getID_DV() + ";" + getSoLuong();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietPhieuThue.txt", input);
            System.out.println("Nhap chi tiet Phieu Thue thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update() {
        System.out.print("Nhap ID chi tiet phieu thuê can chinh sua: ");
        String ID_ChiTietPhieuThue = input.nextLine();
        ChiTietPhieuThue CT_PThue = null;

        for (ChiTietPhieuThue ChiTietPhieuThue : DSCTPT) {
            if (ChiTietPhieuThue.getID_PT().equals(ID_ChiTietPhieuThue)) {
                CT_PThue = ChiTietPhieuThue;
                break;
            }
        }

        if (CT_PThue == null) {
            System.out.println("Chi tiet phieu thuê không ton tai!");
            return;
        }

        System.out.println("\t +---THONG TIN CHI TIET PHIEU THUE TRUOC KHI CHINH SUA:---+ ");
        String header = String.format("| %-13s | %-9s | %-9s | %-14s | %-14s |", "ID phieu thuê", "ID Phòng", "Giá",
                "ID Dich Vu", "So Luong Phieu");
        System.out.format(
                "+---------------+-----------+-----------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format(
                "+---------------+-----------+-----------+----------------+----------------+%n");
        String row = String.format("| %-13s | %-9s | %-9s | %-14s | %-14s |", CT_PThue.getID_PT(),
                CT_PThue.getID_Phong(),
                CT_PThue.getGia(), CT_PThue.getID_DV(), CT_PThue.getSoLuong());
        System.out.println(row);
        System.out.format(
                "+---------------+-----------+-----------+----------------+----------------+%n");

        String[] data = new String[DSCTPT.length];

        for (int i = 0; i < DSCTPT.length; i++) {
            if (ID_ChiTietPhieuThue.equals(DSCTPT[i].getID_PT())) {
                System.out.println("Nhap thong tin chi tiet phieu thuê:");
                super.nhapchitietPhieuThue();
                DSCTPT[i].setID_Phong(getID_Phong());
                DSCTPT[i].setGia(getGia());
                DSCTPT[i].setID_DV(getID_DV());
                DSCTPT[i].setSoLuong(getSoLuong());
            }
            data[i] = DSCTPT[i].getID_PT() + ";" + DSCTPT[i].getID_Phong() + ";" + DSCTPT[i].getGia() + ";"
                    + DSCTPT[i].getID_DV() + ";" + DSCTPT[i].getSoLuong();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietPhieuThue.txt", data);
            System.out.println("Sua thông tin chi tiet phieu thuê thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete() {
        System.out.print("Nhap ID chi tiet phieu thuê can xoa: ");
        String ID_ChiTietPhieuThue = input.nextLine();
        ChiTietPhieuThue CT_PThue = null;

        for (ChiTietPhieuThue ChiTietPhieuThue : DSCTPT) {
            if (ChiTietPhieuThue.getID_PT().equals(ID_ChiTietPhieuThue)) {
                CT_PThue = ChiTietPhieuThue;
                break;
            }
        }

        if (CT_PThue == null) {
            System.out.println("ID chi tiet phieu thuê khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        for (int i = 0; i < DSCTPT.length; i++) {
            if (ID_ChiTietPhieuThue.equals(DSCTPT[i].getID_PT())) {
                DSCTPT = deleteChiTietPhieuThue(DSCTPT, i);
                break;
            }
        }
        String[] data = new String[DSCTPT.length];
        for (int i = 0; i < DSCTPT.length; i++) {
            data[i] = DSCTPT[i].getID_PT() + ";" + DSCTPT[i].getID_Phong() + ";" + DSCTPT[i].getGia() + ";"
                    + DSCTPT[i].getID_DV() + ";" + DSCTPT[i].getSoLuong();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ChiTietPhieuThue.txt", data);
            System.out.println("Xóa chi tiet phieu thuê thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChiTietPhieuThue[] deleteChiTietPhieuThue(ChiTietPhieuThue[] DSCTPT, int index) {
        ChiTietPhieuThue[] newDSCTPT = new ChiTietPhieuThue[DSCTPT.length - 1];
        for (int i = 0, j = 0; i < DSCTPT.length; i++) {
            if (i != index) {
                newDSCTPT[j++] = DSCTPT[i];
            }
        }
        return newDSCTPT;
    }

    public ChiTietPhieuThue[] addChiTietPhieuThue(ChiTietPhieuThue[] result, ChiTietPhieuThue ChiTietPhieuThue) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = ChiTietPhieuThue;
        return result;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID phieu thue: ");
        String ID_ChiTietPhieuThue = input.nextLine();
        ChiTietPhieuThue pthue = null;

        for (ChiTietPhieuThue ChiTietPhieuThue : DSCTPT) {
            if (ChiTietPhieuThue.getID_PT().equals(ID_ChiTietPhieuThue)) {
                pthue = ChiTietPhieuThue;
                break;
            }
        }

        if (pthue == null) {
            System.out.println("ID phieu thue khong ton tai. Xin vui long nhap lai!");
            return;
        }

        System.out.println("\t\t\t +---DANH SACH CHI TIET PHIEU THUE TIM DUOC: ---+");

        String header = String.format("| %-13s | %-9s | %-9s | %-14s | %-14s |", "ID phieu thuê", "ID Phòng", "Giá",
                "ID Dich Vu", "So Luong Phieu");
        System.out.format("+---------------+-----------+-----------+----------------+----------------+%n");
        System.out.println(header);
        System.out.format("+---------------+-----------+-----------+----------------+----------------+%n");
        String read = String.format("| %-13s | %-9s | %-9s | %-14s | %-14s |",
                pthue.getID_PT(),
                pthue.getID_Phong(),
                pthue.getGia(),
                pthue.getID_DV(),
                pthue.getSoLuong());

        System.out.println(read);
        System.out.format("+---------------+-----------+-----------+----------------+----------------+%n");

        waitConsole();

    }

    public void waitConsole() {
        System.out.println();
        System.out.println("An Enter de tiep tuc!!!");
        input.nextLine();
    }

}
