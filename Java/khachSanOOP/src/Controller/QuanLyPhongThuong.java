package Controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.PhongThuong;

public class QuanLyPhongThuong extends PhongThuong implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public PhongThuong[] DSPT;

    public QuanLyPhongThuong() throws IOException {
        super();
        getListRoom();
    }

    public PhongThuong[] getListRoom() throws IOException {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongThuong.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSPT = new PhongThuong[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSPT[i] = new PhongThuong(row[0], row[1], row[2], row[3], row[4]);
        }
        return DSPT;
    }

    public void waitConsole() {
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t -An Enter de tiep tuc!!!");
        input.nextLine();
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t\t +----DANH SACH PHONG THUONG----+");
        String header = String.format("| %-20s | %-25s | %-20s | %-20s  | %-15s |", "ID Phong",
                "Gia Phong / 1 Ngay", "Noi That", "Dich Vu", "So Nguoi");
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");

        try {
            getListRoom();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < DSPT.length; i++) {
            String read = String.format("| %-20s | %-25s | %-20s | %-20s  | %-15s |",
                    DSPT[i].getID_Phong(), DSPT[i].getGia(), DSPT[i].getNoiThatCoBan(), DSPT[i].getDichVuCoBan(),
                    DSPT[i].getSoLuongNguoi());
            System.out.println(read);
        }
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");

        waitConsole();

    }

    @Override
    public void Create() {
        String chuoi = DSPT[DSPT.length - 1].getID_Phong();
        String so = chuoi.substring(1);
        String ma = "P" + (Integer.parseInt(so) + 1);
        setID_Phong(ma);
        System.out.println("ID phong thuong cua ban là: " + ma);
        super.nhapphongthuong();

        try {
            String inputString = getID_Phong() + ";" + getGia() + ";" + getNoiThatCoBan() + ";" + getDichVuCoBan() + ";"
                    + getSoLuongNguoi();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongThuong.txt", inputString);
            System.out.println("Nhap thong tin thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }

        waitConsole();
    }

    @Override
    public void Update() {
        try {
            System.out.println("\t\t\t\t\t +----CAP NHAT LAI THONG TIN PHONG----+");
            System.out.print("- Moi nhap ID phong can chinh sua: ");
            String ID_Product = input.nextLine();
            PhongThuong s_pham = null;

            for (PhongThuong sanpham : DSPT) {
                if (sanpham.getID_Phong().equals(ID_Product)) {
                    s_pham = sanpham;
                    break;
                }
            }

            if (s_pham == null) {
                System.out.println("\t\t\t\t\t -ID PHONH KHONG TON TAI!");
                return;
            }

            System.out.println("\t\t\t\t\t +----THONG TIN PHONG TRUOC KHI CHINH SUA----+");
            String header = String.format("| %-20s | %-25s | %-20s | %-20s  | %-15s |", "ID Phong",
                    "Gia Phong / 1 Ngay", "Noi That", "Dich Vu", "So Nguoi");
            System.out.format(
                    "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");
            System.out.println(header);
            System.out.format(
                    "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");

            String read = String.format("| %-20s | %-25s | %-20s | %-20s  | %-15s |",
                    s_pham.getID_Phong(), s_pham.getGia(), s_pham.getNoiThatCoBan(),
                    s_pham.getDichVuCoBan(), s_pham.getSoLuongNguoi());

            System.out.println(read);
            System.out.format(
                    "+-----------------+------------+---------------------------+-----------+------------------+--------------+------------+%n");

            String[] data = new String[DSPT.length];

            for (int i = 0; i < DSPT.length; i++) {
                if (DSPT[i].getID_Phong().equals(ID_Product)) {
                    System.out.println("Nhap thông tin phong:");
                    super.nhapphongthuong();

                    DSPT[i].setID_Phong(getID_Phong());
                    DSPT[i].setGia(getGia());
                    DSPT[i].setNoiThatCoBan(getNoiThatCoBan());
                    DSPT[i].setDichVuCoBan(getDichVuCoBan());

                    DSPT[i].setSoLuongNguoi(getSoLuongNguoi());
                }
                data[i] = DSPT[i].getID_Phong() + ";" + DSPT[i].getGia() + ";" + DSPT[i].getNoiThatCoBan() + ";"
                        + DSPT[i].getDichVuCoBan() + ";"
                        + DSPT[i].getSoLuongNguoi();
            }

            // Cập nhật lại cả danh sách vào file
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongThuong.txt", data);
                System.out.println("\t\t\t\t\t+----SUA THONG TIN PHONG THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t Gia TRI KHONG HOP LE. VUI LONG NHAP LAI!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Delete() {
        try {
            System.out.println("\t\t\t\t\t +----XOA THONG TIN PHONG----+");
            System.out.print("-Nhap ID phong can xóa: ");
            String ID_Product = input.nextLine();

            PhongThuong cur_product = null;
            for (PhongThuong sanpham : DSPT) {
                if (sanpham.getID_Phong().equals(ID_Product)) {
                    cur_product = sanpham;
                    break;
                }
            }

            if (cur_product == null) {
                System.out.println("\t\t\t\t\t - ID PHONG KHONG TON TAI!");
                return;
            }

            for (int i = 0; i < DSPT.length; i++) {
                if (ID_Product.equals(DSPT[i].getID_Phong())) {
                    DSPT = deleteSanPham(DSPT, i);
                    break;
                }
            }
            String[] data = new String[DSPT.length];
            for (int i = 0; i < DSPT.length; i++) {
                data[i] = DSPT[i].getID_Phong() + ";" + DSPT[i].getGia() + ";" + DSPT[i].getNoiThatCoBan() + ";"
                        + DSPT[i].getDichVuCoBan() + ";"
                        + DSPT[i].getSoLuongNguoi();
            }

            // Add lại nguyên danh sách đã xóa dòng dữ liệu
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongThuong.txt", data);
                System.out.println("\t\t\t\t\t +----XOA THONG TIN PHONG THANH CONG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t GIA TRI KHONG HOP LE, VUI LONG NHAP LAI!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Xóa phần tử khỏi mảng
    public PhongThuong[] deleteSanPham(PhongThuong[] DSSP, int index) {
        PhongThuong[] newCs = new PhongThuong[DSSP.length - 1];
        for (int i = 0, j = 0; i < DSSP.length; i++) {
            if (i != index) {
                newCs[j++] = DSSP[i];
            }
        }
        return newCs;
    }

    @Override
    public void Search_byCategory() {
        System.out.print("Nhap ID Phong : ");
        String ID_HoaDon = input.nextLine();
        PhongThuong hdon = null;

        for (PhongThuong HoaDon : DSPT) {
            if (HoaDon.getID_Phong().equals(ID_HoaDon)) {
                hdon = HoaDon;
                break;
            }
        }

        if (hdon == null) {
            System.out.println("ID phong khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        System.out.println("\t\t\t\tTHONG TIN PHONG TIM DUOC:");
        String header = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s |", "ID Phong",
                "Gia Phong / 1 Ngay", "Noi That", "Dich Vu", "So Nguoi");
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");
        System.out.println(header);
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");

        String read = String.format("| %-20s | %-25s | %-20s | %-20s  | %-15s |",
                hdon.getID_Phong(), hdon.getGia(), hdon.getNoiThatCoBan(),
                hdon.getDichVuCoBan(), hdon.getSoLuongNguoi());
        System.out.println(read);
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----------------+%n");
        waitConsole();
    }

}
