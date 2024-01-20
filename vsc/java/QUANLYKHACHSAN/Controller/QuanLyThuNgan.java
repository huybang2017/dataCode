package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.ThuNgan;

public class QuanLyThuNgan extends ThuNgan implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public ThuNgan[] DSTN;

    public QuanLyThuNgan() throws IOException {
        getListEmployee();
    }

    public ThuNgan[] getListEmployee() throws IOException {
        String[] result = Stream.read(
                "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ThuNgan.txt");
        DSTN = new ThuNgan[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSTN[i] = new ThuNgan(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4], row[5], row[6], row[7],
                    Integer.parseInt(row[8]));
        }
        return DSTN; // return
    }

    public void waitConsole() {
        System.out.println("\t\t\t\t\t\t\t\t -An Enter de tiep tuc");
        input.nextLine();
    }

    // @Override
    public void Read() {
        System.out.println("\t\t\t\t\t\t\t\t +----DANH SACH THU NGAN----+");
        String header = String.format("| %-11s | %-20s | %-4s | %-9s | %-25s | %-20s | %-13s | %-10s | %-18s |",
                "ID Thu Ngan",
                "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc", "So Hoa Don Quan Ly");
        System.out.format(
                "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");

        try {
            getListEmployee();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ThuNgan emPloyee : DSTN) {
            String read = String.format("| %-11s | %-20s | %-4s | %-9s | %-25s | %-20s | %-13s | %-10s | %-18s |",
                    emPloyee.getID_Worker(), emPloyee.getHoten(), emPloyee.getTuoi(),
                    emPloyee.getGioiTinh(), emPloyee.getDiachi(), emPloyee.getEmail(), emPloyee.getSdt(),
                    emPloyee.getShift(),
                    emPloyee.getSo_hoadon());
            System.out.println(read);

        }
        System.out.format(
                "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");
        waitConsole();
    }

    // @Override
    public void Create() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t +----NHAP THONG TIN THU NGAN----+");
            String chuoi = DSTN[DSTN.length - 1].getID_Worker();
            String so = chuoi.substring(2);
            String ID = "TN" + (Integer.parseInt(so) + 1);
            setID_Worker(ID);
            System.out.println("ID thu ngan cua ban là: " + ID);
            super.nhapthungan();

            try {
                String input = getID_Worker() + ";" + getHoten() + ";" + getTuoi() + ";" + getGioiTinh() + ";"
                        + getDiachi() + ";" + getEmail() + ";" + getSdt() + ";" + getShift() + ";" + getSo_hoadon();
                Stream.addOneLine(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ThuNgan.txt",
                        input); // database here
                System.out.println("\t\t\t\t\t\t\t\t -NHAP THU NGAN THANH CONG");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t\t\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // @Override
    public void Update() {
        try {
            System.out.println();
            System.out.print("- Moi ban nhap ID thu ngan can chinh sua: ");
            String ID_Employee = input.nextLine();
            ThuNgan employee = null;

            for (ThuNgan emPloyee : DSTN) {
                if (emPloyee.getID_Worker().equals(ID_Employee)) {
                    employee = emPloyee;
                    break;
                }
            }

            if (employee == null) {
                System.out.println("\t\t -ID THU NGAN KHONG TON TAI!");
                return;
            }

            System.out.println("\t\t\t\t\t\t\t +----THONG TIN THU NGAN TRUOC KHI DUOC CHINH SUA----+");
            String header = String.format("| %-11s | %-20s | %-4s | %-9s | %-25s | %-20s | %-13s | %-10s | %-18s |",
                    "ID Thu Ngan", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                    "So Hoa Don Quan Ly");
            System.out.format(
                    "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");
            System.out.println(header);
            System.out.format(
                    "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");
            String row = String.format("| %-11s | %-20s | %-4s | %-9s | %-25s | %-20s | %-13s | %-10s | %-18s |",
                    employee.getID_Worker(), employee.getHoten(), employee.getTuoi(), employee.getGioiTinh(),
                    employee.getDiachi(), employee.getEmail(), employee.getSdt(), employee.getSo_hoadon(),
                    employee.getShift());
            System.out.println(row);
            System.out.format(
                    "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");

            String[] data = new String[DSTN.length];

            for (int i = 0; i < DSTN.length; i++) {
                if (ID_Employee.equals(DSTN[i].getID_Worker())) {
                    System.out.println("Nhap thông tin thu ngan:");
                    super.nhapthungan();

                    DSTN[i].setHoten(getHoten());
                    DSTN[i].setGioiTinh(getGioiTinh());
                    DSTN[i].setDiachi(getDiachi());
                    DSTN[i].setEmail(getEmail());
                    DSTN[i].setTuoi(getTuoi());
                    DSTN[i].setSdt(getSdt());
                    DSTN[i].setShift(getShift());
                    DSTN[i].setSo_hoadon(getSo_hoadon());
                }
                data[i] = DSTN[i].getID_Worker() + ";" + DSTN[i].getHoten() + ";" + DSTN[i].getTuoi() + ";"
                        + DSTN[i].getGioiTinh() + ";" + DSTN[i].getDiachi() + ";" + DSTN[i].getEmail() + ";"
                        + DSTN[i].getSdt() + ";" + DSTN[i].getShift() + ";" + DSTN[i].getSo_hoadon();
            }
            try {
                Stream.addAll(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ThuNgan.txt",
                        data);
                System.out.println("\t\t\t\t\t\t\t\t----SUA THONG TIN THU NGAN THANH CONG----");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t\t\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // @Override
    public void Delete() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t +----XOA THONG TIN THU NGAN----+");
            System.out.print("\t\t\t\t\t\t\t\t -Nhap ID thu ngan can xóa: ");
            String ID_NhaDSTNien = input.nextLine();
            ThuNgan n_vien = null;

            for (ThuNgan emPloyee : DSTN) {
                if (emPloyee.getID_Worker().equals(ID_NhaDSTNien)) {
                    n_vien = emPloyee;
                    break;
                }
            }

            if (n_vien == null) {
                System.out.println("\t\t\t\t\t\t\t\t -ID THU NGAN KHONG TON TAI!");
                return;
            }

            for (int i = 0; i < DSTN.length; i++) {
                if (ID_NhaDSTNien.equals(DSTN[i].getID_Worker())) {
                    DSTN = deleteEmployee(DSTN, i);
                    break;
                }
            }

            String[] data = new String[DSTN.length];
            for (int i = 0; i < DSTN.length; i++) {
                data[i] = DSTN[i].getID_Worker() + ";" + DSTN[i].getHoten() + ";" + DSTN[i].getTuoi() + ";"
                        + DSTN[i].getGioiTinh() + ";" + DSTN[i].getDiachi() + ";" + DSTN[i].getEmail() + ";"
                        + DSTN[i].getSdt() + ";" + DSTN[i].getSo_hoadon() + ";" + DSTN[i].getShift();
            }
            try {
                Stream.addAll(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\ThuNgan.txt",
                        data);
                System.out.println("\t\t\t\t\t\t\t\t +----XOA THONG TIN THU NGAN THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhap giá tri không hop le. vui lòng nhap lai!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ThuNgan[] deleteEmployee(ThuNgan[] DSTN, int index) {
        ThuNgan[] newCs = new ThuNgan[DSTN.length - 1];
        for (int i = 0, j = 0; i < DSTN.length; i++) {
            if (i != index) {
                newCs[j++] = DSTN[i];
            }
        }
        return newCs;
    }

    public ThuNgan[] addEmployee(ThuNgan[] DSTN, ThuNgan emPloyee) {
        DSTN = Arrays.copyOf(DSTN, DSTN.length + 1);
        DSTN[DSTN.length - 1] = emPloyee;
        return DSTN;
    }

    // @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID thu ngan: ");
        String ID_TN = input.nextLine();
        ThuNgan t_ngan = null;

        for (ThuNgan TN : DSTN) {
            if (TN.getID_Worker().equals(ID_TN)) {
                t_ngan = TN;
                break;
            }
        }

        if (t_ngan == null) {
            System.out.println("ID thu ngan khong ton tai. Xin vui lòng nhap lai!");
            return;
        }
        System.out.println("\t\t\t\t\t\t\t\t +----THONG TIN THU NGAN TIM DUOC----+");
        String header = String.format("| %-11s | %-20s | %-4s | %-9s | %-25s | %-20s | %-13s | %-10s | %-18s |",
                "ID Thu Ngan", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                "So Hoa Don Quan Ly");
        System.out.format(
                "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");

        String row = String.format("| %-11s | %-20s | %-4s | %-9s | %-25s | %-20s | %-13s | %-10s | %-18s |",
                t_ngan.getID_Worker(), t_ngan.getHoten(), t_ngan.getTuoi(), t_ngan.getGioiTinh(),
                t_ngan.getDiachi(), t_ngan.getEmail(), t_ngan.getSdt(), t_ngan.getSo_hoadon(), t_ngan.getShift());
        System.out.println(row);
        System.out.format(
                "+-------------+----------------------+------+-----------+---------------------------+----------------------+---------------+------------+--------------------+%n");
        waitConsole();
    }
}
