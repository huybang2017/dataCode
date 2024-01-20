package Entity;

import java.util.Scanner;

public class PhongVip extends Phong {
    private String DichVuCaoCap;
    static Scanner input = new Scanner(System.in);
    private String NoiThatCaoCap;
    private String QuyenLoi;
    private String UuTien;

    public PhongVip(String ID_Phong, String gia, String NoiThatCaoCap, String DichVuCaoCap, String UuTien,
            String QuyenLoi,
            String soLuongNguoi) {
        super(gia, ID_Phong, soLuongNguoi);
        this.DichVuCaoCap = DichVuCaoCap;
        this.NoiThatCaoCap = NoiThatCaoCap;
        this.QuyenLoi = QuyenLoi;
        this.UuTien = UuTien;
    }

    public PhongVip() {
        super();
        this.DichVuCaoCap = "";
        this.NoiThatCaoCap = "";
    }

    public String getUuTien() {
        return UuTien;
    }

    public void setUuTien(String UuTien) {
        this.UuTien = UuTien;
    }

    public String getQuyenLoi() {
        return QuyenLoi;
    }

    public void setQuyenLoi(String QuyenLoi) {
        this.QuyenLoi = QuyenLoi;
    }

    public String getDichVuCaoCap() {
        return DichVuCaoCap;
    }

    public void setDichVuCaoCap(String DichVuCaoCap) {
        this.DichVuCaoCap = DichVuCaoCap;
    }

    public String getNoiThatCaoCap() {
        return NoiThatCaoCap;
    }

    public void setNoiThatCaoCap(String NoiThatCaoCap) {
        this.NoiThatCaoCap = NoiThatCaoCap;
    }

    public void nhapphongVIP() {
        super.nhapThongTin();
        System.out.print("Nhap Noi That (Vd: ID_y lanh, Nha bep, Tu lanh, v.v.): ");
        setNoiThatCaoCap(input.nextLine());
        System.out.print("Nhap Dich Vu (Vd: ID_ssage, Spa, Dua ruoc san bay, v.v.): ");
        setDichVuCaoCap(input.nextLine());
        System.out.print("Nhap Uu Tiên (Vd: View bien, View nui, v.v.): ");
        setUuTien(input.nextLine());
        System.out.print("Nhap Quyen Loi (Vd: Free wifi, Giam gia thue sau 24h, v.v.): ");
        setQuyenLoi(input.nextLine());
    }

}
