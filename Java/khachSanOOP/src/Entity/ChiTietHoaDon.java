package Entity;

import java.util.Scanner;

public class ChiTietHoaDon {
    static Scanner input = new Scanner(System.in);
    private String ID_HD;
    private String ID_Phong;
    private String Gia;
    private String Ngayvao;
    private String Ngayra;
    private String ID_KH;
    private String ID_NV;

    public ChiTietHoaDon() {
        this.ID_HD = "";
        this.ID_Phong = "";
        this.Gia = "";
        this.Ngayvao = "";
        this.Ngayra = "";
        this.ID_KH = "";
        this.ID_NV = "";
    }

    public ChiTietHoaDon(String ID_HD, String ID_Phong, String Gia, String Ngayvao, String Ngayra, String ID_KH,
            String ID_NV) {
        this.ID_HD = ID_HD;
        this.ID_Phong = ID_Phong;
        this.Gia = Gia;
        this.Ngayvao = Ngayvao;
        this.Ngayra = Ngayra;
        this.ID_KH = ID_KH;
        this.ID_NV = ID_NV;
    }

    public String getID_HD() {
        return ID_HD;
    }

    public void setID_HD(String ID_HD) {
        this.ID_HD = ID_HD;
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

    public String getNgayvao() {
        return Ngayvao;
    }

    public String getNgayra() {
        return Ngayra;
    }

    public void setNgayvao(String Ngayvao) {
        this.Ngayvao = Ngayvao;
    }

    public void setNgayra(String Ngayra) {
        this.Ngayra = Ngayra;
    }

    public String getID_KH() {
        return ID_KH;
    }

    public void setID_KH(String ID_KH) {
        this.ID_KH = ID_KH;
    }

    public String getID_NV() {
        return ID_NV;
    }

    public void setID_NV(String ID_NV) {
        this.ID_NV = ID_NV;
    }

    public void nhapchitiethoadon() {
        System.out.print("Nhap ID Phòng (Phòng thuòng thì :P??; Phòng VIP thì :PV??): ");
        setID_Phong(input.nextLine());
        System.out.print("Nhap Tong Hóa Don (Vd: 500.000): ");
        setGia(input.nextLine());
        System.out.print("Nhap Ngày Vào (Vd: dd-mm-yyyy): ");
        setNgayvao(input.nextLine());
        System.out.print("Nhap Ngày Ra (Vd: dd-mm-yyyy):: ");
        setNgayra(input.nextLine());
        System.out.print("Nhap ID Khách Hàng (Vd: KH??): ");
        setID_KH(input.nextLine());
        System.out.print("Nhap ID Nhân Viên (Vd: NV?): ");
        setID_NV(input.nextLine());
    }
}