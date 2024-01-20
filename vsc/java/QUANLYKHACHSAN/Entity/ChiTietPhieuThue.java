package Entity;

import java.util.Scanner;

public class ChiTietPhieuThue {
    static Scanner input = new Scanner(System.in);
    private String ID_PT;
    private String ID_Phong;
    private String Gia;
    private String ID_DV;
    private int SoLuong;

    public ChiTietPhieuThue() {
        this.ID_PT = "";
        this.ID_Phong = "";
        this.Gia = "";
        this.ID_DV = "";
        this.SoLuong = 0;
    }

    public ChiTietPhieuThue(String ID_PT, String ID_Phong, String Gia, String ID_DV, int SoLuong) {
        this.ID_PT = ID_PT;
        this.ID_Phong = ID_Phong;
        this.Gia = Gia;
        this.ID_DV = ID_DV;
        this.SoLuong = SoLuong;
    }

    public String getID_PT() {
        return ID_PT;
    }

    public void setID_PT(String ID_PT) {
        this.ID_PT = ID_PT;
    }

    public String getID_Phong() {
        return ID_Phong;
    }

    public void setID_Phong(String ID_Phong) {
        this.ID_Phong = ID_Phong;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getID_DV() {
        return ID_DV;
    }

    public void setID_DV(String ID_DV) {
        this.ID_DV = ID_DV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void nhapchitietPhieuThue() {
        System.out.print("Nhap ID Phòng (Phòng thuòng thì: P??; Phòng VIP thì: PV??): ");
        setID_Phong(input.nextLine());
        System.out.print("Nhap Tong Phieu Thuê (Vd: 500.000): ");
        setGia(input.nextLine());
        System.out.print("Nhap ID Dich Vu (Vd: DV??): ");
        setID_DV(input.nextLine());
        System.out.print("Nhap So Luong Phieu: ");
        setSoLuong(input.nextInt());
    }
}