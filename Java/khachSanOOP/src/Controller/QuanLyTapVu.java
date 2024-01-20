package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.TapVu;

public class QuanLyTapVu extends TapVu implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public TapVu[] DSTV;

    public QuanLyTapVu() throws IOException {
        getListEmployee();
    }

    public TapVu[] getListEmployee() throws IOException {
        String[] result = Stream.read(
                "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\TapVu.txt");
        DSTV = new TapVu[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSTV[i] = new TapVu(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4], row[5], row[6], row[7],
                    Integer.parseInt(row[8]));
        }
        return DSTV; // return
    }

    public void waitConsole() {
        System.out.println("\t\t\t\t -An Enter de tiep tuc");
        input.nextLine();
    }

    // @Override
    public void Read() {
        System.out.println("\t\t\t\t +----DANH SÁCH TAP VU----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", "ID",
                "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc", "So Phòng Don Dep");
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
        for (TapVu emPloyee : DSTV) {

            String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    emPloyee.getID_Worker(), emPloyee.getHoten(), emPloyee.getTuoi(),
                    emPloyee.getGioiTinh(), emPloyee.getDiachi(), emPloyee.getEmail(), emPloyee.getSdt(),
                    emPloyee.getShift(),
                    emPloyee.getSo_phongdondep());
            System.out.println(read);

        }
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }

    // @Override
    public void Create() {
        try {
            System.out.println("\t\t\t\t +----NHAP THONG TIN TAP VU----+");
            String chuoi = DSTV[DSTV.length - 1].getID_Worker();
            String so = chuoi.substring(2);
            String ID = "TV" + (Integer.parseInt(so) + 1);
            setID_Worker(ID);
            System.out.println("ID tap vu cua ban là: " + ID);
            super.nhaptapvu();

            try {
                String input = getID_Worker() + ";" + getHoten() + ";" + getTuoi() + ";" + getGioiTinh() + ";"
                        + getDiachi() + ";" + getEmail() + ";" + getSdt() + ";" + getShift() + ";"
                        + getSo_phongdondep();
                Stream.addOneLine(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\TapVu.txt",
                        input); // database here
                System.out.println("\t\t\t\t -NHAP TAP VU THANH CONG");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // @Override
    public void Update() {
        try {
            System.out.println("\t\t\t\t +----CAP NHAT LAI THONG TIN TAP VU----+");
            input.nextLine();
            System.out.print("\t\t\t\t - Moi ban nhap ID tap vu can chinh sua: ");
            String ID_Employee = input.nextLine();
            TapVu employee = null;

            for (TapVu emPloyee : DSTV) {
                if (emPloyee.getID_Worker().equals(ID_Employee)) {
                    employee = emPloyee;
                    break;
                }
            }

            if (employee == null) {
                System.out.println("\t\t\t\t -ID TAP VU KHONG TON TAI!");
                return;
            }

            System.out.println("\t\t\t\t +----THONG TIN TAP VU TRUOC KHI DUOC CHINH SUA----+");
            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    "ID", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                    "So Phòng Don Dep");
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            System.out.println(header);
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    employee.getID_Worker(), employee.getHoten(), employee.getTuoi(), employee.getGioiTinh(),
                    employee.getDiachi(), employee.getEmail(), employee.getSdt(),
                    employee.getShift(), employee.getSo_phongdondep());
            System.out.println(row);
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

            String[] data = new String[DSTV.length];

            for (int i = 0; i < DSTV.length; i++) {
                if (ID_Employee.equals(DSTV[i].getID_Worker())) {
                    System.out.println("Nhap thông tin tap vu:");
                    super.nhaptapvu();

                    DSTV[i].setHoten(getHoten());
                    DSTV[i].setGioiTinh(getGioiTinh());
                    DSTV[i].setDiachi(getDiachi());
                    DSTV[i].setEmail(getEmail());
                    DSTV[i].setTuoi(getTuoi());
                    DSTV[i].setSdt(getSdt());
                    DSTV[i].setShift(getShift());
                    DSTV[i].setSo_phongdondep(getSo_phongdondep());
                }
                data[i] = DSTV[i].getID_Worker() + ";" + DSTV[i].getHoten() + ";" + DSTV[i].getTuoi() + ";"
                        + DSTV[i].getGioiTinh() + ";" + DSTV[i].getDiachi() + ";" + DSTV[i].getEmail() + ";"
                        + DSTV[i].getSdt() + ";" + DSTV[i].getShift() + ";" + DSTV[i].getSo_phongdondep();
            }
            try {
                Stream.addAll(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\TapVu.txt",
                        data);
                System.out.println("\t\t\t\t----SUA THONG TIN TAP VU THANH CONG----");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // @Override
    public void Delete() {
        try {
            System.out.println("\t\t\t\t +----XOA THONG TIN TAP VU----+");
            System.out.print("\t\t\t\t -Nhap ID tap vu can xóa: ");
            String ID_NhaDSTVien = input.nextLine();
            TapVu n_vien = null;

            for (TapVu emPloyee : DSTV) {
                if (emPloyee.getID_Worker().equals(ID_NhaDSTVien)) {
                    n_vien = emPloyee;
                    break;
                }
            }

            if (n_vien == null) {
                System.out.println("\t\t\t\t -ID TAP VU KHONG TON TAI!");
                return;
            }

            for (int i = 0; i < DSTV.length; i++) {
                if (ID_NhaDSTVien.equals(DSTV[i].getID_Worker())) {
                    DSTV = deleteEmployee(DSTV, i);
                    break;
                }
            }

            String[] data = new String[DSTV.length];
            for (int i = 0; i < DSTV.length; i++) {
                data[i] = DSTV[i].getID_Worker() + ";" + DSTV[i].getHoten() + ";" + DSTV[i].getTuoi() + ";"
                        + DSTV[i].getGioiTinh() + ";" + DSTV[i].getDiachi() + ";" + DSTV[i].getEmail() + ";"
                        + DSTV[i].getSdt() + ";" + DSTV[i].getSo_phongdondep() + ";" + DSTV[i].getShift();
            }
            try {
                Stream.addAll(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\TapVu.txt",
                        data);
                System.out.println("\t\t\t\t +----XOA THONG TIN TAP VU THANH CONG----+");
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

    public TapVu[] deleteEmployee(TapVu[] DSTV, int index) {
        TapVu[] newCs = new TapVu[DSTV.length - 1];
        for (int i = 0, j = 0; i < DSTV.length; i++) {
            if (i != index) {
                newCs[j++] = DSTV[i];
            }
        }
        return newCs;
    }

    public TapVu[] addEmployee(TapVu[] DSTV, TapVu emPloyee) {
        DSTV = Arrays.copyOf(DSTV, DSTV.length + 1);
        DSTV[DSTV.length - 1] = emPloyee;
        return DSTV;
    }

    // @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID tap vu: ");
        String ID_TV = input.nextLine();
        TapVu t_vu = null;

        for (TapVu TV : DSTV) {
            if (TV.getID_Worker().equals(ID_TV)) {
                t_vu = TV;
                break;
            }
        }

        if (t_vu == null) {
            System.out.println("ID tap vu khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        System.out.println("\t\t\t\t +----THONG TIN TAP VU TIM DUOC----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                "ID Le Tân", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                "So Phong Don Dep");
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                t_vu.getID_Worker(), t_vu.getHoten(), t_vu.getTuoi(), t_vu.getGioiTinh(),
                t_vu.getDiachi(), t_vu.getEmail(), t_vu.getSdt(), t_vu.getShift());
        System.out.println(row);
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }
}