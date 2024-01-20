
package Entity;

import java.util.Scanner;

public class PhieuBaoCao {
    static Scanner input = new Scanner(System.in);
    private String ID_BC;
    private String TongDT;
    private String NgayLap;
    private String ID_NV;
    private String MaQl;

    public PhieuBaoCao() {
        super();
    }

    public PhieuBaoCao(String ID_BC, String TongDT, String NgayLap, String ID_NV, String MaQl) {
        super();
        this.ID_BC = ID_BC;
        this.TongDT = TongDT;
        this.NgayLap = NgayLap;
        this.ID_NV = ID_NV;
        this.MaQl = MaQl;
    }

    public String getID_BC() {
        return ID_BC;
    }

    public void setID_BC(String ID_BC) {
        this.ID_BC = ID_BC;
    }

    public String getTongDT() {
        return TongDT;
    }

    public void setTongDT(String TongDT) {
        this.TongDT = TongDT;
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

    public String getMaQl() {
        return MaQl;
    }

    public void setMaQl(String MaQl) {
        this.MaQl = MaQl;
    }

    public void nhapphieubaocao() {
        System.out.print("Nhap Tong Doanh Thu (Vd: 500.000): ");
        setTongDT(input.nextLine());
        System.out.print("Nhap ID Nhân Viên (Vd: NV??): ");
        setID_NV(input.nextLine());
        // System.out.print("Nhap Ma Quản Lý: ");
        // setMaQl(input.nextLine());
    }
}
