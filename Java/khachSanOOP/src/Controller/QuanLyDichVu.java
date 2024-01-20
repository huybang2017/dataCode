package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Entity.DichVu;

public class QuanLyDichVu extends DichVu implements ControllerInterface {

    public static Scanner input = new Scanner(System.in);
    public DichVu[] DSDV;

    public QuanLyDichVu() throws IOException {
        getListDichVu();
    }

    public DichVu[] getListDichVu() {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\DichVu.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSDV = new DichVu[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSDV[i] = new DichVu(row[0], row[1], row[2]);
        }
        return DSDV;
    }

    @Override
    public void Read() {
        System.out.println("\t\t +----DANH SACH DICH VU----+");
        String header = String.format("| %-10s | %-35s | %-11s |", "ID Dich Vu", "Tên Dich Vu", "Giá Dich Vu");
        System.out.format("+------------+-------------------------------------+-------------+%n");
        System.out.println(header);
        System.out.format("+------------+-------------------------------------+-------------+%n");

        getListDichVu();
        for (DichVu c : DSDV) {
            String read = String.format("| %-10s | %-35s | %-11s |", c.getID_DV(), c.getTenDV(), c.getGiaDV());
            System.out.println(read);
        }
        System.out.format("+------------+-------------------------------------+-------------+%n");
        waitConsole();
    }

    @Override
    public void Create() {
        System.out.println("\t\t ----NHAP THONG TIN DICH VU----");
        String chuoi = DSDV[DSDV.length - 1].getID_DV();
        String so = chuoi.substring(2);
        String ID = "DV" + (Integer.parseInt(so) + 1);
        setID_DV(ID);
        System.out.println("ID dich vu cua ban là: " + ID);
        super.nhapdichvu();

        try {
            String input = getID_DV() + ";" + getTenDV() + ";" + getGiaDV();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\DichVu.txt", input);
            System.out.println("Nhap dich vu thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update() {
        String ID_DichVu = input.nextLine();
        DichVu d_vu = null;

        for (DichVu DichVu : DSDV) {
            if (DichVu.getID_DV().equals(ID_DichVu)) {
                d_vu = DichVu;
                break;
            }
        }

        if (d_vu == null) {
            System.out.println("dich vu không ton tai!");
            return;
        }

        System.out.println("Thông tin dich vu: ");
        System.out.println("\t\t +----DANH SACH DICH VU TRUOC KHI CHINH SUA----+");
        String header = String.format("| %-10s | %-35s | %-11s |", "ID Dich Vu", "Tên Dich Vu", "Giá Dich Vu");
        System.out.format("+------------+-------------------------------------+-------------+%n");
        System.out.println(header);
        System.out.format("+------------+-------------------------------------+-------------+%n");
        String row = String.format("| %-10s | %-35s | %-11s |", d_vu.getID_DV(), d_vu.getTenDV(), d_vu.getGiaDV());
        System.out.println(row);
        System.out.format("+------------+-------------------------------------+-------------+%n");

        String[] data = new String[DSDV.length];

        for (int i = 0; i < DSDV.length; i++) {
            if (ID_DichVu.equals(DSDV[i].getID_DV())) {
                System.out.println("Nhap thông tin dich vu:");
                super.nhapdichvu();
                DSDV[i].setTenDV(getTenDV());
                DSDV[i].setGiaDV(getGiaDV());
            }
            data[i] = DSDV[i].getID_DV() + ";" + DSDV[i].getTenDV() + ";" + DSDV[i].getGiaDV();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\DichVu.txt", data);
            System.out.println("Sua thông tin dich vu thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete() {
        System.out.print("Nhap ID dich vu can xóa: ");
        String ID_DichVu = input.nextLine();
        DichVu d_vu = null;

        for (DichVu DichVu : DSDV) {
            if (DichVu.getID_DV().equals(ID_DichVu)) {
                d_vu = DichVu;
                break;
            }
        }

        if (d_vu == null) {
            System.out.println("ID dich vu không ton tai. Xin vui lòng nhap lai!");
            return;
        }

        for (int i = 0; i < DSDV.length; i++) {
            if (ID_DichVu.equals(DSDV[i].getID_DV())) {
                DSDV = deleteDichVu(DSDV, i);
                break;
            }
        }
        String[] data = new String[DSDV.length];
        for (int i = 0; i < DSDV.length; i++) {
            data[i] = DSDV[i].getID_DV() + ";" + DSDV[i].getTenDV() + ";" + DSDV[i].getGiaDV();
        }
        try {
            Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\DichVu.txt", data);
            System.out.println("Xóa dich vu thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DichVu[] deleteDichVu(DichVu[] DSDV, int index) {
        DichVu[] newCs = new DichVu[DSDV.length - 1];
        for (int i = 0, j = 0; i < DSDV.length; i++) {
            if (i != index) {
                newCs[j++] = DSDV[i];
            }
        }
        return newCs;
    }

    public DichVu[] addDichVu(DichVu[] result, DichVu DichVu) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = DichVu;
        return result;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID dich vu: ");
        String ID_DichVu = input.nextLine();
        DichVu dvu = null;

        for (DichVu DichVu : DSDV) {
            if (DichVu.getID_DV().equals(ID_DichVu)) {
                dvu = DichVu;
                break;
            }
        }

        if (dvu == null) {
            System.out.println("ID phieu thue khong ton tai. Xin vui long nhap lai!");
            return;
        }

        System.out.println("\t\t +---DANH SACH DICH VU TIM DUOC: ---+");

        String header = String.format("| %-10s | %-35s | %-11s |", "ID Dich Vu", "Tên Dich Vu", "Giá Dich Vu");
        System.out.format("+------------+-------------------------------------+-------------+%n");
        System.out.println(header);
        System.out.format("+------------+-------------------------------------+-------------+%n");
        String read = String.format("| %-10s | %-35s | %-11s |",
                dvu.getID_DV(),
                dvu.getTenDV(),
                dvu.getGiaDV());
        System.out.println(read);
        System.out.format("+------------+-------------------------------------+-------------+%n");

        waitConsole();

    }

    public void waitConsole() {
        System.out.println();
        System.out.println("An Enter de tiep tuc!!!");
        input.nextLine();
    }

}
