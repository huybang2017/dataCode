package Entity;

import java.util.Scanner;

public class Phong {
    static Scanner input = new Scanner(System.in);
    private String Gia;
    private String ID_Phong;
    private String SoLuongNguoi;

    public Phong() {

    }

    public Phong(String Gia, String ID_Phong, String SoLuongNguoi) {
        this.Gia = Gia;
        this.ID_Phong = ID_Phong;
        this.SoLuongNguoi = SoLuongNguoi;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getID_Phong() {
        return ID_Phong;
    }

    public void setID_Phong(String ID_Phong) {
        this.ID_Phong = ID_Phong;
    }

    public String getSoLuongNguoi() {
        return SoLuongNguoi;
    }

    public void setSoLuongNguoi(String SoLuongNguoi) {
        this.SoLuongNguoi = SoLuongNguoi;
    }

    public void nhapThongTin() {
        System.out.println();
        System.out.print("Nhap Gia Phong (Vd: 500.000)");
        setGia(input.nextLine());
        System.out.print("Nhap So Luong Nguoi");
        setSoLuongNguoi(input.nextLine());
    }
}
