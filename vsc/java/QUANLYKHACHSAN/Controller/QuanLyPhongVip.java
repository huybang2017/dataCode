package Controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.PhongVip;

public class QuanLyPhongVip extends PhongVip implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public PhongVip[] DSPV;

    public QuanLyPhongVip() throws IOException {
        super();
        getListRoom();
    }

    public PhongVip[] getListRoom() throws IOException {
        String[] result = new String[0];
        try {
            result = Stream.read("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongVip.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DSPV = new PhongVip[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSPV[i] = new PhongVip(row[0], row[1], row[2], row[3], row[4], row[5], row[6]);
        }
        return DSPV;
    }

    public void waitConsole() {
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t -An Enter de tiep tuc!!!");
        input.nextLine();
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t\t +----DANH SACH PHONG VIP----+");
        String header = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |", "ID Phong",
                "Gia Phong", "Noi That", "Dich Vu", "Uu Tien", "Quyen Loi", "So Nguoi");
        System.out.format(
                "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");

        try {
            getListRoom();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < DSPV.length; i++) {
            String read = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |",
                    DSPV[i].getID_Phong(), DSPV[i].getGia(), DSPV[i].getNoiThatCaoCap(), DSPV[i].getDichVuCaoCap(),
                    DSPV[i].getUuTien(),
                    DSPV[i].getQuyenLoi(), DSPV[i].getSoLuongNguoi());
            System.out.println(read);
        }
        System.out.format(
                "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");

        waitConsole();

    }

    @Override
    public void Create() {
        String chuoi = DSPV[DSPV.length - 1].getID_Phong();
        String so = chuoi.substring(2);
        String ma = "PV" + (Integer.parseInt(so) + 1);
        setID_Phong(ma);
        System.out.println("ID phong VIP cua ban là: " + ma);
        super.nhapphongVIP();

        try {
            String inputString = getID_Phong() + ";" + getGia() + ";" + getNoiThatCaoCap() + ";" + getDichVuCaoCap()
                    + ";"
                    + getUuTien() + ";" + getQuyenLoi() + ";" + getSoLuongNguoi();
            Stream.addOneLine("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongVip.txt", inputString);
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
            PhongVip s_pham = null;

            for (PhongVip sanpham : DSPV) {
                if (sanpham.getID_Phong().equals(ID_Product)) {
                    s_pham = sanpham;
                    break;
                }
            }

            if (s_pham == null) {
                System.out.println("\t\t\t\t\t -ID PHONG KHONG TON TAI!!!");
                return;
            }

            System.out.println("\t\t\t\t\t +----THONG TIN PHONG TRUOC KHI CHINH SUA----+");
            String header = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |", "ID Phong",
                    "Gia Phong", "Noi That", "Dich Vu", "Uu Tien", "Quyen Loi", "So Nguoi");
            System.out.format(
                    "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
            System.out.println(header);
            System.out.format(
                    "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");

            String read = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |",
                    s_pham.getID_Phong(), s_pham.getGia(), s_pham.getNoiThatCaoCap(),
                    s_pham.getDichVuCaoCap(), s_pham.getUuTien(), s_pham.getQuyenLoi(), s_pham.getSoLuongNguoi());

            System.out.println(read);
            System.out.format(
                    "+-----------------+------------+---------------------------+-----------+------------------+--------------+------------+%n");

            String[] data = new String[DSPV.length];

            for (int i = 0; i < DSPV.length; i++) {
                if (DSPV[i].getID_Phong().equals(ID_Product)) {
                    System.out.println("Nhap thông tin phòng:");
                    super.nhapphongVIP();
                    DSPV[i].setID_Phong(getID_Phong());
                    DSPV[i].setGia(getGia());
                    DSPV[i].setNoiThatCaoCap(getNoiThatCaoCap());
                    DSPV[i].setDichVuCaoCap(getDichVuCaoCap());
                    DSPV[i].setUuTien(getUuTien());
                    DSPV[i].setQuyenLoi(getQuyenLoi());
                    DSPV[i].setSoLuongNguoi(getSoLuongNguoi());
                }
                data[i] = DSPV[i].getID_Phong() + ";" + DSPV[i].getGia() + ";" + DSPV[i].getNoiThatCaoCap() + ";"
                        + DSPV[i].getDichVuCaoCap() + ";" + DSPV[i].getUuTien() + ";" + DSPV[i].getQuyenLoi() + ";"
                        + DSPV[i].getSoLuongNguoi();
            }

            // Cập nhật lại cả danh sách vào file
            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongVip.txt", data);
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
            System.out.print("-Nhap ID phòng can xóa: ");
            String ID_Product = input.nextLine();

            PhongVip cur_product = null;
            for (PhongVip sanpham : DSPV) {
                if (sanpham.getID_Phong().equals(ID_Product)) {
                    cur_product = sanpham;
                    break;
                }
            }

            if (cur_product == null) {
                System.out.println("\t\t\t\t\t - ID PHONG KHONG TON TAI!");
                return;
            }

            for (int i = 0; i < DSPV.length; i++) {
                if (ID_Product.equals(DSPV[i].getID_Phong())) {
                    DSPV = deleteSanPham(DSPV, i);
                    break;
                }
            }
            String[] data = new String[DSPV.length];
            for (int i = 0; i < DSPV.length; i++) {
                data[i] = DSPV[i].getID_Phong() + ";" + DSPV[i].getGia() + ";" + DSPV[i].getNoiThatCaoCap() + ";"
                        + DSPV[i].getDichVuCaoCap() + ";" + DSPV[i].getUuTien() + ";" + DSPV[i].getQuyenLoi() + ";"
                        + DSPV[i].getSoLuongNguoi();
            }

            try {
                Stream.addAll("F:\\VSCode\\DeAnHuongDoiTuong\\QUANLYKHACHSAN\\Database\\PhongVip.txt", data);
                System.out.println("\t\t\t\t\t +----XOA THONG TIN PHONG THÀNH CÔNG----+");
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

    public PhongVip[] deleteSanPham(PhongVip[] DSSP, int index) {
        PhongVip[] newCs = new PhongVip[DSSP.length - 1];
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
        PhongVip hdon = null;

        for (PhongVip HoaDon : DSPV) {
            if (HoaDon.getID_Phong().equals(ID_HoaDon)) {
                hdon = HoaDon;
                break;
            }
        }

        if (hdon == null) {
            System.out.println("ID phong khong ton tai. Xin vui lòng nhap lai!");
            return;
        }

        System.out.println("Thông tin cu của phong:");
        String header = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |", "ID Phong",
                "Gia Phong", "Noi That", "Dich Vu", "Uu Tien", "Quyen Loi", "So Nguoi");
        System.out.format(
                "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format(
                "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");

        String read = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |",
                hdon.getID_Phong(), hdon.getGia(), hdon.getNoiThatCaoCap(),
                hdon.getDichVuCaoCap(), hdon.getUuTien(), hdon.getQuyenLoi(), hdon.getSoLuongNguoi());
        System.out.println(read);
        System.out.format(
                "+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }
}
