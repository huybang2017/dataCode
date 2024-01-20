package Entity;

import java.util.Scanner;

public class PhongThuong extends Phong {
    public String DichVuCoBan;
    static Scanner input = new Scanner(System.in);
    public String NoiThatCoBan;

    public PhongThuong() {
        super();
        DichVuCoBan = "";
        NoiThatCoBan = "";
    }

    public PhongThuong(String ID_Phong, String gia, String NoiThatCoBan, String DichVuCoBan, String soLuongNguoi) {
        super(gia, ID_Phong, soLuongNguoi);
        this.DichVuCoBan = DichVuCoBan;
        this.NoiThatCoBan = NoiThatCoBan;
    }

    public String getDichVuCoBan() {
        return DichVuCoBan;
    }

    public void setDichVuCoBan(String DichVuCoBan) {
        this.DichVuCoBan = DichVuCoBan;
    }

    public String getNoiThatCoBan() {
        return NoiThatCoBan;
    }

    public void setNoiThatCoBan(String NoiThatCoBan) {
        this.NoiThatCoBan = NoiThatCoBan;
    }

    public void nhapphongthuong() {
        super.nhapThongTin();
        System.out.print("Nhap Noi That (Vd: Quat dien, Tivi, v.v.): ");
        setNoiThatCoBan(input.nextLine());
        System.out.print("Nhap Dich Vu (Vd: ID_ssage, Tour tham quan, v.v.): ");
        setDichVuCoBan(input.nextLine());
    }
}
