package Entity;

import java.util.Scanner;

public class PhieuThue {
    static Scanner input = new Scanner(System.in);
    private String ID_PT;
    private String Gia;
    private String NgayLap;
    private String ID_KH;
    private String ID_NV;

    public PhieuThue() {
        super();
    }

    public PhieuThue(String ID_PT, String Gia, String NgayLap, String ID_KH, String ID_NV) {
        super();
        this.ID_PT = ID_PT;
        this.Gia = Gia;
        this.NgayLap = NgayLap;
        this.ID_NV = ID_NV;
        this.ID_KH = ID_KH;
    }

    public String getID_PT() {
        return ID_PT;
    }

    public void setID_PT(String ID_PT) {
        this.ID_PT = ID_PT;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getID_NV() {
        return ID_NV;
    }

    public void setID_NV(String ID_NV) {
        this.ID_NV = ID_NV;
    }

    public String getID_KH() {
        return ID_KH;
    }

    public void setID_KH(String ID_KH) {
        this.ID_KH = ID_KH;
    }

    public void nhapphieuthue() {
        System.out.print("Nhap Giá Phieu Thue (Vd: 500.000): ");
        setGia(input.nextLine());
        System.out.print("Nhap ID Nhan Vien (Vd: NV??): ");
        setID_NV(input.nextLine());
        System.out.print("Nhap ID Khach Hang (Vd: KH??): ");
        setID_KH(input.nextLine());
    }
}
