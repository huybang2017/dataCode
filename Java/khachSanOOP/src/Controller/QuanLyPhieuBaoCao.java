package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.PhieuBaoCao;

public class QuanLyPhieuBaoCao extends PhieuBaoCao implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public PhieuBaoCao[] DSBC;

    public QuanLyPhieuBaoCao() throws IOException {
        super();
        getPBC();
    }

    public PhieuBaoCao[] getPBC() throws IOException {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuBaoCao.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSBC = new PhieuBaoCao[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSBC[i] = new PhieuBaoCao(row[0], row[1], row[2], row[3], row[4]);
        }
        return DSBC;
    }

    public void waitConsole() {
        System.out.println("\t\t\t -An Enter de tiep tuc");
        input.nextLine();
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t +----DANH SACH PHIEU BAO CAO ----+");
        String header = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", "ID Báo Cáo ", "Tong Doanh Thu",
                "Ngày Lap", "ID Nhan Viên", "ID Quan Ly");
        System.out.format(
                "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");

        try {
            getPBC();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < DSBC.length; i++) {
            String read = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", DSBC[i].getID_BC(),
                    DSBC[i].getTongDT(),
                    DSBC[i].getNgayLap(), DSBC[i].getID_NV(), DSBC[i].getMaQl());
            System.out.println(read);
        }
        System.out.format(
                "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");

        waitConsole();
    }

    @Override
    public void Create() {
        String chuoi = DSBC[DSBC.length - 1].getID_BC();
        String so = chuoi.substring(2);
        String ma = "BC" + (Integer.parseInt(so) + 1);
        setID_BC(ma);
        System.out.println("ID phieu bao cao cua ban là: " + ma);
        LocalDate date = java.time.LocalDate.now();
        setNgayLap(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        super.nhapphieubaocao();

        try {
            String inputString = getID_BC() + ";" + getTongDT() + ";" + getNgayLap() + ";" + getID_NV() + ";"
                    + getMaQl();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuBaoCao.txt", inputString);
            System.out.println("Nhap báo cáo thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }

        waitConsole();
    }

    @Override
    public void Update() {
        try {
            System.out.println("\t\t\t\t\t +----CAP NHAT LAI THONG TIN PHIEU BAO CAO ----+");
            System.out.print("- Moi nhap ID phieu bao cao can chinh sua: ");
            String ID_PhieuBaoCao = input.nextLine();
            PhieuBaoCao pbaocao = null;

            for (PhieuBaoCao PhieuBaoCao : DSBC) {
                if (PhieuBaoCao.getID_BC().equals(ID_PhieuBaoCao)) {
                    pbaocao = PhieuBaoCao;
                    break;
                }
            }

            if (pbaocao == null) {
                System.out.println("\t\t\t\t\t -ID PHIEU BAO CAO KHONG TON TAI!");
                return;
            }
            System.out.println("\t\t\t\t\t +----THONG TIN PHIEU BAO CAO TRUOC KHI CHINH SUA----+");
            String header = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", "ID Báo Cáo ", "Tong Doanh Thu",
                    "Ngày Lap", "ID Nhan Viên", "ID Quan Ly");
            System.out.format(
                    "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");
            System.out.println(header);
            System.out.format(
                    "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");

            String read = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", pbaocao.getID_BC(),
                    pbaocao.getTongDT(),
                    pbaocao.getNgayLap(), pbaocao.getID_NV(), pbaocao.getMaQl());

            System.out.println(read);
            System.out.format(
                    "+-----------------+------------+---------------------------+-----------+------------------+--------------+------------+%n");

            String[] data = new String[DSBC.length];

            for (int i = 0; i < DSBC.length; i++) {
                if (DSBC[i].getID_BC().equals(ID_PhieuBaoCao)) {
                    System.out.println("Nhap thông tin phieu báo cáo:");
                    super.nhapphieubaocao();
                    DSBC[i].setID_BC(getID_BC());
                    DSBC[i].setTongDT(getTongDT());
                    DSBC[i].setNgayLap(getNgayLap());
                    DSBC[i].setID_NV(getID_NV());
                    DSBC[i].setMaQl(getMaQl());
                }
                data[i] = DSBC[i].getID_BC() + ";" + DSBC[i].getTongDT() + ";" + DSBC[i].getNgayLap() + ";"
                        + DSBC[i].getID_NV() + ";"
                        + DSBC[i].getMaQl();
            }
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuBaoCao.txt", data);
                System.out.println("\t\t\t\t\t+----SUA THONG TIN PHIEU BAO CAO THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t GIO TRI KHONG HOP LE, VUI LONG NHAP LAI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Delete() {
        try {
            System.out.println("\t\t\t\t\t +----XOA THONG TIN PHIEU BAO CAO ----+");
            System.out.print("-Nhap ID phieu bao cao can xóa: ");
            String ID_PhieuBaoCao = input.nextLine();

            PhieuBaoCao cur_product = null;
            for (PhieuBaoCao PhieuBaoCao : DSBC) {
                if (PhieuBaoCao.getID_BC().equals(ID_PhieuBaoCao)) {
                    cur_product = PhieuBaoCao;
                    break;
                }
            }

            if (cur_product == null) {
                System.out.println("\t\t\t\t\t - ID PHIEU BAO CAO KHÔNG TON TAI!");
                return;
            }

            for (int i = 0; i < DSBC.length; i++) {
                if (ID_PhieuBaoCao.equals(DSBC[i].getID_BC())) {
                    DSBC = deletePhieuBaoCao(DSBC, i);
                    break;
                }
            }
            String[] data = new String[DSBC.length];
            for (int i = 0; i < DSBC.length; i++) {
                data[i] = DSBC[i].getID_BC() + ";" + DSBC[i].getTongDT() + ";" + DSBC[i].getNgayLap() + ";"
                        + DSBC[i].getID_NV() + ";"
                        + DSBC[i].getMaQl();
            }
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhieuBaoCao.txt", data);
                System.out.println("\t\t\t\t\t +----XOA THONG TIN PHIEU BAO CAO THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t GIA TRI KHONG HOP LE. VUI LONG NHAP LAI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PhieuBaoCao[] deletePhieuBaoCao(PhieuBaoCao[] DSSP, int index) {
        PhieuBaoCao[] newCs = new PhieuBaoCao[DSSP.length - 1];
        for (int i = 0, j = 0; i < DSSP.length; i++) {
            if (i != index) {
                newCs[j++] = DSSP[i];
            }
        }
        return newCs;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID phieu bao cao  : ");
        String ID_PhieuBaoCao = input.nextLine();
        PhieuBaoCao pbaocao = null;

        for (PhieuBaoCao PhieuBaoCao : DSBC) {
            if (PhieuBaoCao.getID_BC().equals(ID_PhieuBaoCao)) {
                pbaocao = PhieuBaoCao;
                break;
            }
        }

        if (pbaocao == null) {
            System.out.println("ID phieu bao cao khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        System.out.println("THONG TIN PHIEU BAO CAO TIM DUOC :");
        String header = String.format("| %-15s | %-15s | %-15s | %-15s | %-15s |", "ID Báo Cáo ", "Tong Doanh Thu",
                "Ngày Lap", "ID Nhan Viên", "ID Quan Ly");
        System.out.format(
                "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");

        String read = String.format("| %-20s | %-15s | %-20s | %-15s | %-15s |", pbaocao.getID_BC(),
                pbaocao.getTongDT(),
                pbaocao.getNgayLap(), pbaocao.getID_NV(), pbaocao.getMaQl());
        System.out.println(read);
        System.out.format(
                "+----------------------+-----------------+----------------------+-----------------+-----------------+%n");

        waitConsole();
    }
}
