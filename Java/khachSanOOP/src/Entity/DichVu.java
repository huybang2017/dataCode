package Entity;

import java.util.Scanner;

public class DichVu {
    static Scanner input = new Scanner(System.in);
    private String ID_DV, TenDV, GiaDV;

    public DichVu() {
        ID_DV = "";
        TenDV = "";
        GiaDV = "";
    }

    public DichVu(String ID_DV, String TenDV, String GiaDV) {
        this.ID_DV = ID_DV;
        this.TenDV = TenDV;
        this.GiaDV = GiaDV;
    }

    // Hàm get set cho biến ID_DV
    public String getID_DV() {
        return ID_DV;
    }

    public void setID_DV(String ID_DV) {
        this.ID_DV = ID_DV;
    }

    // Hàm get set cho biến TenDV
    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    // Hàm get set cho biến GiaDV
    public String getGiaDV() {
        return GiaDV;
    }

    public void setGiaDV(String GiaDV) {
        this.GiaDV = GiaDV;
    }

    public void nhapdichvu() {
        System.out.print("Nhap Ten Dich Vu (Bat cu thu gi): ");
        setTenDV(input.nextLine());
        System.out.print("Nhap Gia Dich Vu (Vd: 500.000): ");
        setGiaDV(input.nextLine());
    }
}
