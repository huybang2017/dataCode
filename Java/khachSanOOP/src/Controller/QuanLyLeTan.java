package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.LeTan;

public class QuanLyLeTan extends LeTan implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public LeTan[] DSLT;

    public QuanLyLeTan() throws IOException {
        super();
        getListEmployee();
    }

    public LeTan[] getListEmployee() throws IOException {
        String[] result = Stream.read(
                "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\LeTan.txt");
        DSLT = new LeTan[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSLT[i] = new LeTan(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4], row[5], row[6], row[7],
                    Integer.parseInt(row[8]));
        }
        return DSLT; // return
    }

    public void waitConsole() {
        System.out.println("\t\t\t\t -An Enter de tiep tuc");
        input.nextLine();
    }

    // @Override
    public void Read() {
        System.out.println("\t\t\t\t +----DANH SACH LE TAN----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                "ID Le Tân",
                "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc", "So Khách Tiep Nhan");
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
        for (LeTan emPloyee : DSLT) {

            String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    emPloyee.getID_Worker(), emPloyee.getHoten(), emPloyee.getTuoi(),
                    emPloyee.getGioiTinh(), emPloyee.getDiachi(), emPloyee.getEmail(), emPloyee.getSdt(),
                    emPloyee.getShift(), emPloyee.getSo_khachtiepnhan());
            System.out.println(read);

        }
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }

    // @Override
    public void Create() {
        try {
            System.out.println("\t\t\t\t +----NHAP THONG TIN LE TAN----+");
            String chuoi = DSLT[DSLT.length - 1].getID_Worker();
            String so = chuoi.substring(2);
            String ID = "LT" + (Integer.parseInt(so) + 1);
            setID_Worker(ID);
            System.out.println("ID le tan cua ban là: " + ID);
            super.nhapletan();

            try {
                String input = getID_Worker() + ";" + getHoten() + ";" + getTuoi() + ";" + getGioiTinh() + ";"
                        + getDiachi() + ";" + getEmail() + ";" + getSdt() + ";" + getShift() + ";"
                        + getSo_khachtiepnhan();
                Stream.addOneLine(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\LeTan.txt",
                        input);
                System.out.println("\t\t\t\t -NHAP LE TAN THANH CONG");
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
            System.out.println("\t\t +----CAP NHAT LAI THONG TIN LE TAN----+");
            System.out.print("\t\t - Moi ban nhap ID le tan can chinh sua: ");
            String ID_Employee = input.nextLine();
            LeTan employee = null;

            for (LeTan emPloyee : DSLT) {
                if (emPloyee.getID_Worker().equals(ID_Employee)) {
                    employee = emPloyee;
                    break;
                }
            }

            if (employee == null) {
                System.out.println("\t\t -MA LE TAN KHONG TON TAI!");
                return;
            }

            System.out.println("\t\t\t\t\t\t +----THONG TIN LE TAN TRUOC KHI DUOC CHINH SUA----+");
            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    "ID Le Tân", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                    "So Khách Tiep Nhan");
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            System.out.println(header);
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                    employee.getID_Worker(), employee.getHoten(), employee.getTuoi(), employee.getGioiTinh(),
                    employee.getDiachi(), employee.getEmail(), employee.getSdt(),
                    employee.getShift(), employee.getSo_khachtiepnhan());
            System.out.println(row);
            System.out.format(
                    "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            String[] data = new String[DSLT.length];

            for (int i = 0; i < DSLT.length; i++) {
                if (ID_Employee.equals(DSLT[i].getID_Worker())) {
                    System.out.println("Nhap thông tin le tan:");
                    super.nhapletan();

                    DSLT[i].setHoten(getHoten());
                    DSLT[i].setGioiTinh(getGioiTinh());
                    DSLT[i].setDiachi(getDiachi());
                    DSLT[i].setEmail(getEmail());
                    DSLT[i].setTuoi(getTuoi());
                    DSLT[i].setSdt(getSdt());
                    DSLT[i].setShift(getShift());
                    DSLT[i].setSo_khachtiepnhan(getSo_khachtiepnhan());
                }
                data[i] = DSLT[i].getID_Worker() + ";" + DSLT[i].getHoten() + ";" + DSLT[i].getTuoi() + ";"
                        + DSLT[i].getGioiTinh() + ";" + DSLT[i].getDiachi() + ";" + DSLT[i].getEmail() + ";"
                        + DSLT[i].getSdt() + ";" + DSLT[i].getShift() + ";" + DSLT[i].getSo_khachtiepnhan();
            }
            try {
                Stream.addAll(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\LeTan.txt",
                        data);
                System.out.println("\t\t----SUA THONG TIN LE TAN THANH CONG----");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // @Override
    public void Delete() {
        try {
            System.out.println("\t\t +----XOA THONG TIN LE TAN----+");
            System.out.print("\t\t -Nhap ID le tan can xóa: ");
            String ID_LeTan = input.nextLine();
            LeTan l_tan = null;

            for (LeTan Letan : DSLT) {
                if (Letan.getID_Worker().equals(ID_LeTan)) {
                    l_tan = Letan;
                    break;
                }
            }

            if (l_tan == null) {
                System.out.println("\t\t -MA LE TAN KHONG TON TAI!");
                return;
            }

            for (int i = 0; i < DSLT.length; i++) {
                if (ID_LeTan.equals(DSLT[i].getID_Worker())) {
                    DSLT = deleteEmployee(DSLT, i);
                    break;
                }
            }

            String[] data = new String[DSLT.length];
            for (int i = 0; i < DSLT.length; i++) {
                data[i] = DSLT[i].getID_Worker() + ";" + DSLT[i].getHoten() + ";" + DSLT[i].getTuoi() + ";"
                        + DSLT[i].getGioiTinh() + ";" + DSLT[i].getDiachi() + ";" + DSLT[i].getEmail() + ";"
                        + DSLT[i].getSdt() + ";" + DSLT[i].getShift() + ";" + DSLT[i].getSo_khachtiepnhan();
            }
            try {
                Stream.addAll(
                        "F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\LeTan.txt",
                        data);
                System.out.println("\t\t +----XOA THONG TIN LE TAN THANH CONG----+");
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

    public LeTan[] deleteEmployee(LeTan[] DSLT, int index) {
        LeTan[] newCs = new LeTan[DSLT.length - 1];
        for (int i = 0, j = 0; i < DSLT.length; i++) {
            if (i != index) {
                newCs[j++] = DSLT[i];
            }
        }
        return newCs;
    }

    public LeTan[] addEmployee(LeTan[] DSLT, LeTan emPloyee) {
        DSLT = Arrays.copyOf(DSLT, DSLT.length + 1);
        DSLT[DSLT.length - 1] = emPloyee;
        return DSLT;
    }

    // @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID le tan: ");
        String ID_LT = input.nextLine();
        LeTan l_tan = null;

        for (LeTan LT : DSLT) {
            if (LT.getID_Worker().equals(ID_LT)) {
                l_tan = LT;
                break;
            }
        }

        if (l_tan == null) {
            System.out.println("ID le tan khong ton tai. Xin vui lòng nhap lai!");
            return;
        }
        System.out.println("\t\t\t\t\t\t\t +----THONG TIN LE TAN TIM DUOC----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                "ID Le Tân", "Ho Tên", "Tuôi", "Gioi Tính", "Dia Chi", "Email", "So Dien Thoai", "Ca Truc",
                "So Khách Tiep Nhan");
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |",
                l_tan.getID_Worker(), l_tan.getHoten(), l_tan.getTuoi(), l_tan.getGioiTinh(),
                l_tan.getDiachi(), l_tan.getEmail(), l_tan.getSdt(), l_tan.getShift());
        System.out.println(row);
        System.out.format(
                "+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }
}