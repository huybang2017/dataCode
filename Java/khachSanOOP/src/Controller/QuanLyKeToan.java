package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.KeToan;

public class QuanLyKeToan extends KeToan implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public KeToan[] DSKT;

    public QuanLyKeToan() throws IOException {
        getListEmployee();
    }

    public KeToan[] getListEmployee() throws IOException {
        String[] result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KeToan.txt");
        DSKT = new KeToan[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSKT[i] = new KeToan(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4], row[5], row[6], row[7],
                    Integer.parseInt(row[8]));
        }
        return DSKT;
    }

    public void waitConsole() {
        System.out.println("\t\t\t\t -An Enter de tiep tuc");
        input.nextLine();
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t +----DANH SACH KE TOAN----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                "ID Ke Toán",
                "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc", "So So Sách");
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        try {
            getListEmployee();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (KeToan emPloyee : DSKT) {

            String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    emPloyee.getID_Worker(), emPloyee.getHoten(), emPloyee.getTuoi(),
                    emPloyee.getGioiTinh(), emPloyee.getDiachi(), emPloyee.getEmail(), emPloyee.getSdt(),
                    emPloyee.getShift(), emPloyee.getSo_sosach());
            System.out.println(read);

        }
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }

    @Override
    public void Create() {
        try {
            System.out.println("\t\t\t\t +----NHAP THONG TIN KE TOAN----+");
            String chuoi = DSKT[DSKT.length - 1].getID_Worker();
            String so = chuoi.substring(2);
            String ID = "KT" + (Integer.parseInt(so) + 1);
            setID_Worker(ID);
            System.out.println("ID ke toán cua ban là: " + ID);
            super.nhapketoan();

            try {
                String input = getID_Worker() + ";" + getHoten() + ";" + getTuoi() + ";" + getGioiTinh() + ";"
                        + getDiachi() + ";" + getEmail() + ";" + getSdt() + ";" + getShift() + ";" + getSo_sosach();
                Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KeToan.txt", input);
                System.out.println("\t\t\t\t -NHAP KE TOAN THANH CONG");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Update() {
        try {
            System.out.println("\t\t +----CAP NHAT LAI THONG TIN KE TOAN----+");
            System.out.print("\t\t - Moi ban nhap ID ke toan can chinh sua: ");
            String ID_Employee = input.nextLine();
            KeToan employee = null;

            for (KeToan emPloyee : DSKT) {
                if (emPloyee.getID_Worker().equals(ID_Employee)) {
                    employee = emPloyee;
                    break;
                }
            }

            if (employee == null) {
                System.out.println("\t\t -ID KE TOAN KHONG TON TAI!!!");
                return;
            }

            System.out.println("\t\t\t\t\t\t +----THONG TIN KE TOAN TRUOC KHI CHINH SUA----+");
            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    "ID Ke Toán", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                    "So So Sách");
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            System.out.println(header);
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    employee.getID_Worker(), employee.getHoten(), employee.getTuoi(), employee.getGioiTinh(),
                    employee.getDiachi(), employee.getEmail(), employee.getSdt(),
                    employee.getShift(), employee.getSo_sosach());
            System.out.println(row);
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

            String[] data = new String[DSKT.length];

            for (int i = 0; i < DSKT.length; i++) {
                if (ID_Employee.equals(DSKT[i].getID_Worker())) {
                    System.out.println("Nhap thông tin ke toan:");
                    super.nhapketoan();

                    DSKT[i].setHoten(getHoten());
                    DSKT[i].setGioiTinh(getGioiTinh());
                    DSKT[i].setDiachi(getDiachi());
                    DSKT[i].setEmail(getEmail());
                    DSKT[i].setTuoi(getTuoi());
                    DSKT[i].setSdt(getSdt());
                    DSKT[i].setShift(getShift());
                    DSKT[i].setSo_sosach(getSo_sosach());
                }
                data[i] = DSKT[i].getID_Worker() + ";" + DSKT[i].getHoten() + ";" + DSKT[i].getTuoi() + ";"
                        + DSKT[i].getGioiTinh() + ";" + DSKT[i].getDiachi() + ";" + DSKT[i].getEmail() + ";"
                        + DSKT[i].getSdt() + ";" + DSKT[i].getShift() + ";" + DSKT[i].getSo_sosach();
            }
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KeToan.txt", data);
                System.out.println("\t\t\t\t----SUA THONG TIN KE TOAN THANH CONG----");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Delete() {
        try {
            System.out.println("\t\t +----XOA THONG TIN KE TOAN----+");
            System.out.print("\t\t -Nhap ID ke toan can xóa: ");
            String ID_NhaDSKTien = input.nextLine();
            KeToan n_vien = null;

            for (KeToan emPloyee : DSKT) {
                if (emPloyee.getID_Worker().equals(ID_NhaDSKTien)) {
                    n_vien = emPloyee;
                    break;
                }
            }

            if (n_vien == null) {
                System.out.println("\t\t -ID KE TOAN KHONG TON TAI!!!");
                return;
            }

            for (int i = 0; i < DSKT.length; i++) {
                if (ID_NhaDSKTien.equals(DSKT[i].getID_Worker())) {
                    DSKT = deleteEmployee(DSKT, i);
                    break;
                }
            }

            String[] data = new String[DSKT.length];
            for (int i = 0; i < DSKT.length; i++) {
                data[i] = DSKT[i].getID_Worker() + ";" + DSKT[i].getHoten() + ";" + DSKT[i].getTuoi() + ";"
                        + DSKT[i].getGioiTinh() + ";" + DSKT[i].getDiachi() + ";" + DSKT[i].getEmail() + ";"
                        + DSKT[i].getSdt() + ";" + DSKT[i].getSo_sosach() + ";" + DSKT[i].getShift();
            }
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\KeToan.txt", data);
                System.out.println("\t\t +----XOA THONG TIN KE TOAN THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhap giá tri không hop le. Vui lòng nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public KeToan[] deleteEmployee(KeToan[] DSKT, int index) {
        KeToan[] newCs = new KeToan[DSKT.length - 1];
        for (int i = 0, j = 0; i < DSKT.length; i++) {
            if (i != index) {
                newCs[j++] = DSKT[i];
            }
        }
        return newCs;
    }

    public KeToan[] addEmployee(KeToan[] DSKT, KeToan emPloyee) {
        DSKT = Arrays.copyOf(DSKT, DSKT.length + 1);
        DSKT[DSKT.length - 1] = emPloyee;
        return DSKT;
    }

    // @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID ke toan: ");
        String ID_KT = input.nextLine();
        KeToan k_toan = null;

        for (KeToan KT : DSKT) {
            if (KT.getID_Worker().equals(ID_KT)) {
                k_toan = KT;
                break;
            }
        }

        if (k_toan == null) {
            System.out.println("ID ke toan khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        System.out.println("\t\t\t\t\t\t\t +----THONG TIN KE TOAN TIM DUOC----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                "ID Ke Toán", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                "So So Sách");
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                k_toan.getID_Worker(), k_toan.getHoten(), k_toan.getTuoi(), k_toan.getGioiTinh(),
                k_toan.getDiachi(), k_toan.getEmail(), k_toan.getSdt(), k_toan.getShift(), k_toan.getSo_sosach());
        System.out.println(row);
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }
}
